package moon.codingmate._17_message_chain._37_hide_delegate;

public class Person {

    private String name;

    private Department department;

    // 추후에 Person 클래스를 필드로 두고 getManager를 통해 가져올 경우 함수 이름을 그대로 사용할 수 있습니다
    private Person manager;

    Person getManager() {
        return this.manager;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    Person getManager_backup() {
        return getDepartment().getManager();
    }
}
