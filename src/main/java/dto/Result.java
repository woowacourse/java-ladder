package dto;

import java.util.List;
import model.Ladder;
import model.People;

public record Result(List<String> names, List<LineInfo> lines) {
    public static Result from(final People people, final Ladder ladder) {
        final List<String> names = people.getNames();
        final List<LineInfo> lines = ladder.getLines()
                .stream()
                .map(LineInfo::from)
                .toList();

        return new Result(names, lines);
    }
}
