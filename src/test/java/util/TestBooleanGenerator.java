package util;

public class TestBooleanGenerator implements BooleanGenerator {

    private final boolean isConnectable;

    // TODO: 생성자를 새로 만들지 말고 setter를 활용할 수 있게 변경하기
    public TestBooleanGenerator(boolean isConnectable) {
        this.isConnectable = isConnectable;
    }

    @Override
    public boolean generate() {
        return isConnectable;
    }
}
