package domain;

import exception.DuplicateNameException;
import exception.EmptyInputException;
import exception.InvalidParticipantsCountException;
import util.StringUtil;

import java.util.*;

public class Participants {

    private static final String SPLIT_NAME_DELIMITER = ",";
    private static final int MIN_PARTICIPANT_COUNT = 2;
    private static final int MAX_PARTICIPANT_COUNT = 10;

    private final List<Person> people = new ArrayList<>();

    public Participants(String participantNames) {
        validate(participantNames);
        joinAllParticipants(participantNames);
    }

    private void validate(String participantNames) {
        if (StringUtil.isNullOrBlank(participantNames)) {
            throw new EmptyInputException();
        }
        List<String> splitNames = splitNames(participantNames);
        if (isValidCount(splitNames)) {
            throw new InvalidParticipantsCountException();
        }
        if (!isUnique(splitNames)) {
            throw new DuplicateNameException();
        }
    }

    private List<String> splitNames(String participantNames) {
        return List.of(participantNames.split(SPLIT_NAME_DELIMITER));
    }

    private boolean isValidCount(List<String> names) {
        return names.size() < MIN_PARTICIPANT_COUNT || names.size() > MAX_PARTICIPANT_COUNT;
    }

    private boolean isUnique(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        return uniqueNames.size() == names.size();
    }

    private void joinAllParticipants(String participantNames) {
        splitNames(participantNames)
                .forEach((name) -> people.add(new Person(name)));
    }

    public int getParticipantCount() {
        return people.size();
    }

    public List<Person> getParticipantNames() {
        return people;
    }

    public Person getByIndex(int index) {
        return people.get(index);
    }
}
