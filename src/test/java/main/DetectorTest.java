package main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class DetectorTest {
    private static Sensor sensor;
    private static Detector detector;

    @BeforeAll
    public static void setUp() {
        sensor = Sensor.getInstance();
        detector = Detector.getInstance();
    }

    @BeforeEach
    void beforeEachTest(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + ":");
    }

    // ここから下のみ変更

    @Test
    public void test0() {
        sensor.init();
        detector.init();
        int r = detector.detect();
        assertTrue(r == 0);
    }

    @Test
    public void test1() {
        sensor.init();
        detector.init();
        int v = 0;
        for (int t = 0; t < 5; t++) {
            v = sensor.read();
            detector.push(v);
        }
        int r = detector.detect();
        assertTrue(r == 0);
    }
}
