package com.woowacourse.ladder.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ParticipantGroup {
    private static final String NAME_DELIMITER = ",";

    private final List<Participant> participants;

    public ParticipantGroup(String commaSeparatedNames) {
        List<String> splitted = Arrays.asList(commaSeparatedNames.trim().split(NAME_DELIMITER));
        List<Participant> sanitized = sanitize(splitted);

        if (sanitized.size() != splitted.size() ||
            sanitized.isEmpty() ||
            checkIfIncludeDuplicateItem(sanitized)) {
            throw new IllegalArgumentException("Invalid name string is included");
        }

        participants = sanitized;
    }

    private boolean checkIfIncludeDuplicateItem(List<Participant> participants) {
        return new HashSet<>(participants).size() != participants.size();
    }

    private List<Participant> sanitize(List<String> splittedNames) {
        return splittedNames.stream()
            .map(Participant::new)
            .collect(Collectors.toList());
    }

    public void forEachParticipants(Consumer<Participant> participantsConsumer) {
        participants.forEach(participantsConsumer);
    }

    public int size() {
        return participants.size();
    }

    public boolean contains(ParticipantGroup other) {
        return participants.containsAll(other.participants);
    }

    public int positionOf(Participant p) {
        return participants.indexOf(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantGroup that = (ParticipantGroup) o;
        return participants.equals(that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ParticipantGroup [ \n");
        sb.append(participants.stream()
            .map(Participant::toString)
            .collect(Collectors.joining(", \n")))
            .append("\n ]");
        return sb.toString();
    }
}
