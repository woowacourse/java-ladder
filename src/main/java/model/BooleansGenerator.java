package model;

import java.util.List;

@FunctionalInterface
public interface BooleansGenerator {
    List<Boolean> generateNotConsecutiveTrue();
}
