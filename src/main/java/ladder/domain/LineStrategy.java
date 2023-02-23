package ladder.domain;

import java.util.List;

public interface LineStrategy {
    List<Step> generate(int sectionCount);
}
