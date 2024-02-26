package domain;

public class Prize {

	private final Name name;

	public Prize(String name) {
		this.name = new Name(name);
	}

	public String getName() {
		return name.value();
	}
}
