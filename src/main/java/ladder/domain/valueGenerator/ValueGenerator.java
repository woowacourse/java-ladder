package ladder.domain.valueGenerator;

public interface ValueGenerator {

    boolean generateBoolean();

    int generateNumber(int min, int max);

}
