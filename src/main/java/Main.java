import ladder.domain.Ladder;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = Ladder.create(3, 7);

        System.out.println(ladder.toString());
    }
}
