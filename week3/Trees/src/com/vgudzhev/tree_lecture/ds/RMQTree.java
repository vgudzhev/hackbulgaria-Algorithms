package com.vgudzhev.tree_lecture.ds;

public class RMQTree {
	private int[] values;
	private int size;
	
	public RMQTree(int[] tree, int size){
		this.values = new int[size*2];
		this.size = size;
		initTree(tree);
	}

	private void initTree(int[] tree) {
		// fill values
		for (int j = size, i=0; i <= tree.length; i++,j++) {
			values[size] = tree[i];
		}
		
		// fill index tree
		for (int i = 0; i < tree.length; i++) {
			
		}
		
	}
	
	public void getMinimumElement(int start, int end){
		
	}
	
	public int getParent(int index){
		return index / 2;
	}
	
	public boolean isLeftChild(int index){
		return true;
	}
	
	public boolean isRightChild(int index){
		return true;
	}
	
	public int isLeftSubTree(int index){
		return 1;
	}
	
	public int isRightSubTree(int index){
		return 1;
	}
}
