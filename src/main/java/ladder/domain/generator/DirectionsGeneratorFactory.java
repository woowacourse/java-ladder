package ladder.domain.generator;

enum DirectionsStrategyID {RANDOM}

public class DirectionsGeneratorFactory {
    public static DirectionsGenerator getInstance(int countOfPlayer) {
        return getInstance(countOfPlayer, DirectionsStrategyID.RANDOM);
    }

    public static DirectionsGenerator getInstance(int countOfPlayer, DirectionsStrategyID strategyID) {
        if (strategyID == DirectionsStrategyID.RANDOM) {
            return new DirectionsRandomGenerator(countOfPlayer);
        }
        throw new IllegalArgumentException();
    }
}
