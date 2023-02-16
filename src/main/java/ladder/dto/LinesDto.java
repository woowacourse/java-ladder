package ladder.dto;

import java.util.List;
import ladder.domain.Leg;

public class LinesDto {

  private final List<List<Leg>> lines;
  private final int height;

  public LinesDto(List<List<Leg>> lines, int height) {
    this.lines = lines;
    this.height = height;
  }

  public List<List<Leg>> getLines() {
    return lines;
  }
}
