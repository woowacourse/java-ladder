## Todo
~~* 사다리의 높이를 입력받는다.~~
    * [예외] 소수를 입력했을 때에 대한 익셉션 처리 해줘야 됨.

* 사다리를 만든다.
    * countOfPlayers, inputOfHeight -> Ladder 객체 저장
    * width, height 정보를 넣으면 HandleMap을 만든다.
        * width, height를 입력하면 이중리스트의 사이즈가 맞는지 확인한다.
        * Handle 생성 규칙에 맞는지 확인한다.

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