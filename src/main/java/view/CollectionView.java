package view;

import domain.Participant;
import domain.Participants;
import domain.Result;
import domain.Results;

import java.util.stream.Collectors;

// TODO: Generics 사용해보기?
public class CollectionView {
    private static final String ITEM_DELIMITER = "";
    private static final String RIGHT_ALIGN_PLACEHOLDER = "%6s";

    public static String formatParticipants(Participants participants) {
        return participants.getParticipants().stream()
                .map(CollectionView::formatParticipant)
                .collect(Collectors.joining(ITEM_DELIMITER));
    }

    private static String formatParticipant(Participant participant) {
        return String.format(RIGHT_ALIGN_PLACEHOLDER, participant.getName());
    }

    public static String formatResults(Results results) {
        return results.getResults().stream()
                .map(CollectionView::formatResult)
                .collect(Collectors.joining(ITEM_DELIMITER));
    }

    private static String formatResult(Result result) {
        return String.format(RIGHT_ALIGN_PLACEHOLDER, result.getValue());
    }
}
