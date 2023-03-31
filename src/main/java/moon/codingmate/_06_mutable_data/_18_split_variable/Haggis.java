package moon.codingmate._06_mutable_data._18_split_variable;

public class Haggis {

    private double primaryForce;
    private double secondaryForce;
    private double mass;
    private int delay;

    /*
    초기 가속도가 있고 일정 시간이 지난후 두번째 가속을 합니다. 첫번째 추진력, 두번째 추진력, 질량은 동일
  */
    public Haggis(double primaryForce, double secondaryForce, double mass, int delay) {
        this.primaryForce = primaryForce;
        this.secondaryForce = secondaryForce;
        this.mass = mass;
        this.delay = delay;
    }

    // time : 총 이동 시간
    public double distanceTravelled(int time) {
        double result;
        // 추진력 / 질량 : 가속도 계산
        // double acc = primaryForce / mass;
        final double primaryAcceleration = primaryForce / mass;
        // 첫 추진력으로 이동한 시간
        int primaryTime = Math.min(time, delay);
        // 첫 추진력으로 이동한 거리
        result = 0.5 * primaryAcceleration * primaryTime * primaryTime;

        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            // Velocity 가속력 계산
            final double primaryVelocity = primaryAcceleration * delay;
            //acc = (primaryForce + secondaryForce) / mass;
            final double secondaryAcceleration = (primaryForce + secondaryForce) / mass;
            // 첫번째에 두번째에 이동한 거리 합산
            result += primaryVelocity * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime + secondaryTime;
        }

        return result;
    }
}
