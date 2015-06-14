package com.vgudzhev.ds;

import java.util.Arrays;

import com.vgudzhev.ds.interfaces.VectorInterface;

public class Vector<T> implements VectorInterface {

	private static final int MIN_CAPACITY = 10;

	private int size;
	private int capacity;
	private Object[] values;

	public Vector() {
		this.size = 0;
		this.capacity = MIN_CAPACITY;
		this.values = new Object[capacity];
	}

	@Override
	public void insert(int index, Object value) {
		ensureCapacity();
		
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (values[index] == null) {
			values[index] = (T) value;
		} else {
			System.arraycopy(values, index, values, index + 1, size
					- index);
			values[index] = value;
		}
		size++;
	}

	@Override
	public void add(Object value) {
		ensureCapacity();

		values[size] = (T) value;
		this.size++;
	}

	@Override
	public T get(int index) {
		if (index > size || values[index] == null) {
			throw new IndexOutOfBoundsException();
		}

		return (T) values[index];
	}

	@Override
	public void remove(int index) {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(values, index+1, values, index,
                             numMoved);
        values[--size] = null;
	}

	@Override
	public void pop() {
		values[size--] = null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int capacity() {
		return this.capacity;
	}
	
	private void ensureCapacity(){
		if (size == capacity) {
			values = Arrays.copyOf(values, capacity * 2);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			sb.append(values[i] + ",");
		}

		return sb.toString();
	}
}
