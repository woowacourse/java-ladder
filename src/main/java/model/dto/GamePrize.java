package model.dto;

import java.util.Map;
import model.LadderGame;

public record GamePrize(Map<String, String> prize) {
    public GamePrize(LadderGame ladderGame) {
        this(ladderGame.getPrize());
    }
}
