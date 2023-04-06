package moon.codingmate._06_mutable_data._23_change_reference_to_value;

public record TelephoneNumber(String areaCode, String number) {
    /*
    private final String areaCode;

    private final String number;

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String areaCode() {
        return areaCode;
    }

    public String number() {
        return number;
    }

    //hashCode : equals와 같이 구현해야 합니다. TelephoneNumber 인스턴스가 collection 안에 들어갈 때 특히 hashset 같은 collection에 들어갈 때 값이 같으면
    //hashcode도 같아야하고 값이 다르면 hashcode도 달라야하기 때문입니다.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneNumber that = (TelephoneNumber) o;
        return Objects.equals(areaCode, that.areaCode) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }
    */
}
