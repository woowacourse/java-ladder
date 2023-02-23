package domain;

import javax.sound.midi.Sequence;
import java.util.List;

public class SequenceSwapper {
    private final List<Integer> sequence;

    private SequenceSwapper(List<Integer> sequence){
        this.sequence = sequence;
    }

    public static SequenceSwapper of(List<Integer> sequence){
        return new SequenceSwapper(sequence);
    }

    public List<Integer> getSequence() {
        return sequence;
    }
}