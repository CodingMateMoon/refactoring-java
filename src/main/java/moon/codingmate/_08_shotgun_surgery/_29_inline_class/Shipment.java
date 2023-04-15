package moon.codingmate._08_shotgun_surgery._29_inline_class;

public class Shipment {

//    private TrackingInformation trackingInformation;

    private String shippingCompany;

    private String trackingNumber;

    public Shipment(String shippingCompany, String trackingNumber) {
        this.shippingCompany = shippingCompany;
        this.trackingNumber = trackingNumber;
    }

    /* Trackinginformation의 필드, 메서드를 복사해온 뒤 해당 클래스의 메서드를 사용하는 Shipment의 메서드를 전부 제거 및 변경
    public Shipment(TrackingInformation trackingInformation) {
        this.trackingInformation = trackingInformation;
    }

    public TrackingInformation getTrackingInformation() {
        return trackingInformation;
    }

    public void setTrackingInformation(TrackingInformation trackingInformation) {
        this.trackingInformation = trackingInformation;
    }
     */

    public String getTrackingInfo() {
//        return this.trackingInformation.display();
        return this.shippingCompany + ": " + this.trackingNumber;
    }

    /* inline method
    public String display() {
        return this.shippingCompany + ": " + this.trackingNumber;
    }
     */

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
