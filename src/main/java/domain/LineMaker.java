package domain;

import generator.LineGenerator;
import java.util.ArrayList;
import java.util.List;

public class LineMaker {

    private final LineGenerator lineGenerator;

    public LineMaker(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public List<LineStatus> makeLineStatus(int numberOfLine) {
        List<LineStatus> lineStatuses = new ArrayList<>();

        makeFirstLineStatus(lineStatuses);
        makeElseLineStatus(lineStatuses, numberOfLine);

        return lineStatuses;
    }

    private void makeFirstLineStatus(List<LineStatus> lineStatuses) {
        lineStatuses.add(LineStatus.findBy(lineGenerator.generate(false)));
    }

    private void makeElseLineStatus(List<LineStatus> lineStatuses, int numberOfLine) {
        for (int i = 1; i < numberOfLine; i++) {
            int leftIndex = i - 1;

            lineStatuses.add(LineStatus.findBy(lineGenerator.generate(lineStatuses.get(leftIndex).getStatus())));
        }
    }
}
