## 생각의 흐름을 정리해본다

HorizontalLine 의 메소드를 정리해 보았다
더럽다..

미래에서 왔기 때문에 다리 긋는 위치와 사다리를 타는 위치를 함께 다루는게 쉽지 않음을 알고 있다 (해보고 실패를 통한 깨달음??)

최소한 하나의 기준으로 맞춰야 함을 알고 있다

그래서 사다리의 세로선의 위치를 기준으로 생각하려고 한다 (즉 bar를 그리는 위치를 생각하지 않기로, 따라서 bar를 그릴때 왼쪽 선의 위치에 그리기로 한다)


위치를 기준으로 잡으니.. 가로선을 그었는지를 확인하기 위해 Direction을 사용하게 된다 (해당 위치에서 왼쪽, 오른쪽으로 갈지를 정하는?)
// 두 좌표가 존재할 때 다른 좌표가 왜 필요한지를 고민하다보면.. 이렇게 한 좌표만을 사용할 방법을 찾게 되지 않을까?

### 직접 그릴 수 있는 사다리

#### Position
먼저 위치의 범위를 제한하기 위한 일급 컬렉션을 구현해본다 

#### Direction
이제 Position 을 옮겨주기 위한 처리와 정보가 담긴 Direction 을 만든다

#### HorizontalLine
이제 사다리의 가로선을 구현해본다
- 주어진 위치에선 어디로 이동할지
- 주어진 위치에 그릴 수 있는지
- 주어진 위치에 그어보기

#### Ladder
사다리

### 사다리를 사용해서 그려보자..!
사다리를 그려봐야 코드를 짜면서 돌려보는 재미가 있을 듯 해서리
(일단 그리는 로직을 고민해보고 이참에 사다리를 그리는 아웃풋도 만들어주자)


----------
## 피트백 관련 정리
- List<Player>, List<Reward> 을 일급 콜렉션으로
    - 이는 List<Player>를 특정 클래스로 감싸면 나중에 List가 아닌 무언가로 변경시에 한 곳만 변경하면 되기에?
- 사다리 출력
    - 이 부분은 전에 view 관련 피드백이 생각나서 이렇게 구현했었습니다. (String이 아닌, 예를들어 사진, 것으로 사다리를 그려주고 싶으면.. 결국 view에 그려 주기 위한 정보가 있어야 하지 않냐는 것이었구요)
    - 사실 지금 문제 상황에서는 toString으로 표현하는 것도 의미가 있다고 생각되네요.
- 상수
    - 0 같은 값도 상수 처리하는게 맞음. (내가 보면 명확하지만 남이 보면 아닐 수 있음)
- 복잡한 사다리 클래스
    - Ladder의 역할을 그릴 수 있는 사다리 (그냥 친구들이랑 빈 세로 줄에다가 원하는 사다리 긋는)로 생각하고 역할을 주었습니다. (먼가.. 제 요구사항?을 위한 객체지요 ㅠㅋㅋㅋ)
    - 말씀하신 사다리는 생성시에 이미 그려진 사다리일까요? (ex. 수업 때 pobi가 예를 들어주신 랜덤으로 생성되는 라인)

- 필요 이상으로 추출된 객체들 (정말로 필요한 객체들을 이용, 해야할 역할들을 정확히 나누는)
    - 일단 역할들을 막 뽑아내고는 있는데.. 관련된 역할들을 특정 객체로 잘 묶어주는? 부분이 아직도 어려운 것 같습니다.
    - 이 부분은 제가 다시 구현하기 전에 .. 사용할 클래스와 역할을 정리해서 한번 보내드려도 좋을까요? 

## 질문있습니다
- 그릴 수 있는 사다리(현재의 Ladder)로 할 경우에는 어떻게 역할을 나누는게 좋을까요?
    - 현재 코드는.. 그래서 Ladder를 사용하는 LadderDrawer, LadderGame이 존재하고 있습니다.
    - 저는 일단은 '그릴 수 있는 사다리'라는 요구사항에서 좀 더 간결하게 하려면 Position을 잘 쓰는 방향으로 고민이 되서요.
    - (coordinate 도 그렇고.. <code>List</code> 처럼 내부적으로 int를 사용하는데(list.get, list.set 등) <code>Point(Number r, Number r)</code> 이런 식으로 감싸진 값들을 모아서 쓸 경우 넣었다가 빼는 작업 자체가 많아지는 것 같아요.. <code>point.getR().getInt()</code> 이런 식으로요 -> 다른 접근 방법이 있을까요??)

- 말씀해주신 복잡하다는 건 객체의 관계가 복잡하다는 걸까요?? (제가 주석으로 달았던 부분은 .. 포지션을 어렵게 써서 복잡했다고 달았던 것 같아서요. // 물론 객체관계도 복잡합니다)    
<pre><code> 
IntStream.range(0, numTrial).forEach((i) -> {
    Position row = randomRow;       // 기존: Position row = rowPositionGenerator.generate();
    Position column = randomColumn; // 기존: Position column = firstColumnPosition.plus(columnPositionGenerator.generate().toInt());

    if (ladder.canDraw(row, column)) {
        ladder.draw(row, column);
     }
});
</pre></code>
    
    
- 말씀해주신 방향으로도 역할을 쪼개보는 연습을 해보겠습니다.
    > Ladder, HorizontalLine, Direction이 세 클래스로도 충분히 사다리를 놓을 수 있는지 없는지, 움직일 수 없는지 등에 대해 구현할 수 있어요!
    



## 역할 정리
- Direction
- HorizontalLine
- Ladder
- Position
- LadderDrawer
- LadderGame
- Navigator
- Player
- Reward

