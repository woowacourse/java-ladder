package com.woowacourse.laddergame.domain.dto;

import com.woowacourse.laddergame.domain.vo.LadderMatchingResultVo;
import com.woowacourse.laddergame.domain.vo.MadeLadderVo;

public class LadderGameDto {
    private MadeLadderVo madeLadderVO;
    private LadderMatchingResultVo ladderMatchingResultVo;

    public void setMadeLadderVO(MadeLadderVo madeLadderVO) {
        this.madeLadderVO = madeLadderVO;
    }

    public MadeLadderVo getMadeLadderVO() {
        return madeLadderVO;
    }

    public LadderMatchingResultVo getLadderMatchingResultVo() {
        return ladderMatchingResultVo;
    }

    public void setLadderMatchingResultVo(LadderMatchingResultVo ladderMatchingResultVo) {
        this.ladderMatchingResultVo = ladderMatchingResultVo;
    }
}
