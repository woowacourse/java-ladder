package ladder.domain;

import java.util.Objects;

public class Bar {
    private final boolean bar;

    public Bar(boolean bar) {
        this.bar = bar;
    }

    public Bar(BarGenerator barGenerator) {
        this.bar = barGenerator.createBar();
    }

    public boolean isExistBar(){
        return this.bar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar1 = (Bar) o;
        return bar == bar1.bar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bar);
    }
}
