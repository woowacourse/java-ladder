import java.lang.module.FindException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderGenerator {

    private final Height height;
    private final Integer playerCount;

    public LadderGenerator(Height height, Integer playerCount) {
        this.height = height;
        this.playerCount = playerCount;
    }

    public LadderLeg generateDownLadderLeg() {
        return new LadderLeg(IntStream.range(0, height.getHeight())
                                      .mapToObj(index -> Direction.DOWN)
                                      .map(LadderPiece::new)
                                      .toList());
    }

    public LadderLeg generateLadderLeg(LadderLeg previousLadderLeg, DirectionGenerator directionGenerator) {
        return new LadderLeg(IntStream.range(0, height.getHeight())
                                      .mapToObj(index -> {
                                          if (previousLadderLeg.hasRightDirectionAtIndex(index)) {
                                              return Direction.LEFT;
                                          }
                                          return directionGenerator.generate();
                                      })
                                      .map(LadderPiece::new)
                                      .toList());
    }

}
