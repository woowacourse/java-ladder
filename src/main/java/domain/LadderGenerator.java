package domain;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(People people, Results results, int height);
}
