package main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class SensorTest {
    private static Sensor sensor;

    @BeforeAll
    public static void setUp() {
        sensor = Sensor.getInstance();
    }

    @BeforeEach
    void beforeEachTest(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + ":");
    }

    // ここから下のみ変更

    @Test
    public void test0() {
        sensor.init(); // default values
        int v = sensor.read();
        System.out.println("v = " + v);
        assertTrue(v == 20, ()->"Invalid value");
    }

    /*
     * 故障を含むパターン定義
     *   パターン1 : t=5以降は差分が±1以内
     *   パターン2 : t=5以降は差分が±10を越える箇所が2箇所以上
     *   (20->35 と 27->12)
     */

    // パターン1
    private static final int[] values1 = { 20,23,21,18,20,20,19,20,21,20 };
    // パターン2
    private static final int[] values2 = { 20,23,21,18,20,35,29,27,12,20 };

    /*
     * 読出しのテスト
     */

    @Test
    public void test1() {
        int v = 0;
        sensor.init(values1);
        for (int t = 0; t < 6; t++) {
            v = sensor.read();
        }
        System.out.println("v = " + v);
        assertTrue(v == 20, ()->"Invalid value");
    }

    @Test
    public void test2() {
        int v=0;
        sensor.init(values2);
        for (int t = 0; t < 6; t++) {
            v = sensor.read();
        }
        System.out.println("v = " + v);
        assertTrue(v == 35, ()->"Invalid value");
    }
}
