package domain;

import exception.DuplicateNameException;
import exception.EmpytInputException;
import exception.InvalidParticipantsCountException;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    public static final int MIN_PARTICIPANT_COUNT = 2;
    public static final int MAX_PARTICIPANT_COUNT = 10;
    public static final String DELIMITER = ",";
    private People people;

    public Participants(String participantNames) {
        validate(participantNames);
        joinAllParticipants(participantNames);
    }

    private void validate(String participantNames) {
        if (isBlank(participantNames)) {
            throw new EmpytInputException();
        }
        List<String> splitNames = splitNames(participantNames);
        if (isInvalidCount(splitNames)) {
            throw new InvalidParticipantsCountException();
        }
        if (isDuplicate(splitNames)) {
            throw new DuplicateNameException();
        }
    }

    private boolean isBlank(String participantNames) {
        return participantNames == null || participantNames.isBlank();
    }

    private List<String> splitNames(String participantNames) {
        return List.of(participantNames.split(DELIMITER));
    }

    private boolean isInvalidCount(List<String> names) {
        return names.size() < MIN_PARTICIPANT_COUNT || names.size() > MAX_PARTICIPANT_COUNT;
    }

    private boolean isDuplicate(List<String> names) {
        return names.size() > names.stream().distinct().count();
    }

    private void joinAllParticipants(String participantNames) {
        List<Person> people = splitNames(participantNames).stream().map(Person::new)
            .collect(Collectors.toList());
        this.people = new People(people);
    }

    public int getCount() {
        return people.getSize();
    }

    public List<String> getNames() {
        return people.getAllPerson().stream()
            .map(Person::getName)
            .collect(Collectors.toList());
    }
}
