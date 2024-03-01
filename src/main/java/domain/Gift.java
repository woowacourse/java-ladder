package domain;

record Gift(String name) {

    Gift {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("상품 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }
}
