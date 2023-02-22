package util;

public class NonExistBooleanGenerator implements BooleanGenerator {

    @Override
    public boolean generate(boolean isLeftLineExist) {
        return false;
    }
}
