package util;

import domain.LadderItem;
import java.util.List;
import java.util.Random;

public class RandomLadderItemGenerator implements LadderItemGenerator {

    private final Random random = new Random();

    @Override
    public LadderItem generate() {
        List<LadderItem> ladderItems = LadderItem.getLadderItemsAsList();
        return ladderItems.get(random.nextInt(ladderItems.size()));
    }

}
