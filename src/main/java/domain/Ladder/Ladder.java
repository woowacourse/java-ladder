package domain.Ladder;

import domain.util.PointGenerator;
import domain.util.SequenceSwapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    
    private final List<Line> lines;
    
    
    private Ladder( List<Line> lines ) {
        this.lines = lines;
    }
    
    public static Ladder create( LadderHeight ladderHeight, LadderWidth ladderWidth, PointGenerator pointGenerator ) {
        List<Line> lines = new ArrayList<>();
        SequenceSwapper swapper = SequenceSwapper.initialize(ladderWidth.getWidth() + 1);
        int height = ladderHeight.getHeight();
        for ( int i = 0; i < height; i++ ) {
            Line line = Line.create(ladderWidth, pointGenerator);
            lines.add(line);
        }
        return new Ladder(lines);
    }
    
    public void readLines( SequenceSwapper swapper ) {
        for ( Line line : this.lines ) {
            line.readPoints(swapper);
        }
    }
    
    public List<Integer> getSwappedSequence( int length ) {
        SequenceSwapper sequence = SequenceSwapper.initialize(length);
        for ( Line line : this.lines ) {
            List<Integer> presentIndexes = line.getPresentIndexes();
            this.swapAtPresent(sequence, presentIndexes);
        }
        return Collections.unmodifiableList(sequence.getSequence());
    }
    
    private void swapAtPresent( SequenceSwapper initialSequence, List<Integer> presentIndexes ) {
        for ( Integer presentIndex : presentIndexes ) {
            initialSequence.swap(presentIndex);
        }
    }
    
    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
