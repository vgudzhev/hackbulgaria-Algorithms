package com.vgudzhev.tree_lecture.rmq;

import com.vgudzhev.tree_lecture.ds.BinaryIndexTree;

// TODO: add unit tests
public class RangeMinimumQuery extends BinaryIndexTree{
	public int rmq(int left, int right){
		left += getParentIndex(left);
		right += getLeftSibling(right);
		
		int minLeft = values[left];
		int rightMin = values[right];
		int temp;
		
		while (left < right) {
			if (isLeftChild(left)) {
				left = getParentIndex(left);
				minLeft = Math.min(minLeft, values[left]);
			}else{
				temp = values[left];
				left = getParentIndex(left+1);
				minLeft = Math.min(temp, values[left]);
			}
			
			if (isRightChild(right)) {
				temp = values[right];
				right = getParentIndex(right+1);
				rightMin = Math.min(temp, values[right]);
				
			}else{
				right = getParentIndex(right);
				rightMin = Math.min(rightMin, values[right]);
			}		
		}
		
		return minLeft;
	}
}
