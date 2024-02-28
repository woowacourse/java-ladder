package domain;

public class Prize {

    String prizeName;

    public Prize(String prizeName) {
        validateLength(prizeName);
        this.prizeName = prizeName;
    }

    private void validateLength(String prizeName) {
        if (prizeName.length() < 1 || prizeName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 상품 이름의 길이는 1 ~ 5 글자여야 합니다.");
        }
    }

    public String getPrizeName() {
        return prizeName;
    }
}
