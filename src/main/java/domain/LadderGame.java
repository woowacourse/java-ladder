package domain;

import dto.LadderGameResult;
import dto.LadderGameResults;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LadderGame {
    private final Players players;
    private final Gifts gifts;
    private final Supplier<Boolean[]> ladderMakeStrategy;
    private final Integer ladderHeight;

    private final Ladder ladder;

    //Todo: 매개 변수 너무 많음
    private LadderGame(Players players, Gifts gifts, Supplier<Boolean[]> ladderMakeStrategy, int ladderHeight) {
        validateRequiredValues(players, gifts, ladderMakeStrategy, ladderHeight);
        this.players = players;
        this.gifts = gifts;
        this.ladderMakeStrategy = ladderMakeStrategy;
        this.ladderHeight = ladderHeight;
        List<Line> lines = IntStream.range(0, ladderHeight)
                .mapToObj(value -> new Line(ladderMakeStrategy.get()))
                .toList();
        this.ladder = new Ladder(lines);
    }

    private void validateRequiredValues(Players players, Gifts gifts, Supplier<Boolean[]> ladderMakeStrategy,
                                        Integer ladderHeight) {
        if (players == null || gifts == null || ladderMakeStrategy == null || ladderHeight == null) {
            throw new IllegalStateException("필수 값이 설정되지 않았습니다.");
        }
    }

    public LadderGameResults start(String operator) {
        validateOperator(operator);
        LadderGameResult ladderGameResult = generateLadderGameResult(operator);
        return LadderGameResults.of(ladderGameResult);
    }

    private void validateOperator(String operator) {
        if (players.notContains(operator)) {
            throw new IllegalArgumentException("없는 참가자 입니다.");
        }
    }

    private LadderGameResult generateLadderGameResult(String operator) {
        int startIndex = players.indexOf(operator);
        int endIndex = ladder.climb(startIndex);
        String giftName = gifts.getGiftName(endIndex);
        return new LadderGameResult(operator, giftName);
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
