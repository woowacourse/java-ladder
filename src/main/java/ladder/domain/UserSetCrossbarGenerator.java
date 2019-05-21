package ladder.domain;

import java.util.List;

public class UserSetCrossbarGenerator implements CrossbarGenerator {
    private List<Boolean> setCrossbars;

    UserSetCrossbarGenerator(List<Boolean> userSetCrossbars) {
        this.setCrossbars = userSetCrossbars;
    }

    @Override
    public Crosspoints generateCrossbars() {
        return new Crosspoints(new Crossbar(setCrossbars));
    }
}
