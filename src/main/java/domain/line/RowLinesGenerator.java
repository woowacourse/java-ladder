package domain.line;

import java.util.List;

public interface RowLinesGenerator {

    List<RowLine> generateLines(int personCount, int height);
}
