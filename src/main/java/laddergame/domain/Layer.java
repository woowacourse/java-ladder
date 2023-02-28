package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private static final int MIN_LINK_COUNT = 1;
    private static final int FIRST_INDEX_OF_LINK = 0;
    private static final int LINK_COUNT = 1;

    private final List<Link> layer;

    private Layer(final List<Link> layer) {
        this.layer = layer;
    }

    public static Layer of(final int playerCount, final LinkGenerator linkGenerator) {
        int linkCount = playerCount - 1;
        validateLinkCount(linkCount);
        final List<Link> layer = createLayer(linkCount, linkGenerator);

        return new Layer(layer);
    }

    private static void validateLinkCount(final int linkCount) {
        if (linkCount < MIN_LINK_COUNT) {
            throw new IllegalStateException(String.format("Layer의 길이는 %d보다 작을 수 없습니다.", MIN_LINK_COUNT));
        }
    }

    private static List<Link> createLayer(final int linkCount, final LinkGenerator linkGenerator) {
        List<Link> layer = new ArrayList<>();
        for (int i = 0; i < linkCount; i++) {
            layer.add(checkLink(layer, i, linkGenerator.pick()));
        }

        return layer;
    }

    private static Link checkLink(final List<Link> layer, final int index, final Link link) {
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
