package domain;

import dto.LadderGameResult;
import dto.LadderGameResults;
import java.util.List;

public class LadderGame {
    private final Players players;
    private final Gifts gifts;
    private final Ladder ladder;

    private LadderGame(Players players, Gifts gifts, LineGenerateStrategy lineMakeStrategy, int ladderHeight) {
        validateRequiredValues(players, gifts, lineMakeStrategy, ladderHeight);
        this.players = players;
        this.gifts = gifts;
        this.ladder = Ladder.of(lineMakeStrategy, ladderHeight, players.getPlayerNames().size());
    }

    private void validateRequiredValues(Players players, Gifts gifts, LineGenerateStrategy lineGenerateStrategy,
                                        Integer ladderHeight) {
        if (players == null || gifts == null || lineGenerateStrategy == null || ladderHeight == null) {
            throw new IllegalStateException("필수 값이 설정되지 않았습니다.");
        }
    }

    public LadderGameResults start(String operator) {
        if (operator.equals("all")) {
            return startAllPlayer();
        }
        return startSinglePlayer(operator);
    }

    private LadderGameResults startSinglePlayer(String operator) {
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

    private LadderGameResults startAllPlayer() {
        List<LadderGameResult> ladderGameResults = players.getPlayerNames().stream()
                .map(this::generateLadderGameResult)
                .toList();
        return new LadderGameResults(ladderGameResults);
    }

    public List<List<Boolean>> rawLadder() {
        return ladder.getRawLadder();
    }

    public static final class LadderGameBuilder {
        private Players players;
        private Gifts gifts;
        private LineGenerateStrategy lineGenerateStrategy;
        private int ladderHeight;

        private LadderGameBuilder() {
        }

        public static LadderGameBuilder builder() {
            return new LadderGameBuilder();
        }

        public LadderGameBuilder players(List<String> playerNames) {
            this.players = Players.of(playerNames);
            return this;
        }

        public LadderGameBuilder gifts(List<String> giftNames) {
            this.gifts = Gifts.of(giftNames);
            return this;
        }

        public LadderGameBuilder lineGenerateStrategy(LineGenerateStrategy lineGenerateStrategy) {
            this.lineGenerateStrategy = lineGenerateStrategy;
            return this;
        }

        public LadderGameBuilder ladderHeight(int ladderHeight) {
            this.ladderHeight = ladderHeight;
            return this;
        }

        public LadderGame build() {
            return new LadderGame(players, gifts, lineGenerateStrategy, ladderHeight);
        }
    }
}
