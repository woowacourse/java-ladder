package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import util.RandomBooleanGenerator;
import util.RandomValueGenerator;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class LadderGame {

    private People people;
    private Lines lines;
    private Rewards rewards;

    public void createPeople(List<String> names) {
        validateDuplicateName(names);
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            people.add(new Person(names.get(i), i));
        }
        this.people = new People(people);
    }

    private void validateDuplicateName(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException("참가지 이름은 중복일 수 없습니다.");
        }
    }

    public void createLines(int height, RandomValueGenerator generator) {
        int width = people.getPeople().size();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.newInstanceWithPersonCount(width, generator));
        }
        this.lines = new Lines(lines);
    }

    public void createRewards(List<String> names, int peopleNum) {
        List<Reward> rewards = new ArrayList<>();
        for (String name : names) {
            rewards.add(new Reward(name));
        }

        this.rewards = new Rewards(rewards, peopleNum);
    }

    public void processResult() {
        for (Line line : lines.getLines()) {
            calculateLine(line);
        }
    }

    private void calculateLine(Line line) {
        for (Person person : people.getPeople()) {
            person.move(line, people.getPeople().size());
        }
    }

    public People getPeople(){
        return people;
    }

    public Lines getLines(){
        return lines;
    }

    public Rewards getRewards(){
        return rewards;
    }
}
