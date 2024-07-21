package ladder2;

import java.util.ArrayList;
import java.util.List;

public class FindResult {

    private List<Ladder2> completeLadder;
    private int location;
    private List<Integer> allList;

    public FindResult(List<Ladder2> completeLadder, int location) {
        this.completeLadder = completeLadder;
        this.location = location;
        this.allList = new ArrayList<>();
    }

    public void setLocation(int l) {
        this.location = l;
    }

    public int move(int i, List<String> line) {
        // Check if we can move to the left
        if (i > 0 && line.get(i - 1).equals("-----")) {
            return i - 1;
        }
        // Check if we can move to the right
        if (i < line.size() - 1 && line.get(i).equals("-----")) {
            return i + 1;
        }
        // Otherwise stay in the same position
        return i;
    }

    public int find() {
        int currentPosition = location;
        for (Ladder2 ladder : completeLadder) {
            currentPosition = move(currentPosition, ladder.getLadder());
        }
        return currentPosition;
    }

    public List<Integer> findAll(int n) {
        allList.clear(); // 이전 결과를 지우기 위해 초기화
        for (int i = 0; i < n; i++) {
            setLocation(i);
            allList.add(find());
        }
        return allList;
    }
}


