package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<DrawnStatus> isDrawns;

    public Line(int number) {
        isDrawns = new ArrayList<>();
        draw(number);
    }

    private void draw(int number) {
        for (int i = 0; i < number - 1; i++) {
            drawSpace(i);
        }
    }

    private void drawSpace(int index) {
        if (index == 0 || !isDrawns.get(index - 1).checkDrawn()) {
            // TODO: 사다리 그려지는 확률 생각해보기
            isDrawns.add(decideDrawnStatus());
            return;
        }
        isDrawns.add(DrawnStatus.NON_DRAWN);
    }

    private DrawnStatus decideDrawnStatus() {
        if(new Random().nextBoolean()) {
            return DrawnStatus.DRAWN;
        }
        return DrawnStatus.NON_DRAWN;
    }

    public List<DrawnStatus> getIsDrawns() {
        return new ArrayList<>(isDrawns);
    }

}
