package model.items;


public class Item {
    private final String name;

    public Item(final String rawName) {
        validateBlankName(rawName);
        this.name = rawName;
    }

    public String getName() {
        return name;
    }

    private void validateBlankName(final String rawName) {
        if (rawName.isBlank()) {
            throw new IllegalArgumentException("실행 결과의 이름은 공백일 수 없습니다.");
        }
    }
}
