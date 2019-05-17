package laddergame.domain;

public interface BuilderObject {
    abstract public int getIndexOfName(String name);

    abstract public String getNameOfIndex(int index);

    abstract public boolean isCountsEqual();

    abstract public int getCount();
}
