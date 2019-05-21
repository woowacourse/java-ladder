package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class UserSetCrosspointGenerator implements CrosspointGenerator {
    private List<Boolean> setCrossbars;

    UserSetCrosspointGenerator(List<Boolean> userSetCrossbars) {
        this.setCrossbars = userSetCrossbars;
    }

    @Override
    public LadderRow generateLadderRow(int numberOfPlayer) {
        List<Crosspoint> crosspoints = new ArrayList<>();
        for (int i = 0; i < setCrossbars.size() - 1; i++) {
            crosspoints.add(new Crosspoint(setCrossbars.get(i), setCrossbars.get(i + 1)));
        }

        return new LadderRow(crosspoints);
    }
}
