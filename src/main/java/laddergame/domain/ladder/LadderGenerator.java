package laddergame.domain.ladder;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(final LineSize lineSize, final LadderHeight ladderHeight);
}
