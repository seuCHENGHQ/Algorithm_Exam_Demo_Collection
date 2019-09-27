package com.chq.algorithm;

import java.util.stream.Stream;

public class jd {
    public static void main(String[] args) {
        Stream.of("jd","jd.com","www.jd.com","www.jd.jd").mapToInt(String::length).filter(len->len>3).peek(System.out::println).
                limit(2);
        Element[] arr = new Element[2];
        arr[0] = new Element();
    }
}

class Element{

}
