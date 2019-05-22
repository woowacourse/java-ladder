package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderWidth {

    private List<LadderCrossBar> crossbars;

    public LadderWidth(int numberOfPlayer) {
        this.crossbars = generateLadderWidth(numberOfPlayer);
    }

    public List<LadderCrossBar> getCrossbars() {
        return crossbars;
    }

    private List<LadderCrossBar> generateLadderWidth(int numberOfPlayer) {
        crossbars = new ArrayList<>();
        crossbars.add(new LadderCrossBar());
        for (int i = 1; i < numberOfPlayer; i++) {
            crossbars.add(new LadderCrossBar(crossbars.get(i - 1)));
        }
        return crossbars;
    }

    public List<LadderPlayer> changePlayer(List<LadderPlayer> players) {
        for (int position = 0; position < crossbars.size(); position++) {
            swapCrossbar(players, position);
        }
        return players;
    }

    private void swapCrossbar(List<LadderPlayer> players, int position) {
        if (crossbars.get(position).isCrossbar()) {
            LadderPlayer temp = players.get(position);
            players.set(position, players.get(position + 1));
            players.set(position + 1, temp);
        }
    }
}
