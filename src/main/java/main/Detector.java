package main;

public class Detector {
    private static Detector instance;
    private Detector() {}

    public static Detector getInstance() {
        if (instance == null) {
            instance = new Detector();
        }
        return instance;
    }

    // ここから下のみ変更

    private int[] history = new int[20];
    private int  cnt = 0;

    // 履歴クリア
    public void init() {
        cnt = 0;
    }

    // 履歴に追加
    public void push(int v) {
        if (cnt < history.length) {
            history[cnt++] = v;
        }
    }

    public int detect() {
        // TODO: 実装
        return 0;
    }
}
