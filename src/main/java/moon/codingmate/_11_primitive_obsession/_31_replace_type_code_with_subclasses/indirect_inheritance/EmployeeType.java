package moon.codingmate._11_primitive_obsession._31_replace_type_code_with_subclasses.indirect_inheritance;

public class EmployeeType {
    public String capitalizedType() {
        // toString 호출. 다형성을 활용하기 때문에 하위 해당 인스턴스의 toString()값을 가져옵니다.
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }
}
