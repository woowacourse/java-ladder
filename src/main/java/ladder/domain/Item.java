package ladder.domain;


/**
 * 결과 품목의 위치와 이름을 가지는 클래스
 * <p>
 * 이 클래스의 책임이 무엇인지 애매해보여요 사실상 객체보다는 자료구조라고 보는 쪽이 맞을 것 같아요
 */
public class Item {

    private final ItemName name;
    private final Position position;

    Item(String name, int position) {
        this.name = new ItemName(name);
        this.position = Position.valueOf(position);
    }

    public String getName() {
        return name.getName();
    }

    boolean isSamePosition(Position other) {
        return position == other;
    }
}
