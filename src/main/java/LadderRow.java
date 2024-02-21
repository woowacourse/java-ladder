import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private final int maxSize;
    private final List<Boolean> ladderStep;

    public LadderRow(int participantsSize) {
        this.maxSize = participantsSize - 1;
        this.ladderStep = new ArrayList<>();
    }


    public void cross(boolean existPoint) {
        if (ladderStep.size() == maxSize - 1 && existPoint) {
            ladderStep.add(existPoint);
            return;
        }
        ladderStep.add(existPoint);
        if (existPoint) {
            ladderStep.add(!existPoint);
        }
    }

    public int size() {
        return ladderStep.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Boolean> getPoints() {
        return ladderStep;
    }
}
