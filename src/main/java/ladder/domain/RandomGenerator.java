package ladder.domain;

public interface RandomGenerator {

    boolean generateBoolean();

    int generateNumber(int min, int max);
}
