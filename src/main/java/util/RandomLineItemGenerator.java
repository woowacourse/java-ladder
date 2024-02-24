package util;

import domain.LineItem;
import java.util.List;
import java.util.Random;

public class RandomLineItemGenerator implements LineItemGenerator {

    private final Random random = new Random();

    @Override
    public LineItem generate() {
        List<LineItem> ladderItems = LineItem.getLadderItemsAsList();
        return ladderItems.get(random.nextInt(ladderItems.size()));
    }

}
