package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Bridge;
import domain.Ladder;
import domain.Line;
import domain.Participant;
import domain.Prizes;

public abstract class AbstractTestFixture {

    public List<Bridge> convert(Boolean... flags) {
        return Arrays.stream(flags)
                .map((flag) -> {
                    if (flag) {
                        return Bridge.EXIST;
                    }
                    return Bridge.EMPTY;
                })
                .collect(Collectors.toList());
    }

    public List<Participant> createParticipantsFrom(String... names) {
        return Arrays.stream(names)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public Prizes createPrizesFrom(String... names) {
        return new Prizes(List.of(names));
    }

    public List<Line> createLines(final int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(convert(true, false, true)));
        }
        return lines;
    }

    public Ladder createLadderWith(Line... lines) {
        return new Ladder(List.of(lines));
    }
}
