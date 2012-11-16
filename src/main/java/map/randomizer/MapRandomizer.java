package map.randomizer;

import entities.Field;
import map.Map;
import resources.Resources;


/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 03.03.12
 * Time: 18:10
 */
public class MapRandomizer<T extends Field> extends Randomizer {

    public void fillCellsWithRandomFields(Map map) throws InstantiationException, IllegalAccessException {
        java.util.Map<Class, Integer> fieldsProbabilityMap = Resources.getInstance().getFieldsProbabilities();
        java.util.Map<ProbabilityPair, Class> probabilityPairClassMap = getProbabilityPairMapByProbabilityMap(fieldsProbabilityMap);
        for (int i = 0; i != map.getWidth().intValue(); i++) {
            for (int j = 0; j != map.getHeight().intValue(); j++) {
                Field randomFieldBasedOnProbability = (Field) getRandomFieldBasedOnProbability(probabilityPairClassMap);
                randomFieldBasedOnProbability.setX(i);
                randomFieldBasedOnProbability.setY(j);
                map.getCells().add(randomFieldBasedOnProbability);
            }
        }
    }


}
