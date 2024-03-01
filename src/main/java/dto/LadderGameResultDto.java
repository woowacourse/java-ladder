package dto;

import domain.game.LadderGameResult;

public record LadderGameResultDto(String playerName, String gameResult) {

    public static LadderGameResultDto of(LadderGameResult ladderGameResult) {
        return new LadderGameResultDto(
                ladderGameResult.getPlayerName().value(),
                ladderGameResult.getGameResult().getDescription()
        );
    }
}
