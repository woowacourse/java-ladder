package laddergame.domain;

import java.util.List;

public class Line {
    private List<Boolean> line;
    private final int width;

    public Line(List<Boolean> line) {
        this.line = line;
        this.width = line.size();
    }

    public boolean getHandle(int index) {
        return line.get(index);
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("|");

        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i) ? "-----|" : "     |");
        }

        return sb.toString();
    }
}
