package com.helius;

/**
 * @Author jcf
 * @Create 2020-02-13-21:30
 */
public enum Season {
    /**
     * 春夏秋冬
     */
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);

    private int code;
    private Season(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}

