package model;

public abstract class Name {
    private final String name;

    protected Name(final String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract void validateName(final String name);
}
