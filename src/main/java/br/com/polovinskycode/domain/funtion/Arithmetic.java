package br.com.polovinskycode.domain.funtion;

import java.util.concurrent.Callable;

public interface Arithmetic extends Callable<Long> {

    long calc();
}
