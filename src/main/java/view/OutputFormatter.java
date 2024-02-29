package view;

import domain.ladder.Row;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import domain.ladder.Step;
import java.util.stream.Collectors;

public class OutputFormatter {
    private static final String SPACE = " ";
    private static final String BAR = "|";

    public String toNameUnit(Players players) {
        return players.getPlayers().stream()
                .map(this::getNameUnit)
                .collect(Collectors.joining());
    }

    public String toRow(Row rawRow) {
        String row = rawRow.getSteps().stream()
                .map(this::getStep)
                .collect(Collectors.joining());
        return "    " + row;
    }

    public String toPrize(Prizes rawPrizes) {
        return rawPrizes.getPrizes().stream()
                .map(this::getPrizeUnit)
                .collect(Collectors.joining());
    }

    private String getPrizeUnit(Prize rawPrize) {
        String prize = rawPrize.getPrize();
        if (prize.length() < 5) {
            String leftBlank = SPACE.repeat(4 - prize.length());
            prize = leftBlank + prize + SPACE;
        }
        return prize + SPACE;
    }

    private String getNameUnit(Player player) {
        String name = player.getName();
        if (name.length() < 5) {
            String leftBlank = SPACE.repeat(4 - name.length());
            name = leftBlank + name + SPACE;
        }
        return name + SPACE;
    }

    private String getStep(Step step) {
        if (step.isExist()) {
            return BAR + "-----";
        }
        return BAR + "     ";
    }
}
