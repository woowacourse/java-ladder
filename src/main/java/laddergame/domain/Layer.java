package laddergame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Layer {

    private static final int MIN_LINK_COUNT = 1;
    private static final int FIRST_INDEX_OF_LINK = 0;
    private static final int LINK_COUNT = 1;

    private final List<Link> layer;

    private Layer(final int playerCount, final LinkGenerator linkGenerator) {
        int linkCount = playerCount - 1;
        validateLinkCount(linkCount);
        this.layer = createLayer(linkCount, linkGenerator);
    }

    public static Layer from(final int playerCount) {
        return new Layer(playerCount, new RandomLinkGenerator());
    }

    public static Layer of(final int playerCount, final LinkGenerator linkGenerator) {
        return new Layer(playerCount, linkGenerator);
    }

    private List<Link> createLayer(final int linkCount, final LinkGenerator linkGenerator) {
        List<Link> layer = new ArrayList<>();
        for (int i = 0; i < linkCount; i++) {
            layer.add(checkLink(layer, i, linkGenerator.pick()));
        }
        if (isAllFalse(linkCount, layer)) {
            return createLayer(linkCount, linkGenerator);
        }
        return layer;
    }

    private static boolean isAllFalse(final int linkCount, final List<Link> layer) {
        final boolean hasBothBoolean = new HashSet<>(layer).size() == LINK_COUNT;
        return hasBothBoolean && linkCount > MIN_LINK_COUNT;
    }

    private Link checkLink(final List<Link> layer, final int index, final Link link) {
        if (index == FIRST_INDEX_OF_LINK) {
            return link;
        }

        if (isOverlap(layer, link)) {
            return Link.DISCONNECTION;
        }

        return link;
    }

    private static boolean isOverlap(final List<Link> layer, final Link link) {
        int lastIndex = layer.size() - 1;
        return layer.get(lastIndex).isLink() && link.isLink();
    }

    private void validateLinkCount(final int linkCount) {
        if (linkCount < MIN_LINK_COUNT) {
            throw new IllegalStateException(String.format("Layer의 길이는 %d보다 작을 수 없습니다.", MIN_LINK_COUNT));
        }
    }

    public List<Link> getLayer() {
        return new ArrayList<>(layer);
    }

    public boolean getIndexLink(int index) {
        return layer.get(index).isLink();
    }

    public int getLayerSize() {
        return layer.size();
    }
}
