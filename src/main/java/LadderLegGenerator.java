import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LadderLegGenerator {

    private final Height height;

    public LadderLegGenerator(Height height) {
        this.height = height;
    }

    public LadderLeg generateDownLadderLeg() {
        return new LadderLeg(IntStream.range(0, height.getHeight())
                                      .mapToObj(index -> Direction.DOWN)
                                      .map(LadderPiece::new)
                                      .toList());
    }

    public LadderLeg generateLadderLeg(LadderLeg previousLadderLeg, Supplier<Direction>directionSupplier) {
        return new LadderLeg(IntStream.range(0, height.getHeight())
                                      .mapToObj(index -> {
                                          if (previousLadderLeg.hasRightDirectionAtIndex(index)) {
                                              return Direction.LEFT;
                                          }
                                          return directionSupplier.get();
                                      })
                                      .map(LadderPiece::new)
                                      .toList());
    }

}
