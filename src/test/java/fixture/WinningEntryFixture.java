package fixture;

import domain.value.WinningEntry;

public class WinningEntryFixture {

    public static WinningEntry 말랑당첨() {
        return new WinningEntry("말랑당첨");
    }

    public static WinningEntry 콩떡당첨() {
        return new WinningEntry("콩떡당첨");
    }

    public static WinningEntry 바다당첨() {
        return new WinningEntry("바다당첨");
    }

    public static WinningEntry 쓰기당첨() {
        return new WinningEntry("쓰기당첨");
    }

    public static WinningEntry 꽝() {
        return new WinningEntry("꽝");
    }
}
