package moon.codingmate._10_data_clumps;

public class Office {

    private String location;

    private TelephoneNumber officePhoneNumber;

    public Office(String location, TelephoneNumber officePhoneNumber) {
        this.location = location;
        this.officePhoneNumber = officePhoneNumber;
    }

    public String officePhoneNumber() {
//        return officeAreCode + "-" + officeNumber;
        return this.officePhoneNumber.toString();
    }

    public String getOfficeAreCode() {
//        return officeAreCode;
        return this.officePhoneNumber.getPersonalAreaCode();
    }

    public void setOfficeAreCode(String officeAreCode) {
//        this.officeAreCode = officeAreCode;
        this.officePhoneNumber.setPersonalAreaCode(officeAreCode);
    }

    /*
    private String officeAreCode;

    private String officeNumber;

    public Office(String location, String officeAreCode, String officeNumber) {
        this.location = location;
        this.officeAreCode = officeAreCode;
        this.officeNumber = officeNumber;
    }
     */

    /*
    public String officePhoneNumber() {
        return officeAreCode + "-" + officeNumber;
    }



    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }*/
}
