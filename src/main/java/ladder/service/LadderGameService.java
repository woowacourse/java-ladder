package ladder.service;

import ladder.domain.Compensation;
import ladder.domain.Ladder;
import ladder.domain.People;

import java.util.List;

public class LadderGameService {
    public People getPeople(List<String> names) throws IllegalArgumentException {
        return new People(names);
    }

    public Compensation getCompensation(List<String> compensations, People people)
            throws IllegalArgumentException {
        return new Compensation(compensations, people.getNames().size());
    }

    public Ladder getLadder(String height, People people)
            throws IllegalArgumentException {
        try {
            int peopleNumber = people.getNames().size();
            return new Ladder(Integer.parseInt(height), peopleNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 100이하의 자연수여야 합니다");
        }
    }
}
