package moon.codingmate._07_divergent_change._26_extract_class;

public class Person {

    //private final TelephoneNumber telephoneNumber = new TelephoneNumber();
    private final TelephoneNumber telephoneNumber;
    private String name;

    public Person(TelephoneNumber telephoneNumber, String name) {
        this.telephoneNumber = telephoneNumber;
        this.name = name;
    }

    public String telephoneNumber() {
        return this.telephoneNumber.toString();
    }

    public String name() {
        return name;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }

    /*
    TelephoneNumber를 받고 Person이 계속 전화번호를 바꾸는 일을 가질 수도 있습니다.
    public void setName(String name) { this.name = name;
    }

    public String officeAreaCode() {
        return telephoneNumber.officeAreaCode();
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        telephoneNumber.setOfficeAreaCode(officeAreaCode);
    }

    public String officeNumber() {
        return telephoneNumber.officeNumber();
    }

    public void setOfficeNumber(String officeNumber) {
        telephoneNumber.setOfficeNumber(officeNumber);
    }
     */
}
