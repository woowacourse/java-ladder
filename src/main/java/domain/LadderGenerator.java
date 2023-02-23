package domain;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(People people, int height);
}
