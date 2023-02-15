package domain;

import java.util.Collections;
import java.util.List;

public class Names {
    //TODO: List<String> 대신 List<Name> 고려
    public Names(List<String> names) {
        names.forEach(name -> {
            if (Collections.frequency(names, name) > 1) {
                throw new IllegalArgumentException("중복된 사람은 참여할 수 없습니다.");
            }
        });

        if(names.size() == 1){
            throw new IllegalArgumentException("최소 2명이상 참가자가 필요합니다.");
        }

        if(names.size() >= 11){
            throw new IllegalArgumentException("최대 10명 이하 참가자가 필요합니다.");
        }
    }
}
