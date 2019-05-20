package ladder.util;

import java.util.List;

public class RowInputGenerator implements Generator {
    private List<Integer> inputs;
    private int index;

    public RowInputGenerator(List<Integer> numbers) {
        this.inputs = numbers;
        index = 0;
    }

    @Override
    public int generate() {
        return inputs.get(index++);
    }
}
