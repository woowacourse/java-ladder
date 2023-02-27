import domain.LadderGame;
import domain.People;
import domain.Person;
import domain.Rewards;
import java.util.List;
import java.util.stream.Collectors;
import ui.input.InputView;
import ui.output.OutputView;
import util.RandomBooleanGenerator;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Application {
    private static final String VIEW_RESULT_ALL = "all";
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        inputPeople(ladderGame);
        inputRewards(ladderGame);
        int ladderHeight = InputView.inputLadderHeight();
        ladderGame.createLines(ladderHeight, new RandomBooleanGenerator());
        ladderGame.processResult();
        OutputView.printLadderResult(ladderGame.getPeople(), ladderGame.getLines(), ladderGame.getRewards());
        repeatPrintPeopleResultUntilAll(ladderGame.getRewards(), ladderGame.getPeople());
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

    private static void inputRewards(LadderGame ladderGame) {
        int peopleNum = ladderGame.getPeople().getPeople().size();
        while (true) {
            try {
                List<String> names = InputView.inputRewards(peopleNum);
                ladderGame.createRewards(names, peopleNum);
                return;
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
        if (name.equals(VIEW_RESULT_ALL)) {
            return;
        }
        if (findPerson.size() != 1) {
            throw new IllegalArgumentException("결과를 출력할 참가자를 찾지 못했습니다.");
        }
    }

    public static void repeatPrintPeopleResultUntilAll(Rewards inputRewards, People processedPeople) {
        while (true) {
            String targetName = inputTargetPerson(processedPeople);
            if (targetName.equals(VIEW_RESULT_ALL)) {
                OutputView.printRewardResultAll(inputRewards, processedPeople);
                return;
            }
            OutputView.printRewardResult(inputRewards, processedPeople.findPerson(targetName));
        }
    }
}
