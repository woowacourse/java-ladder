package ladder;

import ladder.controller.LadderGameMachine;

public class Application {
    public static void main(String[] args) {
        LadderGameMachine gameMachine = new LadderGameMachine();
        gameMachine.run();
    }
}
