package ladder.domain;

// TODO : Getter의 성질만 가지고있다는 부분에 대한 의문 가져보기
public class Product {

    private final String name;

    public Product(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
