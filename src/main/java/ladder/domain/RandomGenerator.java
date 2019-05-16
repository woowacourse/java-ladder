package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RandomGenerator {
    List<Integer> inputs;
    int index;

    public RandomGenerator() {
        get();
        index = 0;
    }

    public RandomGenerator(List<Integer> numbers) {
        this.inputs = numbers;
        index = 0;
    }

    public void get() {
        Scanner scanner = new Scanner(System.in);
        inputs = new LinkedList<>(Arrays.asList(scanner.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList()));
    }

    public int getElement() {
        if (inputs.size() != 0) {
            return inputs.get(index++);
        }
        return new Random().nextInt(2);
    }
}
