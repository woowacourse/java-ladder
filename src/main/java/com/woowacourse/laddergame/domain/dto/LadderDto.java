package com.woowacourse.laddergame.domain.dto;

import com.woowacourse.laddergame.domain.vo.HeightVo;
import com.woowacourse.laddergame.domain.vo.LadderResultsVo;
import com.woowacourse.laddergame.domain.vo.PlayerNamesVo;

public class LadderDto {
    private PlayerNamesVo playerNamesVo;
    private HeightVo heightVo;
    private LadderResultsVo ladderResultsVo;

    public PlayerNamesVo getPlayerNamesVo() {
        return playerNamesVo;
    }

    public void setPlayerNamesVo(PlayerNamesVo playerNamesVo) {
        if (!checkEqualSize(playerNamesVo, ladderResultsVo)) {
            throw new IllegalArgumentException("플레이어 수와 사다리 결과의 수가 다릅니다");
        }
        this.playerNamesVo = playerNamesVo;
    }

    public HeightVo getHeightVo() {
        return heightVo;
    }

    public void setHeightVo(HeightVo heightVo) {
        this.heightVo = heightVo;
    }

    public LadderResultsVo getLadderResultsVo() {
        return ladderResultsVo;
    }

    public void setLadderResultsVo(LadderResultsVo ladderResultsVo) {
        if (!checkEqualSize(playerNamesVo, ladderResultsVo)) {
            throw new IllegalArgumentException("플레이어 수와 사다리 결과의 수가 다릅니다");
        }
        this.ladderResultsVo = ladderResultsVo;
    }

    private boolean checkEqualSize(PlayerNamesVo playerNamesVO, LadderResultsVo ladderResultsVo) {
        if (playerNamesVO != null && ladderResultsVo != null) {
            return playerNamesVO.size() == ladderResultsVo.size();
        }

        return true;
    }
}
