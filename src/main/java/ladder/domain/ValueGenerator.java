package ladder.domain;

public interface ValueGenerator {

    boolean generateBoolean();

    int generateNumber(int min, int max);

}
