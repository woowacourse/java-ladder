import domain.LadderGame;
import domain.Lines;
import domain.People;
import domain.Person;
import domain.Rewards;
import java.util.List;
import java.util.stream.Collectors;
import ui.input.InputView;
import ui.output.OutputView;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        inputPeople(ladderGame);
        Rewards rewards = inputRewards(ladderGame, ladderGame.getPeople().getPeople().size());
        int ladderHeight = InputView.inputLadderHeight();
        ladderGame.createLines(ladderGame.getPeople().getPeople().size(), ladderHeight);
        ladderGame.processResult(ladderGame.getPeople(), ladderGame.getLines());
        OutputView.printLadderResult(ladderGame.getPeople(), ladderGame.getLines(), rewards);
        repeatPrintPeopleResultUntilAll(rewards, ladderGame.getPeople());
    }

    private static void inputPeople(LadderGame ladderGame) {
        while (true) {
            try {
                List<String> names = InputView.inputPersonName();
                ladderGame.createPeople(names);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Rewards inputRewards(LadderGame ladderGame, int peopleNum) {
        while (true) {
            try {
                List<String> names = InputView.inputRewards(peopleNum);
                return ladderGame.createRewards(names, peopleNum);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputTargetPerson(People people) {
        while (true) {
            try {
                String name = InputView.inputNameSeeResultWantsPerson();
                validateNameInPeople(name, people);
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateNameInPeople(String name, People people) {
        List<Person> findPerson = people.getPeople().stream().filter(p -> p.getName().getPersonName().equals(name))
                .collect(Collectors.toList());
        if (name.equals("all")) {
            return;
        }
        if (findPerson.size() != 1) {
            throw new IllegalArgumentException("결과를 출력할 참가자를 찾지 못했습니다.");
        }
    }

    public static void repeatPrintPeopleResultUntilAll(Rewards inputRewards, People processedPeople) {
        while (true) {
            String targetName = inputTargetPerson(processedPeople);
            OutputView.printRewardResult(inputRewards, processedPeople, targetName);
            if (targetName.equals("all")) {
                return;
            }
        }
    }
}
