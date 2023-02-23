# java-ladder

사다리 타기 미션 저장소

## 2단계 요구사항
- [x] 실행 결과 입력 받기 (, 로 구분)
- [x] 사다리 건너기
  - [x] 왼쪽 오른쪽 확인
  - [x] true 면 index 이동
- [ ] 결과 보고 싶은 사람 입력 시 결과 출력
- [ ] all 입력 시 전체 결과 출력
- [x] Player class 추가
  - [x] Players 는 List<Player> 를 상태로 가지도록 리팩토링

## 예외 처리
- [x] 실행 결과 입력
  - [x] null check
  - [x] 목록 중에 공백이 있을 때
  - [x] 실행 결과 개수가 사람 수와 같지 않을 때
  - [x] "꽝' 이나 양의 정수가 아닐 때
- [ ] 결과 보고 싶은 사람 이름
  - [x] 게임 유저가 아닐 때
  - [x] all 이 아닐 때
  - [x] null check

## 1단계 피드백 반영
- [x] 사용자 이름, 사다리 높이 입력 예외처리 분리
  - [x] 잘못된 입력 시 재입력
  - [ ] 재입력 시 재귀 호출 말고 다른 방법 찾기
- [x] controller 의 generateLadder -> Ladder 생성자로 Ladder 만들기
- [x] enum Way 필요성 확인
  - [x] 사다리 표현 문자 "-" , " " 를 enum 으로 묶기
- [x] correctOverlapPoints 개선
- [x] 정규식 패턴 상수화 -> 정규식 패턴 사용 X
- [x] Validator 클래스 -> validate 메소드 생성
  - [x] player validate 해주는 메소드들을 해당 메소드 안에서 호출
  - [x] Integer.parseInt 로 예외 처리 되는 validate 메소드들은 삭제
  - [x] Validator 클래스 삭제. Height 와 Players 생성자에서 validate 검증
- [x] input view 에서 입력 요청 출력을 Controller 로 위임
- [x] Output view -> 사용자 이름 길이에 맞게 수정되게 하는 로직 변수 선언
- [x] parameterized test 사용. 테스트 추가
- [x] Height 만큼 반복문 돌리기
  - [ ] getter 사용 or Height 에 메세지 보내기
- [x] 하나의 step 도 연결 안된 bar 가 있는 ladder validate check
- [ ] 반복문 최대한 적게 사용하기. while 보단 for 문 이용
- [ ] indent depth 1 이하

## 기능 목록

- [x] 사용자 입력(사람 이름은 쉼표(,)를 기준으로 구분)
- [x] 사다리 높이 입력
- [x] 랜덤 값(0,1) 생성 기능
- [x] 사다리 라인 생성
  - [x] 이전 좌표와 겹치는지 판단
- [x] 입력받은 이름 글자 수 최대의 따라 사다리 폭 결정
- [x] 플레이어 이름의 길이의 따라 사다리 폭 변화 후 출력
  - [x] 플레이어 중 이름의 최대길이 구하기 기능
  - [x] 사다리 좌표값 enum 생성



## 예외 처리
- [x] 사용자 이름 글자 수가 0이하 이거나 5를 초과했을때.
- [x] 사용자 이름을 입력하지 않았을때.
- [x] 사용자 이름이 중복일때.
- [x] 입력된 사다리 높이가 숫자가 아닐때.
- [x] 입력된 사다리 높이가 1이상인 정수가 아닐때.



## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
