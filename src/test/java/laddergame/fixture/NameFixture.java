package laddergame.fixture;

import laddergame.domain.Name;

public abstract class NameFixture {
    public static Name getNameRosie() {
        return new Name("rosie");
    }

    public static Name getNameHyena() {
        return new Name("hyena");
    }

    public static Name getNameJayon() {
        return new Name("jayon");
    }
}
