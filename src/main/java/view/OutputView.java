package view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import model.Ladder;
import model.LadderRow;
import model.Name;
import model.Participant;
import model.Participants;

import java.util.List;

public class OutputView implements AutoCloseable {

    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String NAME_FORMAT = "%5s ";
    private static final String NEWLINE = "\n";

    private final BufferedWriter writer;

    public OutputView() {
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void printResult() throws IOException {
        writer.write(RESULT_MESSAGE);
    }

    public void printParticipantsName(Participants participants) throws IOException {
        List<Name> participantsName = participants.getParticipants().stream()
                .map(Participant::getName)
                .toList();
        participantsName.forEach(name -> {
            try {
                writer.write(NAME_FORMAT.formatted(name));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.write(NEWLINE);
    }

    public void printLadder(Ladder ladder) throws IOException {
        for (int i = 0; i < ladder.getHeight(); i++) {
            printRow(ladder.getRow(i));
            writer.write(NEWLINE);
        }
    }

    private void printRow(LadderRow ladderRow) throws IOException {
        writer.write(LadderComponent.EMPTY_LINE.toString());
        for (boolean isLine : ladderRow.isLines()) {
            writer.write(LadderComponent.DIVISION.toString());
            writer.write(LadderComponent.match(isLine).toString());
        }
        writer.write(LadderComponent.DIVISION.toString());
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}
