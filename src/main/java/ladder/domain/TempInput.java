package ladder.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TempInput {
    List<String> inputs;
    int index;

    public TempInput() {
        index = 0;
    }

    public void get() {
        Scanner scanner = new Scanner(System.in);
        inputs = new LinkedList<>(Arrays.asList(scanner.nextLine().split(" ")));
    }

    public String getElement() {
        return inputs.get(index++);
    }
}
