package laddergame.domain.ladder;

import laddergame.Factory;

import static laddergame.domain.ladder.RandomPositionGenerator.generate;

public class LadderFactory implements Factory {
    private static final LadderFactory LADDER_FACTORY = new LadderFactory();

    private LadderFactory() {

    }

    public static LadderFactory of() {
        return LADDER_FACTORY;
    }

    public Ladder create(final LadderHeight height, final int width) {
        Ladder ladder = new Ladder(height, width);
        connectBridgeRandomly(ladder);
        return ladder;
    }

    private void connectBridgeRandomly(Ladder ladder) {
        final int height = ladder.getHeight();
        final int width = ladder.getWidth();
        final int count = height * width;
        for (int i = 0; i < count; i++) {
            ladder.connectBridge(generate(height, width));
        }
    }
}