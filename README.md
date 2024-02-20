# java-ladder

사다리 타기 미션 저장소

## 명칭 정의
1. 사다리의 `|`으로 이루어진 세로 한 줄 - 세로라인
2. 사다리의 `-`으로 이루어진 가로 한 줄 - 가로라인
3. 사다리의 `|-----|`으로 이루어진 가로 한 줄 - 층

## 기능 요구사항
1. - [ ] 참여할 사람의 이름을 입력받는다.
     - [ ] 사람 이름은 쉼표로 구분한다.
     - [x] 사람 이름은 1자 이상 5자 이하여야 한다.
     - [x] 사람 이름은 공백으로만 이루어질 수 없다.
     - [x] 사람 이름은 중복을 허용하지 않는다.
     - [x] 사람은 2명 이상 50명 이하여야 한다.
2. - [ ] 최대 사다리 높이를 입력받는다.
      - [ ] 사다리 높이는 1개 이상 100개 이하의 정수여야 한다.
3. - [ ] 사다리를 생성한다.
      - [x] 사다리 가로라인은 `|-----|-----|`와 같이 연속할 수 없다.
4. - [ ] 실행 결과를 출력한다.
      - [ ] 사람 이름은 `"%5s "`으로 출력한다.
      - [ ] 가로라인은 `-` 5개로 표현한다.
      - [ ] 세로라인은 사다리 높이만큼 `|` 개수로 표현한다.
   
## 기능 구현사항
- 사람
   - 이름 => 포장
- 참가자들
   - 사람 묶음
   - 분리해서 개수 검증
   - 이름 중복 검증
- 이름
  - 이름 길이 검증
  - 이름 공백 검증
- 라인
   - 층 어디에 가로라인이 있는지 정보 저장
   - 생성자
   - 만들기
      - 비교해
      - 비교해서 없으면 랜덤값 돌려
      - 1이면 가로 있음, 0이면 가로 없음
   - 해당 위치 가로라인 있는지 불리안 답변
- 사다리
   - 높이 => 포장
   - 전체 라인의 정보 저장
   - 생성자에서 사람 수와 높이 파라미터로 받기
   - 사다리 생성
      - 층별로 생성해서 쌓기
- 높이
   - 높이 값 검증
- InputView
   - 이름 입력 받기
      - `,`로 끝나지 않는지 검증
   - 최대 사다리 높이 입력 받기
      - 정수 여부 검증

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
