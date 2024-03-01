package domain;

import java.util.List;
import java.util.function.Supplier;

public class LadderGame {
    private final Players players;
    private final Gifts gifts;
    private final Supplier<Boolean[]> ladderMakeStrategy;
    private final int ladderHeight;

    //Todo: 매개 변수 너무 많음
    private LadderGame(Players players, Gifts gifts, Supplier<Boolean[]> ladderMakeStrategy, int ladderHeight) {
        validateRequiredValues(players, gifts, ladderMakeStrategy);
        this.players = players;
        this.gifts = gifts;
        this.ladderMakeStrategy = ladderMakeStrategy;
        this.ladderHeight = ladderHeight;
    }

    private void validateRequiredValues(Players players, Gifts gifts, Supplier<Boolean[]> ladderMakeStrategy) {
        if (players == null || gifts == null || ladderMakeStrategy == null) {
            throw new IllegalStateException("필수 값이 설정되지 않았습니다.");
        }
    }

    public LadderGameResults start(String operator) {
        return new LadderGameResults(List.of(new LadderGameResult("a", "b")));
    }

    public static final class LadderGameBuilder {
        private Players players;
        private Gifts gifts;
        private Supplier<Boolean[]> ladderMakeStrategy;
        private int ladderHeight;

        private LadderGameBuilder() {
        }

        public static LadderGameBuilder builder() {
            return new LadderGameBuilder();
        }

        public LadderGameBuilder players(String... playerNames) {
            this.players = Players.of(playerNames);
            return this;
        }

        public LadderGameBuilder gifts(String... giftNames) {
            this.gifts = Gifts.of(giftNames);
            return this;
        }

        public LadderGameBuilder ladderMakeStrategy(Supplier<Boolean[]> ladderMakeStrategy) {
            this.ladderMakeStrategy = ladderMakeStrategy;
            return this;
        }

        public LadderGameBuilder ladderHeight(int ladderHeight) {
            this.ladderHeight = ladderHeight;
            return this;
        }

        public LadderGame build() {
            return new LadderGame(players, gifts, ladderMakeStrategy, ladderHeight);
        }
    }
}
