package ladder.domain.ladder;

public class InvalidDirection extends RuntimeException {
    public InvalidDirection(String message) {
        super(message);
    }
}
