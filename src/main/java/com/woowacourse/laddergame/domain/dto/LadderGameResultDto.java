package com.woowacourse.laddergame.domain.dto;

import com.woowacourse.laddergame.domain.vo.LadderGameResultVo;
import com.woowacourse.laddergame.domain.vo.MadeLadderVO;

public class LadderGameResultDto {
    private MadeLadderVO madeLadderVO;
    private LadderGameResultVo ladderGameResultVo;

    public MadeLadderVO getMadeLadderVO() {
        return madeLadderVO;
    }

    public void setMadeLadderVO(MadeLadderVO madeLadderVO) {
        this.madeLadderVO = madeLadderVO;
    }

    public LadderGameResultVo getLadderGameResultVo() {
        return ladderGameResultVo;
    }

    public void setLadderGameResultVo(LadderGameResultVo ladderGameResultVo) {
        this.ladderGameResultVo = ladderGameResultVo;
    }
}
