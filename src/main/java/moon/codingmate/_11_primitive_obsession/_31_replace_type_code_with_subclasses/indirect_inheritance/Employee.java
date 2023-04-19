package moon.codingmate._11_primitive_obsession._31_replace_type_code_with_subclasses.indirect_inheritance;

/*
타입 코드를 서브클래스로 바꾸기(Replace Type Code with Subclasses) :
String->EmployeeType으로 변환. 필드 String type으로 capitalizedType을 호출하는 방식에서 EmployeeType의 capitalizedType()을 호출하는 방식으로 변경
 */
public class Employee {

    private String name;

//    private String typeValue;

    // 간접적으로 상속 활용. primitive 타입을 서브 클래스 EmployeeType로 변환
    private EmployeeType type;

    public Employee(String name, String typeValue) {
//        this.validate(typeValue);
        this.name = name;
//        this.typeValue = typeValue;
        this.type = this.employeeType(typeValue);
    }

    private EmployeeType employeeType(String typeValue) {
        return switch (typeValue) {
            case "engineer" -> new Engineer();
            case "manager" -> new Manager();
            case "salesman" -> new Salesman();
            default -> throw new IllegalArgumentException(typeValue);
        };
    }

    public String capitalizedType() {
        return this.type.capitalizedType();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type='" + type.toString() + '\'' +
                '}';
    }
}
