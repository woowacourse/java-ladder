package laddergame.domain;

public class Name {
    private static final String NAME_RULE = "[a-zA-Z0-9]{1,5}";
    private final String playerName;

    public Name(String playerName){
        validateNameRule(playerName);
        this.playerName=playerName;
    }

    private void validateNameRule(String name) {
        if (name == null || !name.matches(NAME_RULE)) {
            throw new IllegalArgumentException("이름은 5자 이내의 영숫자로 구성되어야 합니다.");
        }
    }

    public String getName(){return playerName;}
}
