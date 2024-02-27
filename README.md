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

### 1️⃣ 사다리 게임에 참여할 사람들 이름 입력

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
    <li>
        <code>all</code> 이란 이름을 입력할 경우 ✔️<br>
        <code>[ERROR] 전체에 해당하는 all 은 이름으로 사용할 수 없습니다.</code>
    </li>
</ul></td>
</tr>
</table>

### 2️⃣ 실행 결과 입력

<table>
<tr>
    <th>동작</th>
    <th>예외 상황</th>
</tr>
<tr>
<td><ul>
    <li>
        질문에 해당하는 아래 메세지 출력️<br>
        <code>실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)</code>
    </li>
    <li>실행 결과를 입력받고 잘 입력 받았는지 체크</li>
</ul></td>
<td><ul>
    <li>
        구분자 <code>,</code> 로 분리 후 개수가 사람들 수와 다를 경우️<br>
        <code>[ERROR] 보상 개수가 사람의 수와 다릅니다.</code>
    </li>
</ul></td>
</tr>
</table>

### 3️⃣ 사다리 최대 높이 입력 ✔️

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

### 4️⃣ 사다리 결과 출력

<table>
<tr>
    <th>동작</th>
    <th>원리</th>
</tr>
<tr>
<td><ul>
    <li>
        사다리 결과 타이틀 메세지 출력<br>
        <code>사다리 결과</code>
    </li>
    <li>입력받은 사람수와 높이를 바탕으로 랜덤한 사다리 생성 ✔️</li>
    <li>사다리 정보를 통해 사다리 모양 결과를 출력 ✔️</li>
    <li>사다리 보상 리스트를 출력</li>
</ul></td>
<td><ul>
    <li>사다리의 가로 길이는 <code>[입력받은 사람의 수] - 1</code> 을 사용한다. ✔️</li>
    <li>사다리의 세로 길이는 입력받은 최대 높이를 사용한다. ✔️</li>
    <li>사다리는 가로를 하나의 <code>Line</code> 으로 보고 랜덤하게 발판을 생성한다. ✔️</li>
    <li><code>Line</code> 은 발판을 생성할 위치를 랜덤하게 정한다. ✔️</li>
    <li>사다리는 세로 길이만큼 <code>Line</code> 을 랜덤하게 생성한다. ✔️</li>
    <li>사다리 결과 출력 시 참여자 이름을 오른쪽 정렬한다. ✔️</li>
    <li>사다리 결과 출력 시 사다리의 기둥을 참여자 이름 마지막 문자에 위치한다. ✔️</li>
    <li>사다리 보상 출력 시 각 보상을 오른쪽 정렬한다.</li>
    <li>출력 시 사다리 한 세로 줄의 위쪽 이름과 아래쪽 보상의 최대 길이만큼 사다리 발판 길이를 늘리거나 줄인다.</li>
</ul></td>
</tr>
</table>

### 5️⃣ 결과를 보고 싶은 사람 입력

<table>
<tr>
    <th>동작</th>
    <th>원리</th>
</tr>
<tr>
<td><ul>
    <li>
        질문에 해당하는 아래 메세지 출력<br>
        <code>결과를 보고 싶은 사람은?</code>
    </li>
    <li>사람 이름을 입력받고 잘 입력 받았는지 체크</li>
</ul></td>
<td><ul>
    <li>
        보고 싶은 사람이 존재하지 않을 경우 아래 예외 메세지를 출력 후 재입력을 받는다.
        <code>[ERROR] 게임에 존재하지 않은 사람입니다.</code>
    </li>
</ul></td>
</tr>
</table>

### 6️⃣ 실행 결과 출력

<table>
<tr>
    <th>동작</th>
    <th>원리</th>
</tr>
<tr>
<td><ul>
    <li>
        실행 결과 타이틀 메세지 출력<br>
        <code>결과를 보고 싶은 사람은?</code>
    </li>
    <li>입력받은 사람 이름과 생성한 사다리 및 보상 목록을 통해 실행 결과를 생성</li>
    <li>실행 결과 출력</li>
</ul></td>
<td><ul>
    <li>보고 싶은 사람이 <code>all</code> 일 경우 모든 사람 이름과 결과를 출력한다.</li>
    <li>보고 싶은 사람이 <code>all</code> 이 아닐 경우 해당하는 사람의 결과만 출력한다.</li>
    <li>이름이 같은 사람이 여러명일 경우 보상을 <code>,</code> 로 구분하여 출력한다.</li>
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
        <td rowspan="6">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/home.svg?sanitize=true"/>
            <b> domain</b>
        </td>
        <td><b>Ladder</b></td>
        <td>세로 길이 만큼의 <code>Line</code> 리스트를 가지는 레코드</td>
    </tr>
    <tr>
        <td><b>LadderGenerator</b></td>
        <td>랜덤한 사다리를 생성해주는 클래스</td>
    </tr>
    <tr>
        <td><b>LadderHeight</b></td>
        <td>사다리의 세로를 변환하여 가지는 클래스</td>
    </tr>
    <tr>
        <td><b>Line</b></td>
        <td>사다리의 세로 길이 만큼 <code>Boolean</code> 리스트를 가지는 레코드</td>
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

## 🤔 고민했던 사항 `step1`

### 🙋‍♂️ 사람들의 이름을 구분하는 역할은 누가 수행하는가?

저는 `Domain` 의 위치에 있는 `People` 객체의 팩토리 메소드를 사용하여 `Person` 을 리스트로 만들도록 로직을 구성하였습니다.

이 때, `People.from(names)` 를 사용할 때 `names` 는 `pobi, neo, seya` 식으로 되어 있는 것을 `split` 함수를 사용하여 분리할 것입니다.

`InputView` 는 단순히 입력만 받아 전달하고 `People` 은 전달받은 문자열을 `strip` 및 `split` 을 하여 생성하는 식으로 하였는데 페어의 의견으로는 `View` 에서 `split` 하는
책임 까지 있지 않을 까 라는 의문을 제기하였습니다.

문자열을 분리하는 작업은 누구의 책임일지 궁금합니다!

> 쉼표로 구분되는건 client의 요구사항이기 때문에 배열이나 리스트로 받는게 더 낫다고 생각해요.<br/>
> 쉼표가 아닌 space나 tab으로 구분되는 요구사항으로 변경되었을때 People이 수정되어야하기 때문입니다.<br/>
> 외부에 영향을 받지 않게 일반적인 String의 배열이나 리스트를 활용하거나 People객체들을 넘겨받는식으로 생성하는건 어떨까요?<br/>
> 위에 생성자가 있긴한데 그걸 이용해볼 수도있구요.

### 🙋‍♂️ 사다리가 끊어진 경우가 발생하면 안되는가?

아래 조건에 의하여 사다리의 발판이 생성되도록 하였습니다.

1. 사다리 발판을 생성할 위치를 왼쪽부터 오른쪽까지 랜덤하게 정한다.
2. 발판을 생성할 위치에서 왼쪽 또는 오른쪽에 발판이 있을 경우 생성하지 않는다.
3. 좌우에 발판이 없을 경우 50% 확률로 발판을 생성한다.

이와 같은 로직으로 발판을 생성할 경우 중간 쯤에 한 줄 세로 전체가 발판이 생성되지 않는 경우가 생겼습니다.

이러한 현상은 특히 사다리의 가로 길이가 길 때 또는 세로 길이가 짧을 때 발생하였습니다.

게임의 공평성을 위해 끊어진 곳은 최대한 없어야 한다는 것이 좋을 것 같았고, 이러한 접근 방식이 맞는건지 궁금했습니다.

과제가 저희에게 전달한 의미가 이런 것 까지 생각하는 것이 맞는지 의문이 들었습니다!

> 이번과제에서 그 부분까지 꼭 볼필요는 없지만 생각해보면 좋은 내용인거같아요~<br/>
> 어떻게 해결하면 좋을까요?<br/>
> 정상상황으로 가정할 것인지 절대 발생하면 안되는것인지에 대한 판단을 먼저 내려야 결정할 수 있겠죠.

---

## 🤔 고민했던 사항 `step2`

### 🙋‍♂️ 아직 없음
