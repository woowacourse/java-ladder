package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladders implements Supplier<List<Ladder>> {
    private final Height height;
    private final List<Ladder> ladders;
    private final LadderGenerator ladderGenerator;

    public Ladders(Height height, LadderGenerator ladderGenerator) {
        this.height = height;
        this.ladderGenerator = ladderGenerator;
        this.ladders = generator();
    }

    private List<Ladder> generator() {
        return IntStream.range(0, height.getHeight())
                .mapToObj(i->new Ladder(ladderGenerator.generate()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Ladder> get() {
        return new ArrayList<>(ladders);
    }
}
