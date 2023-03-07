package laddergame.model.people;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import laddergame.model.ladder.Ladder;

public class Results {
    private static final String RESULT_TYPE_ALL = "all";

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public static Results from(People people, Ladder ladder, Prizes prizes) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            Person person = people.getPeople().get(i);
            int prizeIndex = getPrizeIndex(ladder, i);
            results.add(new Result(person, prizes.getPrize(prizeIndex)));
        }
        return new Results(results);
    }

    private static int getPrizeIndex(Ladder ladder, int index) {
        for (int j = 0; j < ladder.getHeight(); j++) {
            index = ladder.getLine(j).getPoint(index).moveDirection(index);
        }
        return index;
    }

    public Result findResultOfPerson(String name) {
        Optional<Result> findResult = results.stream()
                .filter(result -> result.getPersonNameToString().equals(name))
                .findAny();
        if (findResult.isPresent()) {
            return findResult.get();
        }
        throw new IllegalArgumentException("결과를 확인하고 싶은 참여자의 이름을 다시 확인해주세요.");
    }

    public boolean isResultTypeAll(String resultType) {
        return resultType.equals(RESULT_TYPE_ALL);
    }

    public List<Result> getResults() {
        return results;
    }
}
