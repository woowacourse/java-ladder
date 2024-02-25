package model;

@FunctionalInterface
public interface BooleanGenerator {

    boolean updateFalseIfTrue(boolean isTrue);
}
