package moon.codingmate._05_global_data._17_encapsulate_variable;

public class Thermostats {

    // 글로벌 값을 허용하는 경우는 보통 public static final ~ 상수값입니다.
    private static Integer targetTemperature = 70;

    private static Boolean heating = true;

    private static Boolean cooling = false;

    private static Boolean readInFahrenheit = true;

    public static Integer getTargetTemperature() {
        return targetTemperature;
    }

    public static void setTargetTemperature(Integer targetTemperature) {
        Thermostats.targetTemperature = targetTemperature;
    }

    public static Boolean getHeating() {
        return heating;
    }

    public static void setHeating(Boolean heating) {
        // Encapsulate Variable 변수 캡슐화 장점 : 값을 아무거나 넣을 수 없도록 하는 validation 로직. 후처리를 위해 메소드로 감싸는 것을 추천합니다.
        // TODO validation
        Thermostats.heating = heating;
        // TODO notify
    }

    public static Boolean getCooling() {
        return cooling;
    }

    public static void setCooling(Boolean cooling) {
        Thermostats.cooling = cooling;
    }

    public static Boolean getReadInFahrenheit() {
        return readInFahrenheit;
    }

    public static void setReadInFahrenheit(Boolean readInFahrenheit) {
        Thermostats.readInFahrenheit = readInFahrenheit;
    }
}
