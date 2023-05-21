package moon.codingmate;

public class GuardClauses {

    public int getPoints(){
        // if문에서 동등하게 균형이 있는 경우. true : 50, false : 50 일때는 상관없지만 메인 케이스가 있고 특수 케이스가 있는 경우 if else로 균형잡는게 적절하지 않을 수 있습니다. 한쪽을 강조해야하는 경우도 있습니다. 그런 경우 보호구문 기법을 사용할 수 있습니다. normalPoint가 메인 케이스이고 vipPoint, platPoint가 특수한 경우라면 중첩 조건문을 보호 구문으로 바꾸기(Replace Nested Condition with Guard Clauses)를 적용할 수 있습니다.
        if (isVip()) return vipPoint();
        if (isPlat()) return platPoint();
        return normalPoint();
        /*
        int result;
        if (isVip()) {
            return  vipPoint();
        } else if (isPlat()) {
            result = platPoint();
        } else {
            result = normalPoint();
        }
        return result;

         */
    }

    private int platPoint() {
        return 0;
    }

    private boolean isPlat() {
        return false;
    }

    private int vipPoint() {
        return 0;
    }


    private boolean isVip() {
        return true;
    }

    private int normalPoint() {
        return 0;
    }
}
