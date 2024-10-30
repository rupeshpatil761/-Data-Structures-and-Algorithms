package com.dsa.practice.java8.streams;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperatorExample {
	public static void main(String[] args) {
		
		System.out.println("--------------UnaryOperator-------------------");
		
		UnaryOperator<Integer> unary = i -> i * 10;
		System.out.println(unary.apply(100));

		Function<Integer, Integer> function = i -> i * 10;
		System.out.println(function.apply(100));

		IntUnaryOperator intUnaryOperator = i -> i * 10;
		System.out.println(intUnaryOperator.applyAsInt(100));

		LongUnaryOperator longUnaryOperator = i -> i * 10;
		System.out.println(longUnaryOperator.applyAsLong(10000000000000000l));

		DoubleUnaryOperator doubleUnaryOperator = i -> i * 10;
		System.out.println(doubleUnaryOperator.applyAsDouble(2000000.20000000));
		
		System.out.println("--------------BinaryOperator-------------------");
		
		BinaryOperator<Integer> binaryOperator = (a,b) -> a + b;
        System.out.println(binaryOperator.apply(2,4));

        Comparator<Integer> comparator = (a,b) -> a.compareTo(b);
        BinaryOperator<Integer> maxBi = BinaryOperator.maxBy(comparator);
        System.out.println(maxBi.apply(7,8));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println(minBy.apply(7,8));

        IntBinaryOperator intBi = (a,b) -> a*b;
        System.out.println(intBi.applyAsInt(2,4));

        LongBinaryOperator longBi = (a,b) -> a*b;
        System.out.println(longBi.applyAsLong(20000000l, 22222222222222222l));

        DoubleBinaryOperator doubleBi = (a,b) -> a*b;
        System.out.println(doubleBi.applyAsDouble(2222.22222, 22222222222222.22222));
	}
}
