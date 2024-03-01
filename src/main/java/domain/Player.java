package domain;

record Player(String name) {
    Player {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }
}
