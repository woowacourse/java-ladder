package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesStringTest {
    @Test
    @DisplayName("이름들의 문자열은 공백으로 구분되어 생성")
    void testNamesSperator() {
        Names names = new Names("aaaaa,bbbbb,ccccc,ddddd,eeeee");
        String actual = NamesString.from(names);
        String expected = "aaaaa bbbbb ccccc ddddd eeeee";
        Assertions.assertThat(actual).isEqualTo(expected);
    }


}