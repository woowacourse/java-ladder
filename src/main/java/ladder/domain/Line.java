package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<LadderStair> crossLine = new ArrayList<>();

    public Line(List<Boolean> isExistStairs) {
        LadderStair stair = LadderStair.start();
        for (Boolean isExist : isExistStairs) {
            crossLine.add(stair.next(isExist));
        }
        stair.end();
    }

    Record drawLine(Record record) {
        int size = record.getIndices().size();
        checkRecordSize(size);
        Record newRecord = new Record(new ArrayList<>(record.getIndices()));

        IntStream.range(0, size-1)
                .filter(i -> crossLine.get(i).isExist())
                .forEach(i -> newRecord.swap(i,i+1));

        return newRecord;
    }

    private void checkRecordSize(int size) {
        if (size != crossLine.size() + 1){
            throw new IllegalArgumentException();
        }
    }

    int length() {
        return crossLine.size();
    }

    @Override
    public String toString() {
        return "|" + this.crossLine.stream()
                .map(ladderStair -> ladderStair.isExist() ? "-----|" : "     |")
                .collect(Collectors.joining());
    }
}