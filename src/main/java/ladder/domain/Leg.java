package ladder.domain;

public enum Leg {
  BLANK(false), CONNECTED(true); //TODO 더 좋은 네이밍이 있을까요?

  private final boolean value;

  Leg(boolean value) {
    this.value = value;
  }

}

