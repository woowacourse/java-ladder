package view;

public class SearchTarget {

    private final String target;

    public SearchTarget(String target) {
        this.target = target;
    }

    public boolean isAll() {
        return Command.isAll(target);
    }

    public String getName() {
        return target;
    }
}
