package domain;

import exception.EmpytInputException;
import exception.InvalidParticipantsCountException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Participants {

    private final List<Person> people = new ArrayList<>();
    private final Map<String, Integer> checkDuplicate = new HashMap<>();

    public Participants(String participantNames) {
        validate(participantNames);
        splitNames(participantNames).forEach((name) -> {
            if (!checkDuplicate.containsKey(name)) {
                checkDuplicate.put(name, 0);
            }
            checkDuplicate.put(name, checkDuplicate.get(name) + 1);
            people.add(new Person(name, checkDuplicate.get(name)));
        });
    }

    private void validate(String participantNames) {
        if (!isExist(participantNames)) {
            throw new EmpytInputException();
        }
        if (isValidCount(splitNames(participantNames))) {
            throw new InvalidParticipantsCountException();
        }
    }

    private boolean isExist(String participantNames) {
        return !(participantNames == null || participantNames.isBlank());
    }

    private boolean isValidCount(List<String> names) {
        final int maxParticipantCount = 10;
        return names.size() > maxParticipantCount;
    }

    private List<String> splitNames(String participantNames) {
        final String delimiter = ",";
        return List.of(participantNames.split(delimiter, -1));
    }

    public List<String> getParticipantsName() {
        return people.stream().map(Person::getName).collect(Collectors.toList());
    }
}
