package domain;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(Players players, Results results, int height);
}
