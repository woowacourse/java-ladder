package util;

import domain.Bridge;

public class TrueGenerator implements BooleanGenerator {
    @Override
    public Boolean generate() {
        return true;
    }
}
