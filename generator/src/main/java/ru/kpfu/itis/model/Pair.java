package ru.kpfu.itis.model;

public class Pair<X, Y> {
    public Pair(X x, Y y) {
        first = x;
        second = y;
    }

    public X first;
    public Y second;
}