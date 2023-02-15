package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Floor> floors = new ArrayList<>();

    public Ladder(int size){
        validateSize(size);
        for(int i = 0; i < size; i++){
            floors.add(new Floor(3));
        }
    }

    public List<Floor> getFloors(){
        return floors;
    }

    private void validateSize(int size){
        if(size<=0){
            throw new IllegalArgumentException("사다리의 높이는 1이상 입니다.");
        }
    }

}
