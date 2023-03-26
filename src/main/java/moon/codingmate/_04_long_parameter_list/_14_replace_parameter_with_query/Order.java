package moon.codingmate._04_long_parameter_list._14_replace_parameter_with_query;

public class Order {

    private int quantity;

    private double itemPrice;

    public Order(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double finalPrice() {
        double basePrice = this.quantity * this.itemPrice;
        /* 최종 가격은 할인율을 통해서 알아내야 하는데 할인율은 수량에 따라 달라집니다. 100개 이상이면 2등급 아니면 1등급
         2등급이면 10프로 1등급이면 5프로 할인. 수량을 통해 discountlevel을 알 수 있고 basePrice, discountlevel을 통해 discountedPrice를 알 수 있습니다.
        discountLevel 계산이 호출하는 쪽 책임이었는데 함수 자체의 책임으로 변경해서 전달해야할 파라미터를 줄입니다.
        int discountLevel = discountLevel();
         */
        return this.discountedPrice(basePrice);
    }

    private int discountLevel() {
        return this.quantity > 100 ? 2 : 1;
    }

    private double discountedPrice(double basePrice) {
        return discountLevel() == 2 ? basePrice * 0.90 : basePrice * 0.95;
    }
}
