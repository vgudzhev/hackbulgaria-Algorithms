package com.vgudzhev.ds;

import java.util.NoSuchElementException;

import com.vgudzhev.ds.interfaces.StackInterface;

public class Stack<T> implements StackInterface<T> {
	private int size;
	private Queue<T> firstQueue;
	private Queue<T> secondQueue;

	public Stack() {
		firstQueue = new Queue<T>();
		secondQueue = new Queue<T>();
		this.size = 0;
	}

	@Override
	public void push(T value) {
		firstQueue.push(value);
		size++;
	}

	@Override
	public T pop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		if (firstQueue.size() == 1) {
			size--;

			return firstQueue.pop();

		} else {
			for (int i = 0; i < size - 1; i++) {
				secondQueue.push(firstQueue.pop());
			}

			T value = firstQueue.pop();
			for (int i = secondQueue.size(); i > 0; i--) {
				firstQueue.push(secondQueue.pop());
			}

			size--;
			return value;
		}
	}

	@Override
	public T peek() {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		if (firstQueue.size() == 1) {
			return firstQueue.peek();

		} else {
			for (int i = 0; i < size - 1; i++) {
				secondQueue.push(firstQueue.pop());
			}

			T value = firstQueue.peek();
			secondQueue.push(firstQueue.pop());
			for (int i = size; i > 0; i--) {
				firstQueue.push(secondQueue.pop());
			}

			return value;
		}
	}

	@Override
	public int size() {
		return this.size;
	}
}