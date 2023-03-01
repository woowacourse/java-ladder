

1. test 코드에서의 given - when - then 사용하는 것이 좋을까?


2. 테스트를 위한 프로덕션 코드 내 상수의 public 화 하는 방법에 대하여


3. 정적 팩토리 메소드(static factory method)에 대한 여러 고민들



### Test code에서의 given - when - then 사용 

---

- 리뷰어(검프)가 테스트코드에서 Given - When - Then(GWT)을 사용하는것을 한번 고려해보라는 리뷰를 남겼다.


- <u>처음에는 부정적이였다.</u>


        - 왜?

        - GWT는 가독성을 포함하여, 테스트 코드를 더 이해하기 쉽게하기 위한 목적으로 작성하는 것이다. 

        - 가독성이라는 측면이 주관적이긴 하지만, 복잡한 테스트코드라면 모를까 길어야 4~5줄 정도되는 테스트코드에 GWT을 쓴다면 오히려 읽기 어려울 것 이라고 생각했다.

        - 복잡한 테스트 코드에서는 사용할만 하지만, 특정한 테스트코드(즉, 복잡한)에서는 GWT을 작성하고, 간단한 테스트코드에서는 GWT를 작성하지 않는다면 일관성을 잃게되어 그것 또한 문제라고 여겼다.

        - white-space와 테스트 코드 상에서 길어지거나 반복되는 부분을 메소드 추출을 통해 이름을 준다면 충분히 이해하기 쉽게 테스트 코드를 작성할 수 있다고 판단했다.

- <u>하지만 결국 작성하기 마음을 바꿨다.</u>

    
        - 왜?

        - 내가 미션을 진행하면서 작성한 테스트 코드는, 모두 내가(페어 프로그래밍을 포함하여) 작성한 코드이다.

        - 즉, 난 특정한 테스트 코드에 대한 배경 지식을 알고있다(왜 작성된 테스트인지, 왜 특정 부분에서 개행을 했는지 등)

        - 하지만 내가 작성한 코드에 대한 배경 지식 없는 사람이 내 코드를 읽을때 white-space등을 통해 구분해둔 내 테스트 코드를 쉽게 이해하지 못할 수 있다.
        
        - 예를 들어보자, 영어에서 종종 관계대명사(who, which 등)를 생략한다.

        - 영어에 익숙한 사람들은 이런 관계대명사를 생략해줘도 쉽게 읽을 수 있고, 오히려 생략하는게 문장이 더 깔끔하다고 느낄 수 있다.
        
        - 하지만 영어에 익숙하지 않은 사람들은  문장이 길어지더라도, 생략하지 않고 명확하게 표기해주는 편이 더 이해하기 쉬운 경향이 있다.
        
        - 테스트 코드에서의 GWT 주석이 그렇게 느껴졌다, 이것을 직접적으로 작성해주는게 코드에 대한 배경지식이 없는 사람이 더욱 이해하기 쉬울것이다.


- 사실 영어에 대한 비유는 잘못된 비유이다.
        
    
        - 영어의 생략은 문법, 즉 규칙에 따라 이루어진다.
        
        - 하지만 내가 테스트코드에서 가독성을 좋게하기 위해 작성한 white-space, 메소드 명등은 주관적이다.(규칙을 따르지 않는다.)
    
        - 이러한 문제는 여러 사람들과 협업할 때 더 심화된다. 각 개발자들이 자신의 주관에 따라 적당히 테스트 코드의 개행을 나누고 한다면 수많은 사람들의 주관에 따른 코드를 읽어야한다.
        
        - GWT 주석을 사용한다면, 이러한 주관을 줄이고 테스트코드를 더욱 명확하게 해줄 수 있다.
        
        - 물론 GWT 주석을 사용하더라도, 주관성이 완전히 없는 것은 아니다. 어떤 부분을 given, when 등으로 나눌지 등.. 어느정도 주관적인 판단이 필요하다.
        
        - 하지만 사용하기 전에 비해서 주관성은 낮추고 보편성, 명확성을 코드에 더할 수 있는 방법이라고 판단했다.
        
        - 또한 이를 작성하는데 필요한 비용적인 측면도 거의 없다.(프로젝트 중간에 도입하는 것이 아니라 처음부터 작성했다면)


이러한 이유로 Test Code에 given - when - then 주석을 작성해주는 것이 더 좋다고 판단했다.


### 프로덕션 코드의 상수를 Public으로 열어서 테스트코드에서 할용하기

- 자동차 경주 미션에서 활용한 코드이지만, 이 부분에 대해선 이번 미션에 대해서도 스스로 고민 했고, 이에 대한 고민을 한 다른 크루들을 보아서 여기서 작성함.


- 다음은 자동차 경주 미션에서 활용한 프로덕션 및 테스트 코드이다.
---
```
//public으로 열어서 테스트코드에서 활용
public static final int MINIMUM_NUMBER_TO_MOVE = 4;

public void move(int number) {
    if (number >= MINIMUM_NUMBER_TO_MOVE) {
        position.increase();
    }
}

.....

테스트 코드
|
v
@DisplayName("최솟값을 만족시키면 position을 1 증가 시킨다.")
@Test
void success() {
    Car car = new Car(new Name("any"));

    int beforePosition = car.getPosition();
    car.move(MINIMUM_NUMBER_TO_MOVE);
    int afterPosition = car.getPosition();

    assertThat(afterPosition).isEqualTo(beforePosition+1);
}

@DisplayName("최솟값을 만족시키지 못하면 position은 변화하지 않는다.")
@Test
void fail() {
    Car car = new Car(new Name("any"));

    int beforePosition = car.getPosition();
    car.move(MINIMUM_NUMBER_TO_MOVE - 1);
    int afterPosition = car.getPosition();

    assertThat(afterPosition).isEqualTo(beforePosition);
}
}
```


프로덕션 코드의 상수를 public 하게 열어서 테스트 코드에서 활용하였다.

구체적인 이유는 다음과 같다.
- 테스트에서 경계값으로 주로 테스트 하기에 매직 넘버를 제거하고 싶었다.


- 게다가 만약 하드코딩을 했다면, 요구사항이 변경됐을때, 테스트가 깨지고 숫자를 바꾸어 주어야한다.
  (이러한 일을 없애고 싶었다.)


- 테스트를 위해 접근제어자를 변경하는 것은 옳지 못하다고 하지만, 상수는 그에 대한 side effect가 적다.


<u>결과적으로 이러한 코드에 대해서 좋지 않다고 생각했다.</u>

why?

1. 상수임에도 테스트를 위해서 접근제어자를 바꾸는 것은 옳지 않다.


2. 코드를 읽는 사람들이 왜 특정한 상수들은 접근제어자가 public인지 이해하기 어렵다.
- 요구사항이 변경되어 테스트가 깨지는 문제, 이를 변경하는데에 들어가는 리소스가 아까워서 상수를 public화 하여서 테스트코드에서 사용했다.


- 그렇지만 동료가 내 코드를 보고 왜 상수가 public 인지 이해하는데 걸리는 시간도 조직의 관점에서 똑같은 리소스이다.


- 따라서 이런 부분에서 이득을 얻기는 어렵다.


- 만약 매직 넘버를 제거하고 싶다면, 프로덕션 코드와 똑같은 상수를 테스트코드에 만들어서 활용하자 

3. 상수가 한 곳에서 관리되지 않을 수도 있다.

- 프로덕션 코드에선 활용되지 않고, 테스트 코드에서만 쓰이는 상수가 생기는 경우를 가정해보자.


- 이러한 경우에 테스트 코드에서 사용되는 일부 상수는 해당 테스트 클래스 내부에 있고, 일부 상수는 프로덕션 코드의 내부에 존재할 수 있다.


- 여러곳에서 관리가 되니 찾기도 어렵고, 코드를 읽을 때도 불편해진다.


이러한 이유로 상수를 private으로 닫아두기로 결정하였다.



### 정적 팩토리 메소드(static factory method)에 관한 고민들

---

정적 팩토리 메소드에 대해 학습한 후 미션 코드에 여러가지로 활용했다.

주로 활용한 곳은 2가지 였다.


1. 객체 생성에 대한 로직을 캡슐화하기 위해서

```
// 이런 코드보다는 ...
GameResultDto gameResultDto = new GameResultDto(player.getName, prize.getName)

// 캡슐화하여 나타내고 싶었다.
GameResultDto gameResultDto = GameResultDto.of(player, prize)
```

물론 생성자로 player와 prize를 받아서, 생성자 로직 내부에서 getter를 통해 값을 초기화 해줄 수도 있지만,
생성자에 그러한 로직이 들어가는 것은 좋지않다고 판단했다.


사람들은 일반적으로 생성자에서 인자로 주어진 값이 그대로 주입되어 멤버 변수를 초기화할 것이라고 기대하기 때문이다.


2. 객체 생성시 내부에서 특정한 로직이 수행된다는 점을 간접적으로 알려주기 위해서

위와 어느정도 이어지는 내용이다.

거기다 <u>생성자에 별도의 로직이 좋지 않다.</u> 라는 내용을 들은 후(세부적인 내용은 이해하지 못했었다.), 
어느정도 로직이 들어가면 모두 정적 팩토리 메소드를 통해 객체를 생성했다.

하지만 정적 팩토리 메소드를 활용한다고, 생성자에 로직이 들어갔을 때 생기는 문제가 모두 해결되진 않는다.

- 해결되는 문제들
  - 가독성이 개선된다.
    - 생성자에는 인자로 주어진 값을 바탕으로 값 초기화만 이루어지고, 로직은 정적 팩토리 메소드가 맡음으로써 코드가 분리되어 가독성이 개선된다.
  - 로직이 들어간다는 내용을 간접적으로 전달할 수 있다.


- 해결되지 않는 문제
  - 정적 팩토리 메소드를 이용한다고, 딱히 객체 생성에 대한 로직이 변하는 건 아니다. 이러한 로직이 너무 복잡하다면 객체 생성이 어려워진다.
    (속칭, 무거워진다, 객체 생성시 너무 많은 제약 사항이 필요하다.)
    - 이에 따라 테스트가 어려워질 수 있다.
    - 과도한 의존으로 변경에 취약할 수 있다.


다음 코드를 한번 살펴보자

```
private Ladder(List<Line> lines, LadderHeight ladderHeight) {
    this.lines = new ArrayList<>(lines);
    this.ladderHeight = ladderHeight;
}

public static Ladder create(int numberOfPeople,
                            LadderHeight ladderHeight,
                            NumberGenerator numberGenerator) {
    List<Line> lines = new ArrayList<>();
    int width = numberOfPeople - NUMBER_OF_PEOPLE_TO_WIDTH_SCALE;

    for (int i = 0; i < ladderHeight.getLadderHeight(); i++) {
        lines.add(Line.create(numberGenerator, width));
    }

    return new Ladder(lines, ladderHeight);
}
```

이 코드는 객체 생성시에 너무 많은 로직이 들어간다.

거기다가 NumberGenerator에 대한 의존으로 변화에 민감하고, 테스트 시 원하는 형태로 Ladder 객체를 생성하기 어렵다.

그래서 이 코드를 유지했을땐 테스트시 원하는 Ladder를 생성하기 위해서 Mock 객체를 활용했었다.

이렇게 객체 생성에 대해 로직이 많이 들어가고 테스트가 어려워졌다면 역할과 책임의 분리가 잘못된것 아닌가? 하는 의심을 해보는 것도 좋은 방법이다.

이 경우엔 생성을 책임지는 별도의 factory class를 만들어 Ladder를 생성하는 방향으로 리팩토링했다.




```
public class LadderGenerator {

    private static final int NUMBER_OF_PEOPLE_TO_WIDTH_SCALE = 1;

    private final LineGenerator lineGenerator;

    public LadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder generate(int numberOfPeople,
                           LadderHeight ladderHeight) {
        List<Line> lines = new ArrayList<>();
        int width = numberOfPeople - NUMBER_OF_PEOPLE_TO_WIDTH_SCALE;
        int height = ladderHeight.getLadderHeight();

        while (height-- > 0) {
            lines.add(lineGenerator.generate(width));
        }
        return new Ladder(lines);
    }
}
```

이제 Ladder는  public 생성자로 ```List<Line>```을 받아서 생성시킬 수 있고, 테스트시에 내가 원하는 형태로 만들어서 간단하게 생성할 수 있다. 

```
public Ladder(List<Line> lines) {
    this.lines = new ArrayList<>(lines);
}
```


```
@DisplayName("move()를 통해 게임 결과에 맞는 positon을 반환한다.")
@ParameterizedTest
@CsvSource(value = {"1:3", "2:1", "3:5", "4:2", "5:4"}, delimiter = ':')
void move_result_test(int startPosition, int expectedPosition) {
    // given
    Ladder ladder = new Ladder(createLine());
    Player player = new Player(new Name("hs"), new Position(startPosition));
    // when
    Position actualPosition = player.move(ladder);
    // then
    assertThat(actualPosition).isEqualTo(new Position(expectedPosition));
}

// 원하는 형태의 List<Line>을 생성할 수 있게 됐다.
private List<Line> createLine() {
    return List.of(
            new Line(List.of(PASSABLE, BLOCKED, PASSABLE, BLOCKED)),
            new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
            new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
            new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)));
}
```

이걸 깨닫고나니 리뷰어였던 검프가 해주었던 DM이 이해가 됐다.

```
생성자는 특수한 메서드인 만큼, 완전한 인자들을 제공받아야합니다. 생성자에 너무 많은 로직이 들어가게 된다면, 무거워져요.
(더 정확히는, 객체를 만들기위해 너무 많은 제약사항이 들어가게 되는거에요.)

물론 정적 팩토리 메서드를 이용하여 이 점을 해결하는 점은 좋은 해결방식이긴 합니다.

다만,  정적 팩토리 메서드를 쓰다보면, 결국 생성자를 private하게 두고싶어지고, 객체 생성의 제약사항이 정적 팩토리 메서드로 넘어가게 돼죠.
즉, 객체를 만들기 위한 방법이 2개가 있다고 가정해볼게요.
  생성자
  정적 팩토리 메서드
  
생성자에 로직을 넣지 말라는 의도는,  “생정자로 만드냐, 정적 팩토리로 만드냐“가 아닌, “해당 객체를 사용하기 위해 얼마나 많은 것들을 준비해야하냐?” 인데요. 만약 이러한 준비 과정이 다른 객체에 비해 많다면, 이는 역활과 책임이 잘못 설정되었다는 반증이기도 합니다.
이러한 책임을 조금더 넓은 관전에서 설정하다보면, 자연스럽게 정적 팩터리 메서드가 사라지게 될거에요 (단순 생성만 해주기 때문)
```
