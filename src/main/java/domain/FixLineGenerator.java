package domain;

import java.util.List;

public class FixLineGenerator implements LineGenerator{
    @Override
    public List<Bridge> generateLine(final Width width) {
        return List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST);
    }
}
