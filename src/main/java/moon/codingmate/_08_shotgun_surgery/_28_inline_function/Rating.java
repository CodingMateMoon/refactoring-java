package moon.codingmate._08_shotgun_surgery._28_inline_function;

public class Rating {

    // moreThanFiveLateDeliveries : 5회 이상 지연 시 rating 2, 아니면 1로 처리하는데 내부 구현을 봐도 충분히 의미를 파악할 수 있습니다
    public int rating(Driver driver) {
        return driver.getNumberOfLateDeliveries() > 5 ? 2 : 1;
    }

    /*
    private boolean moreThanFiveLateDeliveries(Driver driver) {
        return driver.getNumberOfLateDeliveries() > 5;
    }
     */
}
