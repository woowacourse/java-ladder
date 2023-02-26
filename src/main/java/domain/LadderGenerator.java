package domain;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(Players players, ResultsEntry resultsEntry, int height);
}
