package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.MessageCollection.*;

public class LadderWidth {

    private List<LadderCrossBar> crossbars;
    private int width;

    // test 생성자
    public LadderWidth(List<LadderCrossBar> crossbars) {
        this.crossbars = crossbars;
    }

    public LadderWidth(int numberOfPlayer, int width) {
        this.crossbars = generateLadderWidth(numberOfPlayer);
        this.width = width;
    }

    private List<LadderCrossBar> generateLadderWidth(int numberOfPlayer) {
        crossbars = new ArrayList<>();
        crossbars.add(new LadderCrossBar());
        for (int i = 1; i < numberOfPlayer; i++) {
            crossbars.add(new LadderCrossBar(crossbars.get(i-1)));
        }
        return crossbars;
    }

    public List<LadderPlayer> changePlayer(List<LadderPlayer> players) {
        for (int i = 0; i < crossbars.size(); i++) {
            if (crossbars.get(i).isCrossbar()) {
                LadderPlayer temp = players.get(i);
                players.set(i, players.get(i + 1));
                players.set(i + 1, temp);
            }
        }
        return players;
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
