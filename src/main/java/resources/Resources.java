package resources;

import agent.Agent;
import au.com.bytecode.opencsv.CSVReader;
import entities.Empty;
import entities.Food;
import entities.Rock;
import map.randomizer.MapRandomizer;
import map.randomizer.ProbabilitySumException;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 27.02.12
 * Time: 22:03
 */
public class Resources {
    private Properties imagesProperties;
    private Properties interfaceProperties;
    private Properties applicationProperties;
    private static final Logger log = Logger.getLogger(Resources.class);
    private CSVReader fieldsProbabilityFileReader;
    private CSVReader agentsProbabilityFileReader;
    private Map<String, BufferedImage> images;
    private static final String[] entityKeys = {"empty", "food", "rock","agent"};

    public Properties getInterfaceProperties() {
        return interfaceProperties;
    }

    public Properties getImagesProperties() {
        return imagesProperties;
    }

    public Properties getApplicationProperties() {
        return applicationProperties;
    }

    //todo Close File Readers!
    private Resources() {
        log.info("Resources Initialization Started");
        imagesProperties = new Properties();
        interfaceProperties = new Properties();
        applicationProperties = new Properties();
        try {
            imagesProperties.load(new BufferedInputStream(this.getClass().getResourceAsStream("/images/images.properties")));//classpath-relative path
            interfaceProperties.load(new BufferedInputStream(this.getClass().getResourceAsStream("/interface/interface.properties")));
            applicationProperties.load(new BufferedInputStream(this.getClass().getResourceAsStream("/application.properties")));
        } catch (IOException e) {
            log.error(e);
        }
        try {
            fieldsProbabilityFileReader = new CSVReader(new FileReader(this.getClass().getResource("/map/fields.csv").getPath().replaceAll("%20", " ")), ';', '\'', 1);
            agentsProbabilityFileReader = new CSVReader(new FileReader(this.getClass().getResource("/agents/agents.csv").getPath().replaceAll("%20", " ")), ';', '\'', 1);
            images = getFilledImagesMap();
        } catch (FileNotFoundException e) {
            log.error(e);
        }
    }

    private Map<String, BufferedImage> getFilledImagesMap() {
        Map<String, BufferedImage> result = new HashMap<String, BufferedImage>();
        Map<String, String> imagesPathMap = getFilledImagePathMap();
        for (Map.Entry<String, String> entry : imagesPathMap.entrySet()) {
            BufferedImage img = null;
            URL url = this.getClass().getResource(imagesPathMap.get(entry.getKey()));
            try {
                img = ImageIO.read(url);
            } catch (IOException e) {
                log.error(e);
            }
            result.put(entry.getKey(), img);
        }
        return result;
    }

    private Map<String, String> getFilledImagePathMap() {
        Map<String, String> result = new HashMap<String, String>();
        for (String entityKey : Arrays.asList(entityKeys)) {
            result.put(entityKey, imagesProperties.getProperty(entityKey));
        }
        return result;
    }

    public BufferedImage getImage(String imgKey) {
        return images.get(imgKey);
    }

    //todo redo this part. Add Factory pattern.
    public Map<Class, Integer> getAgentsProbabilities() {
        Map<Class, Integer> result = new HashMap<Class, Integer>();
        List<String[]> entries = null;
        try {
            entries = agentsProbabilityFileReader.readAll();
        } catch (IOException e) {
            log.error(e);
        }
        for (String[] entry : entries) {
            if (entry[0].equals("agent")) {
                result.put(Agent.class, Integer.valueOf(entry[1]));
            }
        }
        return result;
    }

    private static class ResourceHolder {
        private final static Resources resources = new Resources();
    }

    public static Resources getInstance() {
        return ResourceHolder.resources;
    }

    //todo redo this part. Add Factory pattern.
    public Map<Class, Integer> getFieldsProbabilities() {
        Integer probabilitiesSum = 0;
        Map<Class, Integer> result = new HashMap<Class, Integer>();
        List<String[]> entries = null;
        try {
            entries = fieldsProbabilityFileReader.readAll();
        } catch (IOException e) {
            log.error(e);
        }
        for (String[] entry : entries) {
            if (entry[0].equals("empty")) {
                probabilitiesSum += Integer.valueOf(entry[1]);
                result.put(Empty.class, Integer.valueOf(entry[1]));
            } else if (entry[0].equals("food")) {
                result.put(Food.class, Integer.valueOf(entry[1]));
                probabilitiesSum += Integer.valueOf(entry[1]);
            } else if (entry[0].equals("rock")) {
                result.put(Rock.class, Integer.valueOf(entry[1]));
                probabilitiesSum += Integer.valueOf(entry[1]);
            }
        }
        try {
            checkProbabilitySum(probabilitiesSum);
        } catch (ProbabilitySumException e) {
            log.error(e);
        }
        return result;
    }

    private void checkProbabilitySum(Integer probabilitiesSum) throws ProbabilitySumException {
        if (probabilitiesSum.intValue() != MapRandomizer.PROBABILITY_SUM) {
            throw new ProbabilitySumException("Probability sum is not " + MapRandomizer.PROBABILITY_SUM);
        }
    }
}
