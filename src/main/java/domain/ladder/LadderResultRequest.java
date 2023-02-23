package domain.ladder;

public class LadderResultRequest {

    private final String message;

    public LadderResultRequest(String message) {
        this.message = message;
    }

    public boolean isAll() {
        return message.equals("all");
    }

    public String getMessage() {
        return message;
    }
}
