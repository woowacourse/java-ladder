package model;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private final List<Space> spaces;

    public LadderRow(List<Boolean> spaces) {
        verifyContinuousLine(spaces);
        this.spaces = spaces.stream()
                .map(Space::of)
                .toList();
    }

    private void verifyContinuousLine(List<Boolean> spaces) {
        for (int i = 1; i < spaces.size(); i++) {
            replaceContinuousLine(spaces, i);
        }
    }

    private void replaceContinuousLine(List<Boolean> spaces, int index) {
        if (spaces.get(index) && spaces.get(index - 1)) {
            spaces.set(index, false);
        }
    }

    public List<Space> getSpaces() {
        return new ArrayList<>(spaces);
    }

    public int move(int index) {
        // 양끝에 위치한 index의 경우
        if (index == 0) {
            return checkRight(index);
        }
        if (index == spaces.size()) {
            return checkLeft(index);
        }
        return checkBoth(index);
    }

    private int checkRight(int index){
        if(spaces.get(index) == Space.LINE){
            return index+1;
        }
        return index;
    }
    private int checkLeft(int index){
        if(spaces.get(index - 1) == Space.LINE){
            return index-1;
        }
        return index;
    }

    private int checkBoth(int index){
        if(checkLeft(index) != index){
            return checkLeft(index);
        }
        return checkRight(index);
    }
}
