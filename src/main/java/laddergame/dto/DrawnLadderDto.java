package laddergame.dto;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.target.Target;
import laddergame.domain.target.Targets;

import java.util.List;

public record DrawnLadderDto(List<String> names, List<String> targets, List<LineDto> ladder) {

    public static DrawnLadderDto of(final Players names, final Targets targets, final Ladder ladder) {
        List<String> mappedNames = mapToNames(names.getPlayers());
        List<String> mappedTargets = mapToTargets(targets.getTargets());
        List<LineDto> mappedLadder = mapToLadder(ladder.getLines());

        return new DrawnLadderDto(mappedNames, mappedTargets, mappedLadder);
    }

    private static List<String> mapToNames(List<Player> names) {
        return names.stream()
                .map(name -> name.getName())
                .toList();
    }

    private static List<String> mapToTargets(List<Target> targets) {
        return targets.stream()
                .map(target -> target.getTarget())
                .toList();
    }

    private static List<LineDto> mapToLadder(List<Line> lines) {
        return lines.stream()
                .map(line -> new LineDto(line.getPointsState()))
                .toList();
    }
}
