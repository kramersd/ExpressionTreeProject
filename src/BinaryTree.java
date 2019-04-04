
public class BinaryTree implements ExpressionTree {
	private TreeNode head;
	private String[] tokens;
	private String operators = "*/+-";
	private Stack stack;
	
	
	public BinaryTree(TreeNode t) {
		this.head = t;
		this.setStack(new Stack(new StackNode("")));
	}
	
	public void setHead(TreeNode t) {
		this.head = t;
	}
	
	public TreeNode getHead() {
		return this.head;
	}
	
	public Stack getStack() {
		return stack;
	}

	public void setStack(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void build_expression_tree(String str) {
		
		// Basic Error Checking
		if ( str.equals(null) || (str.length()) == 0) {
			System.out.println("Expression String is undefined or empty\n");
			return;
		}
		
		// Split expression into tokens based on a single white space
		this.tokens = str.split(" ");
		
		// Create a new Stack head
		TreeNode head = new TreeNode(tokens[0]);
		head.setLeftChild(null);
		head.setRightChild(null);
		
		// Iterate through the tokens
		for (int i = 0; i < tokens.length; i++) {
			
			// If the token is an operator
			if (operators.contains(tokens[i])) {
				
				// Create a new TreeNode from the operator token
				TreeNode nt = new TreeNode(tokens[i]);
				
				// Pop twice off the Stack for the two most recent operands
				StackNode snLeft = this.stack.pop();
				StackNode snRight = this.stack.pop();
				
				// Set the new TreeNode's left and right children
				TreeNode tLeft = (TreeNode)snLeft.getValue();
				TreeNode tRight = (TreeNode)snRight.getValue();
				nt.setLeftChild(tLeft);
				nt.setRightChild(tRight);
				
				// Create a new StackNode with the TreeNode Value
				StackNode sn = new StackNode(nt);
				
				// Push the StackNode onto the Stack
				this.stack.push(sn);
			} 
			// Else the token is an operand
			else {
				TreeNode tn = new TreeNode(tokens[i]);
				StackNode sn = new StackNode(tn);
				this.stack.push(sn);
			}
		}
		TreeNode tn = (TreeNode)this.stack.pop().getValue();
		this.head = tn;
	}

	@Override
	public float evaluate_expression_tree(TreeNode tn) {
		
		// Basic Error Checking
		if ( tn.equals(null) || (tn.getValue() == null)) {
			System.out.println("Tree Node is undefined or empty\n");
			return -1;
		}
		return 0;
	}
}
