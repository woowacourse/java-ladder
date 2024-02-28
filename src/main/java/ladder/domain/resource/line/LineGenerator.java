package ladder.domain.resource.line;

import java.util.List;
import ladder.domain.resource.direction.Direction;

public interface LineGenerator {

    public Line generateLine();

    public void insertDirectionIntoLine(Line line, int count);
}
