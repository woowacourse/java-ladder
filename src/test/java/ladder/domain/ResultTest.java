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
        List<Integer> ladderNumbers = Arrays.asList(1,2,0);
        result = new Result(paricipant,endString,ladderNumbers);
    }
    @Test
    public void 게임결과하나얻기(){
        LinkedHashMap<String,String> multiResult =new LinkedHashMap<>();
        multiResult.put("a","2");
        assertThat(result.getResult(Arrays.asList("a"))).isEqualTo(multiResult);
    }

    @Test
    public void 게임결과여러개얻기(){
        LinkedHashMap<String,String> multiResult =new LinkedHashMap<>();
        multiResult.put("a","2");
        multiResult.put("b","3");
        assertThat(result.getResult(Arrays.asList("a","b"))).isEqualTo(multiResult);
    }

    @Test
    public void All키워드로얻기(){
        LinkedHashMap<String,String> multiResult =new LinkedHashMap<>();
        multiResult.put("a","2");
        multiResult.put("b","3");
        multiResult.put("c","1");
        assertThat(result.getResult(Arrays.asList("l"))).isEqualTo(multiResult);
        assertThat(result.getResult(Arrays.asList("All"))).isEqualTo(multiResult);
        assertThat(result.getResult(Arrays.asList("aLl"))).isEqualTo(multiResult);

    }


}