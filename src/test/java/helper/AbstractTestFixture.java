package helper;

import domain.Bridge;
import domain.Line;
import domain.People;
import domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public People createDefaultPerson() {
        return new People(List.of(new Person("aa"), new Person("bb")));
    }

    public List<Line> createLines(final int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(convert(true, false, true)));
        }
        return lines;
    }

    public List<String> createResultCandidates(int size) {
        List<String> candidates = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            candidates.add(getResultCandidate(i));
        }

        return candidates;
    }

    private String getResultCandidate(int count) {
        if (count % 2 == 0) {
            return "꽝";
        }

        return String.valueOf(count * 1000);
    }
}
