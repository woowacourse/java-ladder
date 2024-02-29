package ladder.dto;

public class ResultRequest {

    private static final String NO_NAME = "";
    public static final ResultRequest ALL = new ResultRequest(NO_NAME, RequestCommand.ALL_RESULT);
    public static final ResultRequest EXIT_PROGRAM = new ResultRequest(NO_NAME, RequestCommand.EXIT_PROGRAM);

    private final String playerName;
    private final RequestCommand requestCommand;

    private ResultRequest(String playerName, RequestCommand requestCommand) {
        this.playerName = playerName;
        this.requestCommand = requestCommand;
    }

    public static ResultRequest from(String playerName) {
        return new ResultRequest(playerName, RequestCommand.SINGLE_RESULT);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isRequestAll() {
        return requestCommand == RequestCommand.ALL_RESULT;
    }

    public boolean isExitProgram() {
        return requestCommand == RequestCommand.EXIT_PROGRAM;
    }

    private enum RequestCommand {
        SINGLE_RESULT, ALL_RESULT, EXIT_PROGRAM
    }
}
