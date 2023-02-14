package ladder.domain;

public class Bar {
    private final boolean bar;

    public Bar(BarGenerator barGenerator) {
        this.bar = barGenerator.createBar();
    }

    public boolean isExistBar(){
        return this.bar;
    }
}
