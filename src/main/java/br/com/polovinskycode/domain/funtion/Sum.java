package br.com.polovinskycode.domain.funtion;

import static java.lang.Math.addExact;

public class Sum implements Arithmetic {

    private long x;
    private long y;

    public Sum(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public long calc() {
        return addExact(x, y);
    }

    @Override
    public Long call() throws Exception {
        return calc();
    }
}
