package com.bhupati;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
	private int size = 0;
	private static final int DEFULT_CAPACITY = 10;
	private Object elements[];
	
	public MyList() {
		elements = new Object[DEFULT_CAPACITY];
	}
	
	
	public void add(E e) {
		if(size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = e;
	}
	
	private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
	
	@SuppressWarnings("unchecked")
	public E get(int i)  {
		if(i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		return (E) elements[i];
	}
	
	public E remove(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		}
		E element = (E) elements[index];
		for(int i = index; i < size-1; i++) {
			elements[i] = elements[i+1];
		}
		size--;
		return element;
	}
	
	
	
	@Override
	public String toString() {
		return "MyList [elements=" + Arrays.toString(elements) + "]";
	}


	public static void main(String[] args) {
		MyList<Integer> list = new MyList<Integer>();
		list.add(10);
		list.add(20);
		
		System.out.println(list.remove(1));
		System.out.println(list);
	}
}
