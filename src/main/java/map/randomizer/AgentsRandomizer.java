package map.randomizer;

import agent.IAgent;
import map.Map;
import resources.Resources;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 15.04.12
 * Time: 14:18
 */
public class AgentsRandomizer extends Randomizer {
    public void fillCellsWithRandomAgents(Map map) throws InstantiationException, IllegalAccessException {
        java.util.Map<Class, Integer> agentsProbabilityMap = Resources.getInstance().getAgentsProbabilities();
        java.util.Map<ProbabilityPair, Class> probabilityPairClassMap = getProbabilityPairMapByProbabilityMap(agentsProbabilityMap);
        for (int i = 0; i != map.getWidth().intValue(); i++) {
            for (int j = 0; j != map.getHeight().intValue(); j++) {
                if (map.cellIsEligibleForAgent(i, j)) {
                    IAgent randomAgentBasedOnProbability = (IAgent) getRandomFieldBasedOnProbability(probabilityPairClassMap);
                    if (randomAgentBasedOnProbability != null) {
                        randomAgentBasedOnProbability.setX(i);
                        randomAgentBasedOnProbability.setY(j);
                        map.getAgents().add(randomAgentBasedOnProbability);
                    }
                }
            }
        }
    }
}
