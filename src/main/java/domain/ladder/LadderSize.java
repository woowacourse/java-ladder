package domain.ladder;

public class LadderSize {

    LadderHeight height;
    LineWeight weight;

    public LadderSize(LadderHeight height, LineWeight weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height.getHeight();
    }

    public LineWeight getLineWeight() {
        return weight;
    }
}
