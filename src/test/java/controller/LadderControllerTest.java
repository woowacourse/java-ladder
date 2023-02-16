package controller;

import static org.assertj.core.api.Assertions.assertThat;

import helper.SpyInputView;
import helper.SpyLadderMaker;
import helper.SpyOutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import utils.LadderStatus;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderControllerTest {

    private static final int CALLED_VALUE = 1;

    private LadderController ladderController;
    private SpyInputView inputView;
    private SpyOutputView outputView;
    private SpyLadderMaker ladderMaker;

    @BeforeEach
    void beforeEach() {
        inputView = new SpyInputView();
        outputView = new SpyOutputView();
        ladderMaker = new SpyLadderMaker();
        ladderController = new LadderController(inputView, outputView, ladderMaker);
    }

    @Test
    void run_메소드는_INPUT_PARTICIPANT_NAMES를_전달하면_GENERATE_LADDER를_반환한다() {
        LadderStatus actual = ladderController.run(LadderStatus.INPUT_PARTICIPANT_NAMES);

        assertThat(outputView.getNoticeInputParticipantsCallCount()).isSameAs(CALLED_VALUE);
        assertThat(inputView.getInputNameOfParticipantsCallCount()).isSameAs(CALLED_VALUE);
        assertThat(ladderMaker.getInitParticipantsCallCount()).isSameAs(CALLED_VALUE);
        assertThat(outputView.getNoticeInputParticipantsCallCount()).isSameAs(CALLED_VALUE);
        assertThat(actual).isSameAs(LadderStatus.GENERATE_LADDER);
    }

    @Test
    void run_메소드는_GENERATE_LADDER를_전달하면_PRINT_LADDER를_반환한다() {
        LadderStatus actual = ladderController.run(LadderStatus.GENERATE_LADDER);

        assertThat(outputView.getNoticeInputHeightOfLadderCallCount()).isSameAs(CALLED_VALUE);
        assertThat(inputView.getInputHeightOfLadderCallCount()).isSameAs(CALLED_VALUE);
        assertThat(ladderMaker.getInitLadderCallCount()).isSameAs(CALLED_VALUE);
        assertThat(ladderMaker.getInitLadderCallCount()).isSameAs(CALLED_VALUE);
        assertThat(actual).isSameAs(LadderStatus.PRINT_LADDER);
    }

    @Test
    void run_메소드는_PRINT_LADDER를_전달하면_APPLICATION_EXIT를_반환한다() {
        LadderStatus actual = ladderController.run(LadderStatus.PRINT_LADDER);

        assertThat(outputView.getNoticeResultCallCount()).isSameAs(CALLED_VALUE);
        assertThat(ladderMaker.getGetLadderCallCount()).isSameAs(CALLED_VALUE);
        assertThat(outputView.getPrintNameOfParticipantsCallCount()).isSameAs(CALLED_VALUE);
        assertThat(outputView.getPrintLadderCallCount()).isSameAs(CALLED_VALUE);
        assertThat(actual).isSameAs(LadderStatus.APPLICATION_EXIT);
    }
}