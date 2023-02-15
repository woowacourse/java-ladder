package ladder.domain;

import java.util.ArrayList;
import java.util.List;

class Line {

    private final List<Boolean> connected;


    Line(Height height) {
        List<Boolean> temp = new ArrayList<>(height.getHeight());
        for (int i = 0; i < height.getHeight(); i++) {
            temp.add(false);
        }
        connected = temp;
    }

    void connectHeight(int height) {
        connected.add(height, true);
    }

    //todo 명칭 변경
    boolean getByHeight(int height) {
        return connected.get(height);
    }

    List<Boolean> toDto() {
        return connected;
    }
}
