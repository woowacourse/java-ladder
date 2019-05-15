package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static String PLAYERNAMES_INPUT_REGEX = "^([^,]+)(,[^,]+)*$";

    private List<PlayerName> playerNames;

    public Players(String input) {
        checkValidInput(input);
        String[] splittedInput = input.split(",");
        playerNames = new ArrayList<>();
        for(String name : splittedInput){
            checkDuplicateName(name);
            playerNames.add(new PlayerName(name.trim()));
        }
    }
    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }

    public int getPlayerNumber() {
        return playerNames.size();
    }

    private void checkDuplicateName(String name) {
        if (playerNames.contains(new PlayerName(name))) {
            throw new IllegalArgumentException("중복 이름 오류");
        }
    }

    private void checkValidInput(String input) {
        if(!input.matches(PLAYERNAMES_INPUT_REGEX)){
            throw new IllegalArgumentException("플레이어 이름들 입력 형식 오류");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(PlayerName playerName : playerNames){
            sb.append(playerName.toString());
        }
        return sb.toString();
    }
}
