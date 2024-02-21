package dto;

import java.util.List;
import model.Ladder;
import model.People;

public record Result(List<String> names, List<LineDto> lines) {
    public static Result from(People people, Ladder ladder) {
        List<String> names = people.getNames();
        List<LineDto> lines = ladder.getLines()
                .stream()
                .map(LineDto::from)
                .toList();

        return new Result(names, lines);
    }
}
