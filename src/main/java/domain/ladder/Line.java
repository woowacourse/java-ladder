package domain.ladder;

import domain.Position;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Link> links;

    public Line(final List<Link> links) {
        this.links = links;
    }

    public List<Position> getLinkedPositions() {
        final List<Position> linkedPositions = new ArrayList<>();

        for (int index = 0; index < links.size(); index++) {
            addLinkedPositions(linkedPositions, index);
        }

        return linkedPositions;
    }

    private void addLinkedPositions(final List<Position> linkedPositions, final int index) {
        if (links.get(index).isLinked()) {
            linkedPositions.add(new Position(index));
        }
    }

    public List<Link> getLinks() {
        return List.copyOf(links);
    }
}
