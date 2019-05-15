package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Pipe> pipes;
    private final int width;
    private final int height;

    Ladder(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.pipes = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                pipes.add(new Pipe(new Position(j,i)));
            }
        }
    }

    public List<Pipe> getPipes() {
        return pipes;
    }

    public void connectPipes() {
        IntStream.range(0, pipes.size() - 1).forEach(i -> {
            connectPipe(pipes.get(i), pipes.get(i + 1));
        });
    }

    public void connectPipe(Pipe pipe, Pipe nextPipe) {
        if (pipe.isMatchWidth(width)) {
            return;
        }

        if (pipe.isLinked()) {
            return;
        }
        if ((int) (Math.random() * 2) == 1) {
            pipe.connectOn();
            nextPipe.connectOn();
            nextPipe.construct();
        }
    }


}
