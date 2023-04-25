package moon.codingmate._15_speculative_generality._35_remove_dead_code;

import java.time.LocalDateTime;

/* 죽은 코드 제거하기(Remove Dead Code) : usage를 본 뒤 테스트코드에서만 참조하고 있는 것을 확인하고 불필요한 코드 제거
Settings-Editor-Inlay Hints-Java-Code vision-Show hints for: Usages 체크
 */
public class Reservation {

    private String title;

    private LocalDateTime from;

    private LocalDateTime to;

    private LocalDateTime alarm;

    public Reservation(String title, LocalDateTime from, LocalDateTime to) {
        this.title = title;
        this.from = from;
        this.to = to;
    }
    public void setAlarmBefore(int minutes) {
        this.alarm = this.from.minusMinutes(minutes);
    }

    public LocalDateTime getAlarm() {
        return alarm;
    }
}
