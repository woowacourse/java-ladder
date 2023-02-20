package ladder.domain.valueGenerator;

import java.util.List;

public class MockIntegerGenerator implements IntegerGenerator{

    private final List<Integer> generatedNumber;

    private int orderOfNumber;

    public MockIntegerGenerator(List<Integer> generatedNumber) {
        this.generatedNumber = generatedNumber;
    }

    @Override
    public int generateNumber(int min, int max) {
        if (generatedNumber.size() == orderOfNumber) {
            orderOfNumber = 0;
        }
        return generatedNumber.get(orderOfNumber++);
    }

}
