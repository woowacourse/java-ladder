package domain;

import exception.DuplicateNameException;
import exception.EmpytInputException;
import exception.InvalidParticipantsCountException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {

    private final List<Person> people = new ArrayList<>();

    public Participants(String participantNames) {
        validate(participantNames);
        joinAllParticipants(participantNames);
    }

    private void joinAllParticipants(String participantNames) {
        splitNames(participantNames).forEach((name) -> people.add(new Person(name)));
    }

    private void validate(String participantNames) {
        if (!isExist(participantNames)) {
            throw new EmpytInputException();
        }
        List<String> splitNames = splitNames(participantNames);
        if (!isUnique(splitNames)) {
            throw new DuplicateNameException();
        }
        if (isValidCount(splitNames)) {
            throw new InvalidParticipantsCountException();
        }
    }

    private boolean isExist(String participantNames) {
        return participantNames != null && !participantNames.isBlank();
    }

    private boolean isValidCount(List<String> names) {
        final int minParticipantCount = 2;
        final int maxParticipantCount = 10;
        return names.size() < minParticipantCount || names.size() > maxParticipantCount;
    }

    private boolean isUnique(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        return uniqueNames.size() == names.size();
    }

    private List<String> splitNames(String participantNames) {
        final String delimiter = ",";
        return List.of(participantNames.split(delimiter, -1));
    }

    public int getParticipantCount() {
        return people.size();
    }

    public List<String> getParticipantsNames() {
        return people.stream().map(Person::getName).collect(Collectors.toList());
    }
}
