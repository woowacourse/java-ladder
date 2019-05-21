package ladder.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class ThrowException {
    /**
     * 상태가 true면 exception 발생
     *
     * @param state 상태
     * @param message 예외 메세지
     * @throws IllegalArgumentException
     */
    public static void checkArgument(boolean state, String message) {
        if (state) {
            throw new IllegalArgumentException(message);
        }
    }
}
