package domain.ladder;

import java.util.List;

public interface SticksGenerator {

    List<Stick> generate(int stickCount, StickGenerator stickGenerator);
}
