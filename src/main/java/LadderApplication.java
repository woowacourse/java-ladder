import engine.LadderEngine;
import generator.BridgeGenerator;
import generator.LineGenerator;
import generator.RandomBridgeGenerator;

public class LadderApplication {

    public static void main(String[] args) {
        BridgeGenerator bridgeGenerator = new RandomBridgeGenerator();
        LineGenerator lineGenerator = new LineGenerator(bridgeGenerator);
        LadderEngine ladderEngine = new LadderEngine(lineGenerator);

        ladderEngine.start();
    }
}
