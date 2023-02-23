import common.cache.LadderResultCacheManager;
import engine.LadderEngine;
import generator.BridgeGenerator;
import generator.LineGenerator;
import generator.RandomBridgeGenerator;

public class LadderApplication {

    public static void main(String[] args) {
        BridgeGenerator bridgeGenerator = new RandomBridgeGenerator();
        LineGenerator lineGenerator = new LineGenerator(bridgeGenerator);
        LadderResultCacheManager ladderResultCacheManager = new LadderResultCacheManager();

        LadderEngine ladderEngine = new LadderEngine(lineGenerator, ladderResultCacheManager);

        ladderEngine.start();
    }
}
