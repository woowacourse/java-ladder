package dto;

import java.util.List;
import model.Ladder;
import model.People;
import model.Presents;

public record Result(List<String> names, List<LineInfo> lines, List<String> presentNames) {
    public static Result from(final People people, final Ladder ladder, Presents presents) {
        final List<String> names = people.getNames();
        final List<LineInfo> lines = ladder.getLines()
                .stream()
                .map(LineInfo::from)
                .toList();
        final List<String> presentNames = presents.getPresentNames();

        return new Result(names, lines, presentNames);
    }
}
