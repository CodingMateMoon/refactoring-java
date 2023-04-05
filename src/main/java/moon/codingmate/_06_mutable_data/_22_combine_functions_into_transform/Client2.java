package moon.codingmate._06_mutable_data._22_combine_functions_into_transform;

public class Client2 extends ReadingClient{

    private double base;
    private double taxableCharge;

    public Client2(Reading reading) {
        this.base = baseRate(reading.month(), reading.year()) * reading.quantity();
        // 세금 100 중 5 할인 등 공제
        this.taxableCharge = Math.max(0, this.base - taxThreshold(reading.year()));
    }

    public double getBase() {
        return base;
    }

    public double getTaxableCharge() {
        return taxableCharge;
    }

}
