package domain.ladder;

public class LadderCreator {
    public Ladder create(int height, int width, BridgeGenerator generator) {
        return new Ladder(new Height(height), new Width(width), new RowGenerator(generator));
    }
}
