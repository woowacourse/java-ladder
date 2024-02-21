package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

public class LadderFloorGenerator implements FloorGenerator {

    private final BooleanSupplier supplier;

    public LadderFloorGenerator(BooleanSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public List<Boolean> generate(int size) {
        List<Boolean> floor = new ArrayList<>();

        Stream.generate(supplier::getAsBoolean)
                .limit(size)
                .forEach(value -> fillFloorByValue(floor, value));

        return floor;
    }

    private void fillFloorByValue(List<Boolean> floor, boolean value) {
        if (isPlaceable(floor)) {
            floor.add(value);
            return;
        }

        floor.add(false);
    }

    private boolean isPlaceable(List<Boolean> floor) {
        return floor.isEmpty() || !floor.get(floor.size() - 1);
    }
}
