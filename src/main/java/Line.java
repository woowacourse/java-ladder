import java.util.List;

public class Line {
    private final List<Scaffold> scaffolds;

    public Line(final List<Scaffold> scaffolds) {
        this.scaffolds = scaffolds;
    }

    public int size() {
        return scaffolds.size();
    }
}
