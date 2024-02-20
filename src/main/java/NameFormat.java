public enum NameFormat {
    ONE(1, "  %s  "),
    TWO(2, "  %s "),
    THREE(3, " %s "),
    FOUR(4, "%s "),
    FIVE(5, "%s");

    private final int nameLength;
    private final String format;

    NameFormat(int nameLength, String format) {
        this.nameLength = nameLength;
        this.format = format;
    }

    //TODO 출력문에서도 catch문 유의하기
    public static String findFormat(int nameLength) {
        for (NameFormat nameFormat : values()) {
            if (nameLength == nameFormat.nameLength) {
                return nameFormat.format;
            }
        }
        throw new IllegalArgumentException("참여자 이름은 1이상 5이하의 단어만 가능합니다.");
    }
}
