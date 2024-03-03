package domain;

import java.util.List;

public sealed interface LineGenerateStrategy permits AbstractLineGenerateStrategy {
    List<Boolean> generate(int lineSize);
}
