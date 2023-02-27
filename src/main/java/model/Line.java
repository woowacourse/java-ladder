package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import strategy.PassGenerator;

public class Line {

    private static final int LEFT_BLOCK_INDEX = 1;
    private static final int MINIMUM_PARTICIPANT_NUM = 2;

    private final List<Block> line = new ArrayList<>();

    public Line(int personCount, PassGenerator passGenerator) {
        validateMinPerson(personCount);
        line.add(Block.buildFirstBlock(passGenerator.generate()));
        while (personCount-- > 2) {
            line.add(Block.buildMiddleBlock(getLeftBlock(), passGenerator.generate()));
        }
        line.add(Block.buildLastBlock(getLeftBlock()));
    }

    private Block getLeftBlock() {
        return line.get(line.size() - LEFT_BLOCK_INDEX);
    }

    private void validateMinPerson(int personCount) {
        if (personCount < MINIMUM_PARTICIPANT_NUM) {
            throw new IllegalArgumentException("참여인원은 최소 두명이어야 합니다");
        }
    }

    public int nextLineIndex(int playerIndex) {
        Block currentBlock = line.get(playerIndex);
        return currentBlock.nextLineIndex(playerIndex);
    }

    public List<String> getLineBlockPass() {
        return line.stream()
            .map(block -> block.getPass().toString())
            .collect(Collectors.toList());
    }
}
