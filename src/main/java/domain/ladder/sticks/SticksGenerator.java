package domain.ladder.sticks;

import domain.ladder.stick.Stick;

import java.util.List;

public interface SticksGenerator {

    List<Stick> generate(int stickCount);
}
