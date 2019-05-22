package ladder.generator;

import ladder.domain.Line;

public class CustomLineGenerator implements LineGenerator {
    private Line line;

    CustomLineGenerator(Line line){
        this.line = line;
    }

    @Override
    public Line makeLine(int countOfPlayers) {
        if (line.isSameLength(countOfPlayers)){
            throw new IllegalArgumentException();
        }
        return line;
    }
}
