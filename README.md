# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구 사항 정리

- 사다리 게임에 참여하는 사람에 이름을 최대 5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

### Domain

#### Player, Players

- 검증 : 사다리 게임에 참여하는 사람에 이름을 최대 5글자까지 부여할 수 있다.
- 검증 : 사다리 게임에 참여하는 사람에 이름은 적어도 1글자 이상이어야 한다.
- [x] 검증 : 사람은 적어도 2명 이상 있어야 한다.
- [x] 검증 : 참여하는 사람의 이름은 중복되어서는 안된다.

#### Product, Products

- [x] 검증 : 상품는 최대 5글자까지 부여할 수 있다.
- [x] 검증 : 상품 이름은 1글자 이상 있어야 한다.
- [x] 검증 : 상품은 적어도 2개 이상 있어야 한다.

#### Line

- 라인 객체 생성
    - 검증 : 사람 수에 맞추어 생성 됐는지 검증
    - 검증 : 가로 라인이 겹치지 않는지 검증
- 특정 위치에 가로 라인이 있는지 확인
- [ ] 중간 결과를 받아 해당 라인을 지났을 때 결과를 반환

#### LinePatternGenerator

- 0 ~ 1 중 랜덤 넘버를 생성한다.
    - 1이 나오면 사다리를 생성하지 않는다.
    - 0이 나오면 사다리를 생성한다.
- 마주하는 선이 있다면 생성하지 않는다.
    - 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.

#### Height

- 검증 : 사다리의 높이가 양의 정수 인지 검증

#### Ladder

- 특정 위치에 가로 라인이 존재 하는지 확인
- [ ] 사다리 게임의 결과를 반환
  - [ ] 검증 : 참가자와 결과들의 갯수가 사다리의 크기와 일치해야 함

#### LadderGameResult

- [ ] 주어진 이름에 해당하는 결과를 반환
- [ ] 전체 결과를 반환

### View

#### InputView

- 사람 이름 입력
    - 사람 이름은 쉼표(,)를 기준으로 구분한다.
- [ ] 실행 결과 입력
    - 실행 결과는 쉼표(,)를 기준으로 구분한다.
- 최대 사다리 높이 갯수 입력
- [ ] 결과를 보고 싶은 사람 입력

#### OutputView

- 사다리 출력
    - 이름 출력 : 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - 사다리 형태 출력 : 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- [ ] 단일 실행 결과 출력
- [ ] 모든 실행 결과 출력
    - 이름과 결과를 ` : ` 의 앞뒤로 연결하여 작성한다.

### 실행 결과 (참고)

```text
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

실행결과

 pobi honux crong    jk 
    |-----|     |-----|
    |-----|     |-----|
    |     |     |     |
    |     |     |-----|
    |     |     |-----|
 꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 5000
crong : 꽝
jk : 3000
```
