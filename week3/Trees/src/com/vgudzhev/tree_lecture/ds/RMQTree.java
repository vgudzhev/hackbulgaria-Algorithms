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
