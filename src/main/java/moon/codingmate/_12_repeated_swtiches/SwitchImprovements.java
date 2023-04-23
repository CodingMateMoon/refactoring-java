package moon.codingmate._12_repeated_swtiches;

public class SwitchImprovements {

    public int vacationHours(String type) {
        // switch expression (Java 17)
        int result = switch (type) {
            case "full-time" -> {
                // 복잡한 계산식 이후 반환
                yield 120;
            }
            //case "full-time" : yield 120;
            case "part-time" -> 80;
            case "temporal" -> 32;
            default -> 0;
        };
        /*
        switch (type) {
            case "full-time": result = 120; break;
            case "part-time": result = 80; break;
            case "temporal": result = 32; break;
            default: result = 0;
        }
         */
        return result;
    }
}
