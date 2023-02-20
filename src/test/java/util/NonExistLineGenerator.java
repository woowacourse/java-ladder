package util;

public class NonExistLineGenerator implements LineGenerator {
    @Override
    public boolean generate(boolean isLeftLineExist) {
        return false;
    }
}
