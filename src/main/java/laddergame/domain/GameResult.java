package laddergame.domain;

import java.util.Map;

public class GameResult {
    private final static String NEXT_LINE = "\n";

    private Map<String, String> resultOfPlayer;

    public GameResult(Map<String, String> resultOfPlayer) {
        this.resultOfPlayer = resultOfPlayer;
    }

    public String getResultWithPlayer(String player){
        return resultOfPlayer.get(player);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String player : resultOfPlayer.keySet()){
            stringBuilder.append(player);
            stringBuilder.append(" : ");
            stringBuilder.append(resultOfPlayer.get(player));
            stringBuilder.append(NEXT_LINE);
        }
        return stringBuilder.toString();
    }
}
