public class ExpressionTreeNode {
	private String operator;
	private Float value;
	private ExpressionTreeNode leftChild;
	private ExpressionTreeNode rightChild;
	
	public ExpressionTreeNode(String optr) {
		this.setOperator(optr);
	}
	
	public ExpressionTreeNode(Float val) {
		this.setValue(val);
	}

	public String getExpr() {
		return operator;
	}

	public void setOperator(String optr) {
		this.operator = optr;
	}
	
	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
	public void setLeftChild(ExpressionTreeNode etn) {
		this.leftChild = etn;
	}
	
	public ExpressionTreeNode getLeftChild() {
		return this.leftChild;
	}
	
	public void setRightChild(ExpressionTreeNode etn) {
		this.rightChild = etn;
	}
	
	public ExpressionTreeNode getRightChild() {
		return this.rightChild;
	}
}
