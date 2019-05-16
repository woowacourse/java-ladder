package ladder.model;

import ladder.model.frame.Input;

import java.util.List;

public class Players extends Input<PlayerName> {
    private static final String DUPLICATE_NAME_ERROR = "중복 이름 오류";

    public Players(String input) {
        super(input);
        addPlayerNames(input);
    }

    public List<PlayerName> getPlayerNames() {
        return names;
    }

    public int getPlayerNumber() {
        return names.size();
    }

    public int getPlayerIndexByPlayerName(PlayerName name) {
        return this.names.indexOf(name);
    }

    private void addPlayerNames(String input) {
        for(String name : input.split(DELIMITER)){
            checkDuplicateName(name);
            names.add(new PlayerName(name.trim()));
        }
    }

    private void checkDuplicateName(String name) {
        if (names.contains(new PlayerName(name))) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(PlayerName playerName : names){
            sb.append(playerName.toString());
        }
        return sb.toString();
    }
}
