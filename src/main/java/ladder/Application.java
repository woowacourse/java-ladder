package ladder;

import ladder.controller.LadderController;
import ladder.util.RandomBooleanGenerator;

public class Application {
    public static void main(String[] args) {
        new LadderController(new RandomBooleanGenerator()).execute();
    }
}
