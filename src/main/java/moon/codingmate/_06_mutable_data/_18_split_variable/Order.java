package moon.codingmate._06_mutable_data._18_split_variable;

public class Order {

    // 처음 전달된 값, 계산해서 만든 최종 discount 값
    public double discount(double inputValue, int quantity) {
        double result = inputValue;
        // if (inputValue > 50) inputValue = inputValue - 2;
        if (inputValue > 50) result -= 2;
        //if (quantity > 100) inputValue = inputValue - 1;
        if (quantity > 100) result -= 1;
        return result;
    }
}
