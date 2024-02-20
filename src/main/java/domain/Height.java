package domain;

public class Height {

    public Height(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("[ERROR] 높이는 1개 이상이어야 합니다.");
        }
        if (height > 100) {
            throw new IllegalArgumentException("[ERROR] 높이는 100개 이하여야 합니다.");
        }
    }
}
