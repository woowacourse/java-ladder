package view;

public class SearchTarget {

    private static final String ALL = "all";

    private final String inquiry;

    public SearchTarget(String inquiry) {
        this.inquiry = inquiry;
    }

    public boolean isAll() {
        return inquiry.equals(ALL);
    }

    public String getName() {
        return inquiry;
    }
}
