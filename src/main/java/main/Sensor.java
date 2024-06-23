package main;

public class Sensor {
    private static Sensor instance;
    private Sensor() {}

    public static Sensor getInstance() {
        if (instance == null) {
            instance = new Sensor();
        }
        return instance;
    }

    // ここから下のみ変更

    // 故障なし
    private static final int[] defvalues = { 20,22,24,27,23,21,19,16,17,19 };

    private static int[] values;
    private static int index;

    // デフォルト値使用
    public void init() {
        index = 0;
        values = defvalues;
    }

    // 初期値あり
    public void init(int[] v) {
        index = 0;
        values = v;
    }

    // device emulation
    public int read() {
        int v = values[index];
        if (++index >= values.length) {
            index = 0;
        }
        return v;
    }
}
