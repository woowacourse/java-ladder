package view.constant;

public enum Sign{
    COMMA(",", "쉼표");

    private final String shape;
    private final String korean;

    Sign(final String shape, final String korean){
        this.shape=shape;
        this.korean=korean;
    }

    public String getShape() {
        return shape;
    }

    public String getKorean() {
        return korean;
    }
}