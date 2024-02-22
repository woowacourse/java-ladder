package fixture;

import domain.player.Name;

public class NameFixture {
    public static Name 이름(String name) {
        return new Name(name);
    }

    public static Name 이름() {
        return 이름("prin");
    }
}
