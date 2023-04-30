package moon.codingmate._18_middle_man._38_remove_middle_man;

public class Person {

    private Department department;

    private String name;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    /* department에 있는 여러 필드를 사용하는 것이 필요할 경우 캡슐화했던 것을 빼내고 getDepartment().getManager()를 통해 필요한 필드를 가져오도록 변경합니다
    public Person getManager() {
        return this.department.getManager();
    }
     */

    public Department getDepartment() {
        return department;
    }
}
