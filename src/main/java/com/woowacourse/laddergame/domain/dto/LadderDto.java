package com.woowacourse.laddergame.domain.dto;

import com.woowacourse.laddergame.domain.vo.HeightVo;
import com.woowacourse.laddergame.domain.vo.LadderResultsVo;
import com.woowacourse.laddergame.domain.vo.PlayerNamesVo;

public class LadderDto {
    private PlayerNamesVo playerNamesVo;
    private HeightVo heightVo;
    private LadderResultsVo ladderResultsVo;

    public LadderDto(PlayerNamesVo playerNamesVo, HeightVo heightVo, LadderResultsVo ladderResultsVo) {
        checkNull(playerNamesVo, heightVo, ladderResultsVo);
        if (!checkEqualSize(playerNamesVo, ladderResultsVo)) {
            throw new IllegalArgumentException("플레이어 수와 사다리 결과의 수가 다릅니다");
        }

        this.playerNamesVo = playerNamesVo;
        this.heightVo = heightVo;
        this.ladderResultsVo = ladderResultsVo;
    }

    private void checkNull(PlayerNamesVo playerNamesVo, HeightVo heightVo, LadderResultsVo ladderResultsVo) {
        if (playerNamesVo == null || heightVo == null || ladderResultsVo == null) {
            throw new IllegalArgumentException("Null 값이 존재합니다.");
        }
    }

    private boolean checkEqualSize(PlayerNamesVo playerNamesVo, LadderResultsVo ladderResultsVo) {
        return playerNamesVo.size() == ladderResultsVo.size();
    }

    public PlayerNamesVo getPlayerNamesVo() {
        return playerNamesVo;
    }

    public HeightVo getHeightVo() {
        return heightVo;
    }

    public LadderResultsVo getLadderResultsVo() {
        return ladderResultsVo;
    }
}
