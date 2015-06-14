package com.vgudzhev.ds;

import java.util.NoSuchElementException;
import com.vgudzhev.ds.interfaces.QueueInterface;

public class Queue<T> implements QueueInterface<T> {
	private int size;
	private Node head;
	private Node tail;

	public Queue() {
		this.head = new Node();
		this.tail = new Node();
		this.size = 0;
	}

	@Override
	public void push(T value) {
		Node lastTail = tail;
		tail = new Node();
		tail.elementData = value;

		if (size == 0) {
			head = tail;
		} else {
			lastTail.next = tail;
		}

		size++;
	}

	@Override
	public T pop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		if (head == tail) {
			tail = null;
		}

		T headData = head.elementData;
		head = head.next;
		size--;

		return headData;
	}

	@Override
	public T peek() {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		return head.elementData;
	}

	@Override
	public int size() {
		return this.size;
	}

	private final class Node {
		public Node next;
		public T elementData;
	}
}
