package com.example.phuongtrinhbac2;

import java.io.Serializable;

public class Number implements Serializable {

    private float a, b, c;

    public Number(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }
}
