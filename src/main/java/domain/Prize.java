package domain;

import java.util.Objects;

public class Prize {

	private final Name name;

	public Prize(String name) {
		this.name = new Name(name);
	}

	public String getName() {
		return name.value();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Prize prize = (Prize)o;
		return Objects.equals(name, prize.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
