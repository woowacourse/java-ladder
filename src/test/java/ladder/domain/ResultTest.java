package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    Result result;
    @BeforeEach
    public void setup(){
        List<Participant> paricipant = Arrays.asList(new Participant("a"),new Participant("b"),new Participant("c"));
        List<String> endString = Arrays.asList("1","2","3");
        result = new Result(paricipant,endString);
    }
    @Test
    public void 게임결과하나얻기(){
        assertThat(result.eachGetResult("a")).isEqualTo("1");
    }

    @Test
    public void 게임결과여러개얻기(){
        LinkedHashMap<String,String> multiResult =new LinkedHashMap<>();
        multiResult.put("a","1");
        multiResult.put("b","2");
        assertThat(result.multiGetResult(Arrays.asList("a","b"))).isEqualTo(multiResult);
    }
}