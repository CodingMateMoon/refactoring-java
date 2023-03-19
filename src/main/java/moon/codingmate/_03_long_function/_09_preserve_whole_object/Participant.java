package moon.codingmate._03_long_function._09_preserve_whole_object;

import java.util.HashMap;
import java.util.Map;

// 해당 주차에 참석했는지 안했는지 homework
public record Participant(String username, Map<Integer, Boolean> homework) {
    public Participant(String username) {
        this(username, new HashMap<>());
    }

    public void setHomeworkDone(int index) {
        this.homework.put(index, true);
    }

    /* 적용할 때 고민해야할 부분은 각 함수들이 Participant를 의존하는 것이 맞는가 아니면 고치기전이었던  Hashmap을 보고있는 것이 맞는가에 대한 고민을 해야합니다.
        이 함수를 다른 도메인에도 적용할 수 있는가, 그럴 계획이 있는가. 이 함수를 다른 곳에서 적용할 경우가 있다면 Preserve whole object를 적용하지 않고 차라리 int, hashmap 등 raw 타입으로 받도록 유지할 수도 있습니다. 리팩토링 적용 후 후속으로 고민할 것은 과연 이 메소드의 위치가 적절한가에 대한 고민이 필요합니다. Rate는 참여자의 참석율을 계산하는 함수인데 totalNumberOfEvents를 제외하고는 Participant에서 해당 정보들을 다 가지고 있습니다.
         */
    public double getRate(int totalNumberOfEvents) {
        long count = homework().values().stream()
                .filter(v -> v == true)
                .count();
        return (double) (count * 100 / totalNumberOfEvents);
    }
}
