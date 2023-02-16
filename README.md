# java-ladder

사다리 타기 미션 저장소

## 기능 정의

- Height
  - 기능
    - [x] 사다리를 모두 생성했는지 여부 확인
  - 예외 처리
    - [x] 사다리의 높이가 1 미만인 경우
- Name
  - 기능
    - [x] 이름 조회 
  - 예외 처리
    - [x] 이름의 길이가 1 ~ 5가 아닌 경우
    - [x] 이름이 공백인 경우
- Names
  - 기능
    - [x] Name 컬렉션 조회
    - [x] 특정 순서의 참여자 조회 
    - [x] 참여자 인원 수 조회
  - 예외 처리
    - [x] 참여자의 인원 수가 2명 미만인 경우
- Path
  - 기능
    - [x] 첫 번째 사다리 경로 생성
    - [x] 두 번째 이후의 사다리 경로 생성
    - [x] 사다리 로그 조회
- Line
  - 기능
    - [x] Path 컬렉션 조회
- Ladder
  - 기능
    - [x] Line 컬렉션 조회
- LadderMaker
  - 기능
    - [x] 참여자 등록
    - [x] 참여자 조회
    - [x] 사다리 생성
    - [x] 사다리 조회

## 입력 정의

- [x] 참여자 이름 입력
  - 예외 처리
    - [x] 한글을 입력한 경우
    - [x] 유효한 구분자가 포함되지 않은 경우
- [x] 사다리 높이 입력
  - 예외 처리
    - [x] 입력이 숫자가 아닌 경우

- 공통 예외 처리
  - [x] 공백을 입력했을 경우

## 출력 정의

- [x] 생성된 사다리 출력