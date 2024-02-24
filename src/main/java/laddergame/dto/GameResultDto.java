package laddergame.dto;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;
import laddergame.domain.name.Name;
import laddergame.domain.name.Names;

import java.util.List;

public record GameResultDto(List<String> names, List<LineDto> ladder) {

    public static GameResultDto of(final Names names, final Ladder ladder) {
        List<String> mappedNames = mapToNames(names.getNames());
        List<LineDto> mappedLadder = mapToLadder(ladder.getLines());

        return new GameResultDto(mappedNames, mappedLadder);
    }

    private static List<String> mapToNames(List<Name> names) {
        return names.stream()
                .map(name -> name.getName())
                .toList();
    }

    private static List<LineDto> mapToLadder(List<Line> lines) {
        return lines.stream()
                .map(line -> new LineDto(line.getPointsState()))
                .toList();
    }
}
