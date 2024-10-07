package org.example.Enums;

public enum Points {
    NEGATIVE_ONE_POINT(-1),
    THREE_POINTS(3),
    ;

    private final int value;

    public int getValue(){
        return value;
    }

    Points(int i) {
        this.value = i;
    }
}
