package laddergame.domain;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(final LineSize lineSize, final LadderHeight ladderHeight);
}
