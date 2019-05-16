package ladder.domain;

import java.util.List;

public class Record {
    private List<Integer> indices;

    Record(List<Integer> indices){
        this.indices = indices;
    }

//    Record(Record record){
//        this(record.getIndices());
//    }

    List<Integer> getIndices(){
        return indices;
    }
}
