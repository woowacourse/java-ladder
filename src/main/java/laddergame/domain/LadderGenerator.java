package laddergame.domain;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(LineSize lineSize, LadderHeight ladderHeight);
}
