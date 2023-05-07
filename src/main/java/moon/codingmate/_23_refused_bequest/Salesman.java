package moon.codingmate._23_refused_bequest;

// Quota 할당량은 Employee, Engineer 보다 Salesman에 특화된 메서드
public class Salesman extends Employee {

    protected Quota quota;

    protected Quota getQuota() {
        return new Quota();
    }
}

