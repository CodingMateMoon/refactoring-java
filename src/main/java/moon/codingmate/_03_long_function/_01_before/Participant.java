package moon.codingmate._03_long_function._01_before;

import java.util.HashMap;
import java.util.Map;

// 해당 주차에 참석했는지 안했는지 homework
public record Participant(String username, Map<Integer, Boolean> homework) {
    public Participant(String username) {
        this(username, new HashMap<>());
    }

    public double getRate(double total) {
        long count = this.homework.values().stream()
                .filter(v -> v == true)
                .count();
        return count * 100 / total;
    }

    public void setHomeworkDone(int index) {
        this.homework.put(index, true);
    }

}
