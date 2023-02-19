package laddergame.fixture;

import laddergame.domain.Name;

public abstract class NameFixture {
    public static Name createNameRosie() {
        return new Name("rosie");
    }

    public static Name createNameHyena() {
        return new Name("hyena");
    }

    public static Name createNameJayon() {
        return new Name("jayon");
    }
}
