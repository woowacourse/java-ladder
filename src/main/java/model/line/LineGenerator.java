package model.line;

import model.line.Line;

public interface LineGenerator {
    int UNCONNECTED = 0;
    int CONNECTED = 1;

    Line generateLine(int width);
}
