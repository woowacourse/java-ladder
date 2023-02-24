package ladder.domain;

import java.util.List;

public class PlayerNames {
    private static final int MIN_PLAYER_NUMBER = 2;
    private static final int MAX_PLAYER_NUMBER = 100;
    private static final int FIRST_INDEX = 0;
    
    private final List<PlayerName> names;
    
    public PlayerNames(List<PlayerName> playerNames) {
        validate(playerNames);
        names = playerNames;
    }
    
    private void validate(List<PlayerName> splitNames) {
        validateRange(splitNames);
        validateDuplicateNames(splitNames);
    }
    
    private void validateRange(List<PlayerName> splitedNames) {
        if (splitedNames.size() < MIN_PLAYER_NUMBER || splitedNames.size() > MAX_PLAYER_NUMBER) {
            throw new IllegalArgumentException("이름의 수가 2이상 100이하여야 합니다.");
        }
    }
    
    private void validateDuplicateNames(List<PlayerName> splitedNames) {
        if (getDistinctNamesNumber(splitedNames) != splitedNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }
    
    private int getDistinctNamesNumber(List<PlayerName> splitedNames) {
        return (int) splitedNames.stream()
                .distinct()
                .count();
    }
    
    public int playerSize() {
        return names.size();
    }
    
    public int getFirstPlayerNameLength() {
        return names.get(FIRST_INDEX).getLength();
    }
    
    public int getPlayerIndex(String player) {
        return names.indexOf(new PlayerName(player));
    }
    
    public String findByName(String playerName) {
        if (playerName.equals("all")) {
            return playerName;
        }
        
        return names.stream()
                .filter(name -> name.equals(new PlayerName(playerName)))
                .map(PlayerName::getPlayerName)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
    }
    
    public List<PlayerName> getNames() {
        return names;
    }
}
