package util;

import java.util.Arrays;

public enum Way {
    MAXNAMELENGTH1(1, "-", " "),
    MAXNAMELENGTH2(2, "--", "  "),
    MAXNAMELENGTH3(3, "---", "   "),
    MAXNAMELENGTH4(4, "----", "    "),
    MAXNAMELENGTH5(5, "-----", "     ");

    private int maxNameLength;
    private String way;
    private String blank;

    Way(int maxNameLength, String way, String blank) {
        this.maxNameLength = maxNameLength;
        this.way = way;
        this.blank = blank;
    }

    public String getWay() {
        return way;
    }

    public String getBlank() {
        return blank;
    }

    public static Way valueOf(int maxNameLength) {
        return Arrays.stream(Way.values())
                .filter(e -> e.maxNameLength == maxNameLength).findAny().orElseThrow();
    }
}
