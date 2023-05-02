package moon.codingmate._19_insider_trading;

import java.time.LocalDate;

public class Ticket {

    private LocalDate purchasedDate;

    private boolean prime;

    public Ticket(LocalDate purchasedDate, boolean prime) {
        this.purchasedDate = purchasedDate;
        this.prime = prime;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public boolean isPrime() {
        return prime;
    }

    // 빨리 처리할 수 있는 FastPass 여부를 판단하기 위해 티켓 내부 정보를 많이 참조합니다. 이 메서드의 위치는 CheckIn이 아닌 Ticket이 적절하다고 판단할 수도 있습니다. CheckIn에서 부적절하게 FastPass 여부를 판단하기 위해 티켓 내부 정보를 참조하며 생긴 결합도에 대해 Ticket으로 옮기면서 CheckIn에 대한 결합도를 제거할 수 있습니다.
    public boolean isFastPass() {
        LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
        return isPrime() && getPurchasedDate().isBefore(earlyBirdDate);
    }
}
