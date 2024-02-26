package ladder.service;

import ladder.domain.Compensation;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameService {
    public People getPeople(List<String> names) {
        return makePeople(names);
    }

    public Compensation getCompensation(List<String> compensations, People people) {
        return makeCompensation(compensations, people);
    }

    public Ladder getLadder(String height, People people) {
        return makeLadder(height, people);
    }

    private People makePeople(List<String> names) {
        try {
            return new People(names);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
        return null;
    }

    private Compensation makeCompensation(List<String> compensations, People people) {
        try {
            return new Compensation(compensations, people.getNames().size());
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
        return null;
    }

    private Ladder makeLadder(String height, People people) {
        try {
            int peopleNumber = people.getNames().size();
            return new Ladder(Integer.parseInt(height), peopleNumber);
        } catch (NumberFormatException e) {
            OutputView.printMessage("사다리의 높이는 1이상 100이하의 자연수여야 합니다");
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
        return null;
    }
}
