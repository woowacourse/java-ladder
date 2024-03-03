package domain.player;

public class ResultViewPlayer extends Player {

    protected static final String ALL_COMMEND = "all";
    protected static final String EXISTING_PLAYER_OR_COMMEND_MESSAGE = String.format("%s이나 기존 사용자 이름을 입력해야 합니다.", ALL_COMMEND);

    private final String name;

    public ResultViewPlayer(String name, Players players) {
        super(name);
        validateExistingPlayerOrCommend(name, players);

        this.name = name;
    }

    private static void validateExistingPlayerOrCommend(String name, Players players) {
        if (!players.isPlayerExistByName(name) && !name.equals(ALL_COMMEND)) {
            throw new IllegalArgumentException(EXISTING_PLAYER_OR_COMMEND_MESSAGE);
        }
    }

    public boolean isAll() {
        return name.equals(ALL_COMMEND);
    }
}
