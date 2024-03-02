package ladder.domain.ladderGame;

public enum GameExecutionCommand {

    EXECUTE_GAME("Y"),
    STOP_GAME("N");

    final String command;

    GameExecutionCommand(String command) {
        this.command = command;
    }

    public static boolean isExecuteGameCommand(String commandInput) {
        if (EXECUTE_GAME.command.equals(commandInput)) {
            return true;
        }
        if (STOP_GAME.command.equals(commandInput)) {
            return false;
        }
        throw new IllegalArgumentException(EXECUTE_GAME.command + " 혹은 " + STOP_GAME.command + " 중 하나를 입력해야 합니다.");
    }
}
