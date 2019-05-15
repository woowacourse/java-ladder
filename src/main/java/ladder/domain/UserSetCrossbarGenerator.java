package ladder.domain;

import java.util.List;

public class UserSetCrossbarGenerator implements CrossbarGenerator {
    private List<Boolean> setCrossbars;

    UserSetCrossbarGenerator(List<Boolean> userSetCrossbars) {
        this.setCrossbars = userSetCrossbars;
    }

    @Override
    public Crossbars generateCrossbars() {
        return new Crossbars(setCrossbars);
    }
}
