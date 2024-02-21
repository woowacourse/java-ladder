package domain;

import java.util.List;

interface RowInfoGenerator {
    List<Boolean> generate(int width);
}
