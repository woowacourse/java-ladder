# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 목록

### 입력
-[x] 참여자 이름 입력받기
  -[x] IllegalArgumentException
    -[x] 참여자 이름은 1 ~ 5자 이하이다. 
    -[x] 중복은 허용하지 않는다. 
- [x] 사다리 높이 입력받기
  - [x] 사다리 높이는 2이상의 자연수다.

### 핵심 로직

#### 사다리 생성하기
- [x] 모든 세로선 사이에 최소 한 개의 가로선을 생성하기
- [x] 가로선 랜덤으로 생성하기
- [x] 가로선 연속 라인 체크
- [x] 가로선들의 길이가 참여자수 - 1과 일치하는지 확인하기

### 사다리 게임
- [x] 사다리의 특정 시작점에서 도달할 수 있는 도착점 구하기
- [ ] 특정 참여자가 획득한 상품 확인하기

### 출력
- [x] 실행 결과 출력하기
- [x] 이름을 정책에 맞게 한 줄에 출력하기
- [x] 라인순서대로 가로선("-----") 출력하기
- [ ] 상품을 정책에 맞게 한 줄에 출력하기
- [ ] 특정 참여자가 획득한 상품 출력하기
- [ ] 모든 참여자가 획득한 상품 출력하기