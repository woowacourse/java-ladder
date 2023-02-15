import java.util.ArrayList;
import java.util.List;

public class Line {

    private final int numberOfLine;
    private List<LineStatus> line = new ArrayList<>();

    public Line(int numberOfLine, LineGenerator lineGenerator) {
        this.numberOfLine = numberOfLine;
        makeLine(lineGenerator);
    }

    private void makeLine(LineGenerator lineGenerator) {
        line.add(LineStatus.findBy(lineGenerator.generate(false)));
        for (int i = 1; i < this.numberOfLine; i++) {
            line.add(LineStatus.findBy(lineGenerator.generate(line.get(i-1).getStatus())));
        }
    }

    public List<LineStatus> getLine() {
        return this.line;
    }
}
