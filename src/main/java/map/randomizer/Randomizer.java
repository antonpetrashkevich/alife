package map.randomizer;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 15.04.12
 * Time: 14:32
 */
public class Randomizer {
    public static final int PROBABILITY_SUM = 100;
    private Random random = new Random();

    protected Random getRandom() {
        return random;
    }

    protected java.util.Map<ProbabilityPair, Class> getProbabilityPairMapByProbabilityMap(java.util.Map<Class, Integer> fieldsProbabilityMap) {
        java.util.Map<ProbabilityPair, Class> result = new HashMap<ProbabilityPair, Class>();
        Integer upperBound = 0;
        Integer lowerBound = 0;
        for (java.util.Map.Entry<Class, Integer> entry : fieldsProbabilityMap.entrySet()) {
            upperBound += entry.getValue();
            result.put(new ProbabilityPair(lowerBound, upperBound), entry.getKey());
            lowerBound = upperBound;
        }
        return result;
    }

    protected Object getRandomFieldBasedOnProbability(java.util.Map<ProbabilityPair, Class> fieldsProbabilityMap) throws IllegalAccessException, InstantiationException {
        Integer randomValue = getRandom().nextInt(PROBABILITY_SUM);
        for (java.util.Map.Entry<ProbabilityPair, Class> entry : fieldsProbabilityMap.entrySet()) {
            if (randomValue <= entry.getKey().getUpperBound() && randomValue >= entry.getKey().getLowerBound()) {
                return entry.getValue().newInstance();
            }
        }
        return null;
    }
}
