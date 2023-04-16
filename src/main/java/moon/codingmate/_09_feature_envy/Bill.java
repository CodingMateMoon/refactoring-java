package moon.codingmate._09_feature_envy;

public class Bill {

    private ElectricityUsage electricityUsage;

    private GasUsage gasUsage;

    public double calculateBill() {

        return electricityUsage.getElecticityBill() + gasUsage.getGasBill();
    }
    /*
    public double calculateBill() {
        // Bill 클래스가 electricityUsage, gasUsage 전기 가스 사용 계산에 대한 feature에 욕심을 내고 있습니다. Usage 클래스에서도 계산을 할 수 있기에 Move Function 옮깁니다.
        var electicityBill = electricityUsage.getAmount() * electricityUsage.getPricePerUnit();
        var gasBill = gasUsage.getAmount() * gasUsage.getPricePerUnit();
        return electicityBill + gasBill;
    }
     */

}
