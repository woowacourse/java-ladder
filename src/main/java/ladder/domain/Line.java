package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> connected;


    public Line(Height height) {
        List<Boolean> temp = new ArrayList<>(height.getH());
        for (int i = 0; i < height.getH(); i++) {
            temp.add(false);
        }
        connected = temp;
    }

    public void connectHeight(int height) {
        connected.add(height, true);
    }

    public boolean getByHeight(int height) {
        return connected.get(height);
    }
}
