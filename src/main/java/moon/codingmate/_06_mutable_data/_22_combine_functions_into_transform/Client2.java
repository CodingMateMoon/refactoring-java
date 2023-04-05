package moon.codingmate._06_mutable_data._22_combine_functions_into_transform;

public class Client2 extends ReadingClient{

    private double base;
    private double taxableCharge;

    public Client2(Reading reading) {
//        this.base = baseRate(reading.month(), reading.year()) * reading.quantity();
        // 변환 함수를 통해 새로운 레코드를 만들고 부가적인 불변 필드를 추가함으로써 중복되는 함수, 수식들을 제거합니다.
        EnrichReading enrichReading = enrichReading(reading);
        this.base = enrichReading.baseCharge();
        // 세금 100 중 5 할인 등 공제
        //this.taxableCharge = Math.max(0, this.base - taxThreshold(reading.year()));
        this.taxableCharge = enrichReading.taxableCharge();
    }

    public double getBase() {
        return base;
    }

    public double getTaxableCharge() {
        return taxableCharge;
    }
}
