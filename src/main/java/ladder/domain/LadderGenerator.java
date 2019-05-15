package ladder.domain;

public class LadderGenerator {
    public Ladder generate(int countOfPerson, int height) {
        return new Ladder(countOfPerson, height);
    }
}
