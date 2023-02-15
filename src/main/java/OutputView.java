import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printUsers(List<String> users) {
        System.out.print(users.get(0));
        for (int index = 1;index < users.size();index++) {
            System.out.print(" ".repeat(6-users.get(index).length()) + users.get(index));
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        String collect = ladder.getLadder().stream()
                .map(i -> i ? "-".repeat(5) : " ".repeat(5))
                .collect(Collectors.joining("|"));
        System.out.println("    |"+collect+"|");
    }
}
