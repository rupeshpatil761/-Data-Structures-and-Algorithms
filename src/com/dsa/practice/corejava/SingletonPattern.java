package com.dsa.practice.corejava;

public class SingletonPattern {

	private SingletonPattern() {
	}

	private static SingletonPattern object = null;

	// simple solution
	public static SingletonPattern getObject() {
		if (object == null) {
			object = new SingletonPattern();
		}
		return object;
	}

	// synchronized method
	public static synchronized SingletonPattern getObject1() {
		if (object == null) {
			object = new SingletonPattern();
		}
		return object;
	}

	// synchronized block
	public static SingletonPattern getObject2() {
		if (object == null) {
			synchronized (SingletonPattern.class) {
				object = new SingletonPattern();
			}
		}
		return object;
	}

	// synchronized block with double locking -- BEST
	public static SingletonPattern getObject3() {
		if (object == null) {
			synchronized (SingletonPattern.class) {
				if (object == null) {
					object = new SingletonPattern();
				}
			}
		}
		return object;
	}
}