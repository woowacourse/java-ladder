package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> legs;

    public Line() {
        legs = new ArrayList<>();
    }

    //TODO: 파라미터 이름 변경
    public void makeLeg(int legCount) {
        for (int i = 0; i < legCount; i++) {
            legs.add(true);
        }
    }
}
