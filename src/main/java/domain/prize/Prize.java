package domain.prize;

public class Prize {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String prizeName;

    public Prize(String prizeName) {
        validateLength(prizeName);
        this.prizeName = prizeName;
    }

    private void validateLength(String prizeName) {
        if (prizeName.length() < MIN_LENGTH || prizeName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException
                    ("[ERROR] 상품 이름의 길이는 " + MIN_LENGTH + " ~ " + MAX_LENGTH + " 글자여야 합니다.");
        }
    }

    public String getPrizeName() {
        return prizeName;
    }
}
