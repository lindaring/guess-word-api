package com.lindaring.guess.enumerator;

public enum Enabled {
    
    FALSE(0),
    TRUE(1);
    
    private int enabled;

    private Enabled(int enabled) {
        this.enabled = enabled;
    }    
    
    public static int toInt(Enabled enumValue) {
        return (enumValue == TRUE) ? 1 : 0;
    }
    
}
