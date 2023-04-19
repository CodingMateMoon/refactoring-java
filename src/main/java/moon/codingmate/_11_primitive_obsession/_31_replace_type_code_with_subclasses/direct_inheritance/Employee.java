package moon.codingmate._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

/*
타입 코드를 서브클래스로 바꾸기(Replace Type Code with Subclasses) : validate에서 문자열 리스트로 유효성 검사를 하고 필드 type값을 반환하는 방식에서 type에 맞게 서브클래스를 생성하고 abstract Employee 클래스의 getType()을 overide한 함수로 type값을 반환하는 방식으로 변경
 */
public abstract class Employee {

    private String name;

//    private String type;

//    protected Employee(String name, String type) {
    protected Employee(String name) {
        this.name = name;
//        this.validate(type);
//        this.type = type;
    }

    public static Employee createEmployee(String name, String type) {
        return switch (type) {
            case "engineer" -> new Engineer(name);
            case "manager" -> new Manager(name);
            case "salesman" -> new Salesman(name);
            default -> throw new IllegalArgumentException(type);
        };

    }

    protected abstract String getType();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }

    /*
    private void validate(String type) {
        List<String> legalTypes = List.of("engineer", "manager", "salesman");
        if (!legalTypes.contains(type)) {
            throw new IllegalArgumentException(type);
        }
    }
     */


}
