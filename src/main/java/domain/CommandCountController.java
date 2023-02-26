package domain;

public class CommandCountController {

    private static final int COMMAND_COUNT_UPPERBOUND = 20;
    private static final String COMMAND_COUNT_ERROR_MESSAGE = "결과 조회는 더 이상 불가합니다.";

    private int count;

    public CommandCountController() {
        this.count = 0;
    }

    public void execute(Command command) {
        validate();

        if (command.isAllCommand()) {
            count = COMMAND_COUNT_UPPERBOUND;
            return;
        }

        count++;
    }

    private void validate() {
        if (COMMAND_COUNT_UPPERBOUND <= this.count) {
            throw new IllegalArgumentException(COMMAND_COUNT_ERROR_MESSAGE);
        }
    }

    public boolean isCommandCountRemain() {
        return this.count != COMMAND_COUNT_UPPERBOUND;
    }

    public int getCount() {
        return this.count;
    }

}
