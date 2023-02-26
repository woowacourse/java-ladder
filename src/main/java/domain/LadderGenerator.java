package domain;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(People people, ResultsEntry resultsEntry, int height);
}
