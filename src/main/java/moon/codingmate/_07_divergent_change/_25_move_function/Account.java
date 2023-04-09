package moon.codingmate._07_divergent_change._25_move_function;

public class Account {

    private int daysOverdrawn;

    private AccountType type;

    public Account(int daysOverdrawn, AccountType type) {
        this.daysOverdrawn = daysOverdrawn;
        this.type = type;
    }

    public double getBankCharge() {
        double result = 4.5;
        if (this.daysOverdrawn() > 0) {
            // 나중에 overdraftCharge에서 daysOverdrawn뿐만 아니라 Account에 있는 많은 데이터를 참조해야 한다면 다시 Account로 가져오는 것이 나을 수 있습니다.
            result += this.type.overdraftCharge(this.daysOverdrawn);
        }
        return result;
    }

    private int daysOverdrawn() {
        return this.daysOverdrawn;
    }

    /* AccountType으로 Move Instance Method. 응집도를 높이고 결합도를 낮추며 뒤엉킨 변경(Divergent Change)을 낮출 수 있습니다.
    private double overdraftCharge() {
        if (this.type.isPremium()) {
            final int baseCharge = 10;
            if (this.daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (this.daysOverdrawn - 7) * 0.85;
            }
        } else {
            return this.daysOverdrawn * 1.75;
        }
    }
     */
}
