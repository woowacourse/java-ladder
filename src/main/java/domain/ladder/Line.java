package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> links;

    public Line(final List<Link> links) {
        this.links = links;
    }

    public List<Link> getLinks() {
        return List.copyOf(links);
    }

    public List<Integer> getLinkedIndexes() {
        final List<Integer> linkedIndexes = new ArrayList<>();

        for (int index = 0; index < links.size(); index++) {
            addLinkedIndex(linkedIndexes, index);
        }

        return linkedIndexes;
    }

    private void addLinkedIndex(final List<Integer> linkedIndexes, final int index) {
        if (links.get(index).isLink()) {
            linkedIndexes.add(index);
        }
    }
}
