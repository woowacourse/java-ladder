package helper;

import java.util.List;
import strategy.PassGenerator;

public class StubPassGenerator implements PassGenerator {

    private final List<Boolean> returnBoolean;
    private int index = 0;

    public StubPassGenerator(List<Boolean> returnBoolean) {
        this.returnBoolean = returnBoolean;
    }

    @Override
    public boolean generate() {
        if (index == returnBoolean.size()) {
            index = 0;
        }
        return returnBoolean.get(index++);
    }
}
