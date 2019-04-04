public class TreeNode {
	private String value;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(String val) {
		this.setValue(val);
		this.setLeftChild(null);
		this.setRightChild(null);
	}
	
	public void setValue(String val) {
		this.value = val;
	}
	
	public String getValue() {
		return this.value;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
}
