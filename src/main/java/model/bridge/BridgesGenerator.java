package model.bridge;

import java.util.List;

@FunctionalInterface
public interface BridgesGenerator {
    List<Bridge> pickBridges(int count);
}
