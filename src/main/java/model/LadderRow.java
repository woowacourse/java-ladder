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

    public int climb(int position) {
        if(isEitherEnds(position)){
            return climbOnEnd(position);
        }
        return climbOnMiddle(position);
    }

    private boolean isEitherEnds(int position){
        return position == 0 || position == spaces.size();
    }

    private int climbOnEnd(int position){
        if(position == 0){
            return climbRight(position);
        }
        return climbLeft(position);
    }

    private int climbRight(int position){
        if(spaces.get(position) == Space.LINE){
            return position+1;
        }
        return position;
    }

    private int climbLeft(int position){
        if(spaces.get(position - 1) == Space.LINE){
            return position-1;
        }
        return position;
    }

    private int climbOnMiddle(int position){
        if(climbLeft(position) != position){
            return climbLeft(position);
        }
        return climbRight(position);
    }
}
