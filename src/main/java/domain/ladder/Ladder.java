package domain.ladder;

import domain.Height;
import domain.PersonCount;
import domain.user.Users;
import java.util.ArrayList;
import java.util.List;

public class Ladder {


    private final List<Line> lines = new ArrayList<>();

    public Ladder(final Height height, final PersonCount personCount, final LinkGenerator linkGenerator) {
        generateLines(height, personCount, new LineGenerator(linkGenerator));
    }

    private void generateLines(final Height height, final PersonCount personCount, final LineGenerator lineGenerator) {
        for (int index = 0; index < height.getValue(); index++) {
            lines.add(lineGenerator.generate(personCount));
        }
    }

    public void playLadderGame(final Users users) {
        for (final Line line : lines) {
            users.swapUserByLine(line);
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}

