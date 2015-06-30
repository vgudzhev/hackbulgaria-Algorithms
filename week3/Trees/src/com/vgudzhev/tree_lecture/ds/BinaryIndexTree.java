package com.vgudzhev.tree_lecture.ds;

/**
 * _______________________________ 30/22/8/10/12/5/3 sum / initial values
 * ______/_________________________
 *
 * 8 = 5+3 22 = 10+12 30 = 22+8
 * 
 * The tree for input 10,12,5,3 30 / \ 22 8 / \ / \ 10 12 5 3
 */
public class BinaryIndexTree {

	// must 2^x
	private int ARRAY_SIZE = 1024;
	private final int FIRST_ELEMENT = ARRAY_SIZE / 2;
	protected int[] values;

	public BinaryIndexTree() {
		this.values = new int[ARRAY_SIZE];
	}

	public void buildTree(int[] arr) {
		
		// Add values to the right part of the array
		int valuesIndex = FIRST_ELEMENT;
		for (int i = 0; i < arr.length; i++) {
			values[valuesIndex++] = arr[i];
		}
		
		// Add sums to the left part of the array
		// Note that we must start from the end of the array (values[ARRAY_SIZE])
		// and the sum of last two elements is at N-1 position
		int lastSumIndex = FIRST_ELEMENT -1;
		for (int elementIndex = ARRAY_SIZE-1; elementIndex >= 1; elementIndex--) {
			values[lastSumIndex--] = values[elementIndex] + values[--elementIndex];
		}
	}

	public void update(int index, int value) {
		int elementIndex = FIRST_ELEMENT + index;
		
		while (elementIndex >= 1) {
			values[elementIndex] += value;
			elementIndex = getParentIndex(elementIndex);
		}		
	}

	public void delete(int index, int value) {
		int elementIndex = FIRST_ELEMENT + index;
		
		if (value <= values[elementIndex]) {
			while (elementIndex >=1) {
				values[elementIndex] -= value;
				elementIndex = getParentIndex(elementIndex);
			}
		}
	}

	public int count(int index) {
		int elementIndex = index + FIRST_ELEMENT;
		int sum = 0;
		
		while (elementIndex > 1) {
			if (isRightChild(elementIndex)) {
				sum += values[getLeftSibling(elementIndex)];
			}
			
			elementIndex /=2;
		}
		
		return sum;
	}

	protected int getParentIndex(int index) {
		return index / 2;
	}
	
	protected int getLeftSibling(int index){
		return --index;
	}
	
	protected boolean isRightChild(int index){
		return index % 2 != 0;
	}
	
	protected boolean isLeftChild(int left) {
		return left % 2 == 0;
	}
}
