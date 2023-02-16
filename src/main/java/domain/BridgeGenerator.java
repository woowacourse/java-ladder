package domain;

import java.util.List;

@FunctionalInterface
public interface BridgeGenerator {

    List<Boolean> generate(int count);
}
