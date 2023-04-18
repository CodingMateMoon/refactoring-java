package moon.codingmate._11_primitive_obsession._30_repliace_primitive_with_object;

import java.util.List;

public class Priority {

    // 문자열일 경우 아무 문자열이 올 수 있고 type safety가 보장되지 않습니다.
    private String value;

    private List<String> legalValues = List.of("low", "normal", "high", "rush");

    public Priority(String value) {
        if(this.legalValues.contains(value))
            this.value = value;
        else
            throw new IllegalArgumentException("illegal value for priority " + value);

    }

    @Override
    public String toString() {
        return this.value;
    }

    private int index() {
        return this.legalValues.indexOf(this.value);
    }

    // 다른값보다 큰 지 작은지를 판단하기 위해 index로 비교합니다.
    public boolean higherThan(Priority other) {
        return this.index() > other.index();
    }
}
