## Todo
~~* 사다리의 높이를 입력받는다.~~
    * [예외] 소수를 입력했을 때에 대한 익셉션 처리 해줘야 됨.


* 게임 결과를 도출한다.
    * 누구를 보고싶은지 묻기
        * "pobi" -> "pobi: 1000billion"
        * "all" -> "kjm: 100000billion dollars, pyj: 꽝"
        * [예외] 존재하지 않는 사용자 이름을 입력했을 때
* 결과를 보고 싶은 사람(all 포함)


---
## Done
* 이름 입력값을 넣으면 이름 배열이 나온다.
    * "a,b,c" -> ["a", "b", "c"]
    * "" -> Exception!
    * "a,a,b" -> Exception!
    * null -> Exception!
    * "abcdef,g" -> Exception!

* 플레이어 이름 입력값을 넣으면 플레이어 리스트가 반환된다.
    * "a,b,c" -> [new Player("a"), new Player("b"), new Player("c")]

* 사다리를 만든다.
    * countOfPlayers, inputOfHeight -> Ladder 객체 저장
    * width, height 정보를 넣으면 HandleMap을 만든다.
        * width, height를 입력하면 이중리스트의 사이즈가 맞는지 확인한다.
        * Handle 생성 규칙에 맞는지 확인한다.

* 실행 결과를 입력받는다.
    * 실행 결과가 플레이어 수와 맞아야 한다.

* 플레이어를 사다리에 태운다.
    * height만큼 반복
        * 사다리 리스트에 플레이어를 비교해서 스위치...