package ladder.view;

public class LadderDepthException {
    public static final int MIN_LINE_COUNT = 1;

    /**
     * 규칙 : 사다리 깊이는 1 이상이어야 한다.
     * <br> 기준 : MIN_LINE_COUNT
     *
     * @param depth 사다리 깊이
     * @return depth
     * @throws IllegalArgumentException InputView.EX_LINE_COUNT
     */
    public static void ladderMinDepth(int depth) {
        if (depth < MIN_LINE_COUNT) {
            throw new IllegalArgumentException(InputView.EX_LINE_COUNT);
        }
    }
}
