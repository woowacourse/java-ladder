package ladderGame.model.input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {
    List<Player> players;

    public Players(List<String> splittedInputs) {
        checkRepetition(new HashSet(splittedInputs), splittedInputs.size());

        players = new ArrayList();
        for(String splittedInput : splittedInputs) {
            players.add(new Player(splittedInput));
        }
    }

    void checkRepetition(Set<String> splittedInputs, int size) {
        if (splittedInputs.size() != size ) {
            throw new IllegalArgumentException("입력에 중복이 있습니다.");
        }
    }
}
