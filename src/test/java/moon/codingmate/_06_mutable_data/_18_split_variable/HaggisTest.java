package moon.codingmate._06_mutable_data._18_split_variable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HaggisTest {

    @Test
    void distance() {
        // 10 추진력, 20 추진력, 10질량, 5초 이후에 두번째 추진력 발생. 총 10초 거리 이동 시 5초는 10 추진력으로 이동하고 나머지 5초는 20 추진력으로 이동.
        Haggis haggis = new Haggis(10d, 20d, 10, 5);
        assertEquals(50d, haggis.distanceTravelled(10));
        assertEquals(125d, haggis.distanceTravelled(20));
    }

}