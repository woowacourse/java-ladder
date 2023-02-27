package domain;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Person {

    private final PersonName name;
    private int position;

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    final static int FIRST_INDEX = 0;


    public Person(String name, int initPosition) {
        validateNameLength(name);
        this.name = new PersonName(name);
        this.position = initPosition;
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1~" + MAX_NAME_LENGTH + "글자여야 합니다.");
        }
    }

    public PersonName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goLeft() {
        --position;
    }

    public void goRight() {
        ++position;
    }


    public void move(Line line, int peopleSize) {
        int lastPosition = peopleSize - 1;
        if (position != lastPosition && line.getPoints().get(position).status()) {
            ++position;
            return;
        }
        int leftPosition = position - 1;
        if (position != FIRST_INDEX && line.getPoints().get(leftPosition).status()) {
            --position;
        }
    }
}
