package domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResultTest {
    @Nested
    @DisplayName("실행 결과 저장 테스트")
    class SaveResultTest {
        @DisplayName("result에 user와 prize가 올바르게 저장되었는지 확인한다.")
        @Test
        void shouldSuccessSaveResult() {
            String userName = "test";
            String prizeName = "꽝";
            Result result = new Result(List.of("test", "mango"));

            result.saveResult(userName, prizeName);
            assertThat(result.getResults().get(userName)).isEqualTo(prizeName);
        }
    }

    @Nested
    @DisplayName("검색 결과 조회 테스트")
    class FindResultTest {
        @DisplayName("result에서 특정 유저의 결과 검색이 성공하는지 확인한다.")
        @Test
        void shouldSuccessFindOneResult() {
            String searchName = "test";
            String prizeName = "꽝";
            Result result = new Result(List.of("test", "mango"));
            result.saveResult(searchName, prizeName);

            assertThat(result.findOneResult(searchName)).isEqualTo(prizeName);
        }

        @DisplayName("result에서 모든 유저의 결과 검색이 성공하는지 확인한다.")
        @Test
        void shouldSuccessFindAllResult() {
            List<String> searchNames = List.of("test", "mango");
            List<String> prizeNames = List.of("꽝", "당첨");
            Result result = new Result(searchNames);

            for (int i = 0; i < searchNames.size(); i++) {
                result.saveResult(searchNames.get(i), prizeNames.get(i));
            }

            assertThat(result.findAllResults()).isEqualTo(prizeNames);
        }
    }
}
