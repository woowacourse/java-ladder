package model;

import java.util.List;

public interface BuildStrategy<T> {

    List<T> generate(int size);
}
