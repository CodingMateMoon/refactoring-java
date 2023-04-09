package moon.codingmate._07_divergent_change._25_move_function;

public class AccountType {
    private boolean premium;

    public AccountType(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return this.premium;
    }

    // 납기일이 지나면 추가요금
    /*
    overdraftCharge 메서드를 AccountType으로 이동시킬 때 Account를 받을 경우 AccountType은 Account에 대한 의존성이 생기기 때문에 Account가 아닌 Account 내 daysOverdrawn을 받는식으로 바꿉니다.
     */
    double overdraftCharge(int daysOverdrawn) {
        if (this.isPremium()) {
            final int baseCharge = 10;
            if (daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                // 일주일이 지나면 지난 일수만큼 추가 요금
                return baseCharge + (daysOverdrawn - 7) * 0.85;
            }
        } else {
            return daysOverdrawn * 1.75;
        }
    }
}
