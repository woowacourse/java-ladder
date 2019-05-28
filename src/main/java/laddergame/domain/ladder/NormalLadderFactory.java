package laddergame.domain.ladder;

import laddergame.LadderFactory;

import static laddergame.domain.ladder.RandomPositionGenerator.generate;

public class NormalLadderFactory implements LadderFactory {
    private static final NormalLadderFactory LADDER_FACTORY = new NormalLadderFactory();

    private NormalLadderFactory() {

    }

    public static NormalLadderFactory getInstance() {
        return LADDER_FACTORY;
    }

    private void connectBridgeRandomly(Ladder ladder) {
        final int height = ladder.getHeight();
        final int width = ladder.getWidth();
        final int count = height * width;
        for (int i = 0; i < count; i++) {
            ladder.connectBridge(generate(height, width));
        }
    }

    @Override
    public Ladder create(final LadderHeight height, final int width) {
        Ladder ladder = new Ladder(height, width);
        connectBridgeRandomly(ladder);
        return ladder;
    }
}