package domain;

public class Bridge {

    private final int from;
    private final int to;
    private final int height;

    public Bridge(int from, int to, int height) {
        if (from == to) {
            throw new IllegalArgumentException("잘못된 연결을 하면 예외가 발생한다");
        }

        if(from < 0 || to < 0 || height < 0) {
            throw new IllegalArgumentException("잘못된 연결을 하면 예외가 발생한다");
        }

        this.from = from;
        this.to = to;
        this.height = height;
    }
}
