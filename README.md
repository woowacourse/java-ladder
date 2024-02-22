# 🌉 우테코 레벨1 - 사다리 게임

우테코 레벨 1 사다리 게임은 게임에 참여할 사람들의 이름과 사다리의 최대 높이를 입력받아 사다리 게임을 콘솔로 출력해주는 프로그램 입니다.

1단계 요구 사항 까지는 참여할 살마들의 이름과 잘 연결된 랜덤한 사다리를 출력하는 것이 최종 목표 입니다.

---

## 🔍 목차

- ⚙️ 구현할 기능 목록
- 📋 프로젝트 구조
- 🤔 고민했던 사항

---

## ⚙️ 구현할 기능 목록

예외 상황이 생기면 `[ERROR]` 로 시작하는 메세지를 출력한 후 다시 입력을 받습니다.

### 1️⃣ 사다리 게임에 참여할 사람들 이름 입력 받기 ✔️

<table>
<tr>
    <th>동작</th>
    <th>예외 상황</th>
</tr>
<tr>
<td><ul>
    <li>
        질문에 해당하는 아래 메세지 출력 ✔️<br>
        <code>참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)</code>
    </li>
    <li>참여할 사람을 입력받고 잘 입력 받았는지 체크 ✔️</li>
</ul></td>
<td><ul>
    <li>
        입력받은 사람들 이름이 콤마(,)로 시작하거나 끝나는 경우 ✔️<br>
        <code>[ERROR] 사람들의 이름은 콤마(,)로 시작하거나 끝날 수 없습니다.</code>
    </li>
    <li>
        콤마(,)로 구분된 이름이 2개 이상이 아닐 경우 ✔️<br>
        <code>[ERROR] 사다리 게임에 참여하는 사람의 수는 2명 이상 이여야 합니다.</code>
    </li>
    <li>
        사람 이름의 길이가 5글자를 초과할 경우 ✔️<br>
        <code>[ERROR] 사람 이름의 길이는 5자를 넘을 수 없습니다.</code>
    </li>
    <li>
        콤마(,)로 구분된 이름이 비어있거나 공백일 경우 ✔️<br>
        <code>[ERROR] 사람 이름의 비어있거나 공백일 수 없습니다.</code>
    </li>
</ul></td>
</tr>
</table>

### 2️⃣ 사다리 최대 높이 입력 받기 ✔️

<table>
<tr>
    <th>동작</th>
    <th>예외 상황</th>
</tr>
<tr>
<td><ul>
    <li>
        질문에 해당하는 아래 메세지 출력 ✔️<br>
        <code>최대 사다리 높이는 몇 개인가요?</code>
    </li>
    <li>최대 사다리 높이를 입력받고 잘 입력 받았는지 체크 ✔️</li>
</ul></td>
<td><ul>
    <li>
        입력 받은 사다리의 높이가 숫자가 아닐 경우 ✔️<br>
        <code>[ERROR] 사다리의 높이는 숫자이어야 합니다.</code>
    </li>
    <li>
        사다리의 높이가 1 보다 작을 경우 ✔️<br>
        <code>[ERROR] 사다리의 높이는 1 이상의 정수이어야 합니다.</code>
    </li>
</ul></td>
</tr>
</table>

### 3️⃣ 실행결과 출력 ✔️

<table>
<tr>
    <th>동작</th>
    <th>원리</th>
</tr>
<tr>
<td><ul>
    <li>
        실행결과 타이틀 메세지 출력 ✔️<br>
        <code>실행결과</code>
    </li>
    <li>입력받은 사람수와 높이를 바탕으로 랜덤함 사다리 생성 ✔️</li>
    <li>뷰는 사다리 정보를 통해 사다리 모양 결과를 출력 ✔️</li>
</ul></td>
<td><ul>
    <li>사다리의 가로 길이는 <code>[입력받은 사람의 수] - 1</code> 을 사용한다.</li>
    <li>사다리의 세로 길이는 입력받은 최대 높이를 사용한다.</li>
    <li>사다리는 가로를 하나의 <code>Line</code> 으로 보고 랜덤하게 발판을 생성한다.</li>
    <li><code>Line</code> 은 발판을 생성할 위치를 랜덤하게 정한다.</li>
    <li>사다리는 세로 길이만큼 `Line` 을 랜덤하게 생성한다.</li>
    <li>실행결과 출력 시 참여자 이름을 오른쪽 정렬한다.</li>
    <li>실행결과 출력 시 사다리의 기둥을 참여자 이름 마지막 문자에 위치한다.</li>
</ul></td>
</tr>
</table>

---

## 📋 프로젝트 구조

### 📦 패키지

<table>
    <tr>
        <th>Package</th>
        <th>Class</th>
        <th>Description</th>
    </tr>
    <tr>
        <td rowspan="1">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/constants.svg?sanitize=true"/>
            <b> constant</b>
        </td>
        <td><b>ErrorMessage</b></td>
        <td>예외 상황에 사용 되는 정적 메세지</td>
    </tr>
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/controllers.svg?sanitize=true"/>
            <b> controller</b>
        </td>
        <td><b>LadderController</b></td>
        <td>입력을 받아 계산하고 출력 해주는 전체 진행 담당 컨트롤러</td>
    </tr>
    <tr>
        <td rowspan="5">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/home.svg?sanitize=true"/>
            <b> domain</b>
        </td>
        <td><b>Ladder</b></td>
        <td>세로 길이 만큼의 <code>Line</code> 리스트를 가지는 클래스</td>
    </tr>
    <tr>
        <td><b>LadderHeight</b></td>
        <td>사다리의 세로를 변환하여 가지는 클래스</td>
    </tr>
    <tr>
        <td><b>Line</b></td>
        <td>사다리의 세로 길이 만큼 <code>Boolean</code> 리스트를 가지는 클래스</td>
    </tr>
    <tr>
        <td><b>People</b></td>
        <td>사람들 이름을 변환하여 <code>Person</code> 리스트를 가지는 클래스</td>
    </tr>
    <tr>
        <td><b>Person</b></td>
        <td>사람 이름을 문자열로 가지는 클래스</td>
    </tr>
    <tr>
        <td rowspan="2">
            <b> util</b>
        </td>
        <td><b>ExceptionRetryHandler</b></td>
        <td>예외 발생 시 재실행을 해주는 정적 클래스</td>
    </tr>
    <tr>
        <td><b>RandomLinesGenerator</b></td>
        <td>랜덤한 사다리를 생성해주는 정적 클래스</td>
    </tr>
    <tr>
        <td rowspan="2">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/views.svg?sanitize=true"/>
            <b> view</b>
        </td>
        <td><b>InputView</b></td>
        <td>사용자에게 질문을 하고 입력을 받아주는 뷰</td>
    </tr>
    <tr>
        <td><b>OutputView</b></td>
        <td>사용자에게 일반적인 메세지와 결과 및 에외 메세지를 출력해주는 뷰</td>
    </tr>
</table>

---

## 🤔 고민했던 사항

### 🙋‍♂️ 사람들의 이름을 구분하는 역할은 누가 수행하는가?

저는 `Domain` 의 위치에 있는 `People` 객체의 팩토리 메소드를 사용하여 `Person` 을 리스트로 만들도록 로직을 구성하였습니다.

이 때, `People.from(names)` 를 사용할 때 `names` 는 `pobi, neo, seya` 식으로 되어 있는 것을 `split` 함수를 사용하여 분리할 것입니다.

`InputView` 는 단순히 입력만 받아 전달하고 `People` 은 전달받은 문자열을 `strip` 및 `split` 을 하여 생성하는 식으로 하였는데 페어의 의견으로는 `View` 에서 `split` 하는
책임 까지 있지 않을 까 라는 의문을 제기하였습니다.

문자열을 분리하는 작업은 누구의 책임일지 궁금합니다!

### 🙋‍♂️ 사다리가 끊어진 경우가 발생하면 안되는가?

아래 조건에 의하여 사다리의 발판이 생성되도록 하였습니다.

1. 사다리 발판을 생성할 위치를 왼쪽부터 오른쪽까지 랜덤하게 정한다.
2. 발판을 생성할 위치에서 왼쪽 또는 오른쪽에 발판이 있을 경우 생성하지 않는다.
3. 좌우에 발판이 없을 경우 50% 확률로 발판을 생성한다.

이와 같은 로직으로 발판을 생성할 경우 중간 쯤에 한 줄 세로 전체가 발판이 생성되지 않는 경우가 생겼습니다.

이러한 현상은 특히 사다리의 가로 길이가 길 때 또는 세로 길이가 짧을 때 발생하였습니다.

게임의 공평성을 위해 끊어진 곳은 최대한 없어야 한다는 것이 좋을 것 같았고, 이러한 접근 방식이 맞는건지 궁금했습니다.

과제가 저희에게 전달한 의미가 이런 것 까지 생각하는 것이 맞는지 의문이 들었습니다!
