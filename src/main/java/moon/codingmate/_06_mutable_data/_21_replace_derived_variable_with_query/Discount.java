package moon.codingmate._06_mutable_data._21_replace_derived_variable_with_query;

public class Discount {

//    private double discountedTotal;
    private double discount;

    private double baseTotal;

    public Discount(double baseTotal) {
        this.baseTotal = baseTotal;
    }

    // discountedTotal은 setDiscount를 통해 this.baseTotal - this.discount로 계산했을 때만 값을 가져올 수 있습니다.
    public double getDiscountedTotal() {
//        assert this.discountedTotal == this.baseTotal - this.discount;
//        assert this.discountedTotal == calculatedDiscountedTotal();
        return calculatedDiscountedTotal();
    }

    private double calculatedDiscountedTotal() {
        return this.baseTotal - this.discount;
    }

    public void setDiscount(double number) {
        this.discount = number;
        //this.discountedTotal = this.baseTotal - this.discount;
    }
}
