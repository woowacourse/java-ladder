package ladder.domain.ladder;

import java.util.List;

public interface LineStrategy {
    List<Step> generate(int sectionCount);
}
