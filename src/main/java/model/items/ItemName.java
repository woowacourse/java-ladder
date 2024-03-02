package model.items;

import model.Name;

public class ItemName extends Name {
    public ItemName(final String rawName) {
        super(rawName);
    }

    @Override
    protected void validateName(final String rawName) {
        validateBlankName(rawName);
    }

    private void validateBlankName(final String rawName) {
        if (rawName.isBlank()) {
            throw new IllegalArgumentException("실행 결과의 이름은 공백일 수 없습니다.");
        }
    }
}
