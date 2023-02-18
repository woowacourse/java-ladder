package domain;

import java.util.List;

public interface Generator<E> {
    List<E> generate();
}
