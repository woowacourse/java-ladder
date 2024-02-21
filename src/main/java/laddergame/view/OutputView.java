package laddergame.view;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.Line;

public class OutputView {

    public OutputView() {

    }

    public void writePlayersName(final List<String> players) {
        System.out.println(String.join("\t", players));
    }

    public void writeLadder(final Ladder ladder) {
        IntStream.range(0, ladder.getLines().size())
                .forEach(i -> writeLine(ladder.getLines().get(i)));
    }

    private void writeLine(final Line line) {
        StringJoiner stringJoiner = new StringJoiner("|", "\t|", "|");
        for (Boolean point : line.getPoints()) {
            if (point) {
                stringJoiner.add("-----");
                continue;
            }
            stringJoiner.add("     ");
        }

        System.out.println(stringJoiner);
    }
}
