package view;

public class SearchTarget {

    private final String inquiry;

    public SearchTarget(String inquiry) {
        this.inquiry = inquiry;
    }

    public boolean isAll() {
        return inquiry.equals("all");
    }

    public String getName() {
        return inquiry;
    }
}
