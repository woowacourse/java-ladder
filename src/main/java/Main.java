import domain.Ladder;
import domain.Line;
import domain.Players;
import domain.Stick;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Players players;

    public static void main(String[] args) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String inputNames = scanner.nextLine().trim();
        List<String> names = Arrays.stream(inputNames.split(",")).toList();
        Players players = new Players(names);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputHeight = scanner.nextLine();
        int height;
        try {
            height = Integer.parseInt(inputHeight);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("높이는 정수여야 합니다.");
        }

        Ladder ladder = new Ladder(height, players.getPlayers().size());


        System.out.println("실행결과");

        players.getPlayers().forEach(player -> {
            String name = player.getName();
            System.out.printf("%5s ", name);
        });

        System.out.println();


        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            System.out.print("     |");
            List<Stick> sticks = line.getSticks();
            for (Stick stick : sticks) {
                String shape = stick.getShape();
                System.out.print(shape.repeat(5));
            System.out.print("|");
            }
            System.out.println();
        }
    }
}
