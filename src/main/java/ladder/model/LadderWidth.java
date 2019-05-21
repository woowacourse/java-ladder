package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.view.OutputView.*;

public class LadderWidth {

    private List<LadderCrossBar> crossbars;
    private int width;

    public LadderWidth(int numberOfPlayer, int width) {
        this.crossbars = generateLadderWidth(numberOfPlayer);
        this.width = width;
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

    private String createCrossbar(String mark) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            stringBuilder.append(mark);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        String crossbar = createCrossbar(HYPHEN);
        String notCrossbar = createCrossbar(BLANK);

        return PIPE + crossbars.stream().map(index -> {
            if (index.isCrossbar()) {
                return crossbar;
            }
            return notCrossbar;
        }).collect(Collectors.joining(PIPE)) + PIPE;
    }
}
