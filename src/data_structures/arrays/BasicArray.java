package data_structures.arrays;

import java.util.Arrays;

public class BasicArray {
	
	public static void main(String[] args) {
		MyArray myArray = new MyArray(2);
		printArray(myArray);
		myArray.add("Hi");
		myArray.add("Hello");
		printArray(myArray);
		myArray.delete(0);
		printArray(myArray);
		myArray.add("Hi");
		printArray(myArray);
	}
	
	private static void printArray(MyArray myArray) {
		System.out.println(Arrays.toString(myArray.getArray()) + "==data & lenght==" + myArray.length
				+ " ==& capacity==" + myArray.capacity);
	}

}

class MyArray {
	
	int capacity;
	int length;
	Object[] data;
	
	MyArray(){
		this.length = 0;
		this.capacity = 1;
		this.data = new Object[capacity];
	}
	
	MyArray(int capacity){
		this.length = 0;
		this.capacity = capacity;
		this.data = new Object[capacity];
	}
	
	public void add(Object ele) {
		if(capacity>0) {
			data[length] = ele;	
			length++;
			capacity--;
		} else {
			throw new RuntimeException("Array is full");
		}
	}
	
	public void delete(int index) {
		//Object deletedEle = this.data[index];
		for(int i=index; i < length-1; i++) {
			this.data[i] = this.data[i+1];
		}
		this.data[length-1] = null;
		length--;
		capacity++;
	}
	
	public Object[] getArray() {
		Object[] tempArray = new Object[length];
		for(int i=0; i < length; i++) {
			tempArray[i] = data[i];
		}
		return tempArray;
	}
}