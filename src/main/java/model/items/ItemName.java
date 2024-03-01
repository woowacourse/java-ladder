package model.items;

import model.Name;

public class ItemName extends Name {
    public ItemName(final String name) {
        super(name);
    }

    @Override
    protected void validateName(final String name) {
        validateBlankName(name);
    }

    private void validateBlankName(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("실행 결과의 이름은 공백일 수 없습니다.");
        }
    }
}
