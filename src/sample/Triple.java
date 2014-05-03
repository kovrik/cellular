package sample;

public enum Triple {
    _000,
    _001,
    _010,
    _011,
    _100,
    _101,
    _110,
    _111;

    public static Triple of(boolean left, boolean middle, boolean right) {
        if (!left && !middle && !right) {
            return _000;
        }
        if (!left && !middle && right) {
            return _001;
        }
        if (!left && middle && !right) {
            return _010;
        }
        if (!left && middle && right) {
            return _011;
        }
        if (left && !middle && !right) {
            return _100;
        }
        if (left && !middle && right) {
            return _101;
        }
        if (left && middle && !right) {
            return _110;
        }
        if (left && middle && right) {
            return _111;
        }
        throw new IllegalArgumentException("Something weird is going on!");
    }
}
