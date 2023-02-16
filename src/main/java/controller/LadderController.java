package controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import model.Height;
import model.Ladder;
import model.Names;
import model.LadderMaker;
import utils.LadderStatus;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;
    private final Map<LadderStatus, Supplier<LadderStatus>> mappings = new EnumMap<>(LadderStatus.class);

    public LadderController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
        initMappings();
    }

    private void initMappings() {
        mappings.put(LadderStatus.INPUT_PARTICIPANT_NAMES, this::inputParticipantsName);
        mappings.put(LadderStatus.GENERATE_LADDER, this::generateLadder);
        mappings.put(LadderStatus.PRINT_LADDER, this::printLadder);
    }

    public LadderStatus run(LadderStatus ladderStatus) {
        return mappings.get(ladderStatus).get();
    }

    private LadderStatus inputParticipantsName() {
        outputView.noticeInputParticipants();

        List<String> participantsName = inputView.inputNameOfParticipants();
        ladderMaker.initParticipants(participantsName);

        return LadderStatus.GENERATE_LADDER;
    }

    private LadderStatus generateLadder() {
        outputView.noticeInputHeightOfLadder();

        int heightOfLadder = inputView.inputHeightOfLadder();
        Height height = new Height(heightOfLadder);
        Names participantsName = ladderMaker.getParticipantsName();

        ladderMaker.initLadder(height, participantsName.getTotalParticipantSize());
        return LadderStatus.PRINT_LADDER;
    }

    private LadderStatus printLadder() {
        outputView.noticeResult();

        Names participantsName = ladderMaker.getParticipantsName();
        Ladder ladder = ladderMaker.getLadder();

        outputView.printNameOfParticipants(participantsName);
        outputView.printLadder(ladder);
        return LadderStatus.APPLICATION_EXIT;
    }
}
