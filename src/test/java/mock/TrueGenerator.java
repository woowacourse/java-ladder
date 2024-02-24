package mock;

import utils.Generator;

public class TrueGenerator implements Generator {
    @Override
    public boolean generate() {
        return true;
    }
}
