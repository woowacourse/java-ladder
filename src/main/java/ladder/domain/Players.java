package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final String DELIMITER = ",";
    private static final String DUPLICATE_NAME_ERROR = "중복 이름 오류";
    private static final String VALID_INPUT_ERROR = "플레이어 이름들 입력 형식 오류";
    private static final String PLAYERNAMES_INPUT_REGEX = "^([^,]+)(,[^,]+)*$";

    private List<PlayerName> playerNames;

    public Players(String input) {
        playerNames = new ArrayList<>();
        checkValidInput(input);
        addPlayerNames(input);
    }

    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }

    public int getPlayerNumber() {
        return playerNames.size();
    }

    public int getPlayerIndex(PlayerName name) {
        return this.playerNames.indexOf(name);
    }

    private void checkValidInput(String input) {
        if(!input.matches(PLAYERNAMES_INPUT_REGEX)){
            throw new IllegalArgumentException(VALID_INPUT_ERROR);
        }
    }

    private void addPlayerNames(String input) {
        for(String name : input.split(DELIMITER)){
            checkDuplicateName(name);
            playerNames.add(new PlayerName(name.trim()));
        }
    }

    private void checkDuplicateName(String name) {
        if (playerNames.contains(new PlayerName(name))) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
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
