package moon.codingmate._08_shotgun_surgery._27_move_field;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Customer {

    private String name;

    private double discountRate;

    private CustomerContract contract;

    public Customer(String name, double discountRate) {
        this.name = name;
        // this.discountRate = discountRate;
        // 할인율이 CustomerContract와 연관이 있다면 해당 클래스로 이동
        this.contract = new CustomerContract(dateToday(), discountRate);
    }

    public double getDiscountRate() {
        return this.contract.getDiscountRate();
    }

    public void setDiscountRate(double discountRate) {
        this.contract.setDiscountRate(discountRate);
    }

    // move field만 했지만 추후에는 해당 function들을 CustomerContract로 옮기고 위임하는 것이 좋을 수도 있습니다. (move function)
    // 등급이 올라가면 3프로 더 할인
    public void becomePreferred() {
        // getter, setter로 추상화한 후 CustomerContract 클래스로 옮깁니다.
        this.setDiscountRate(this.getDiscountRate() + 0.03);
        //this.discountRate += 0.03;
        // 다른 작업들
    }

    public double applyDiscount(double amount) {
        BigDecimal value = BigDecimal.valueOf(amount);
        return value.subtract(value.multiply(BigDecimal.valueOf(this.discountRate))).doubleValue();
    }

    private LocalDate dateToday() {
        return LocalDate.now();
    }
}
