package br.com.polovinskycode.domain.funtion;

import static java.lang.Math.multiplyExact;

public class Multiply implements Arithmetic {

    private long x;
    private long y;

    public Multiply(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public long calc() {
        return multiplyExact(x, y);
    }

    @Override
    public Long call() throws Exception {
        return calc();
    }
}
