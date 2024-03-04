package util.generator;

import domain.Leg;

import java.util.List;

public interface LineGenerator {

    List<Leg> generate(int legCount);
}
