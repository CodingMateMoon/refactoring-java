package moon.codingmate._18_middle_man._38_remove_middle_man;

public class Department {

    // name, number, 접근 가능 시간 등 여러 정보가 있다면 모든 정보를 Person을 거쳐서 접근할 것인지에 대해 고민이 필요합니다.
    private Person manager;

    public Department(Person manager) {
        this.manager = manager;
    }

    public Person getManager() {
        return manager;
    }
}
