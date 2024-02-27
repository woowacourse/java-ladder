package domain.prize;

import domain.Name;

public class Prize {

	private final Name name;

	private Prize(Name name) {
		this.name = name;
	}

	public static Prize fromName(String name) {
		return new Prize(new Name(name));
	}

	public String getName() {
		return name.value();
	}
}