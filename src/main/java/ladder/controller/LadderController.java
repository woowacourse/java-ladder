package ladder.controller;

import ladder.domain.Lines;
import ladder.domain.Names;

public class LadderController {

    private final Names names;
    private final Lines lines;

    public LadderController(Names names, Lines lines) {
        this.names = names;
        this.lines = lines;
    }
}
