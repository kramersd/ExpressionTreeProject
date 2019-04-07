
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
			
			// Error handling to check for Malformed Input (e.g extra spacing)
			if (tokens[i].equals("") || tokens[i].equals(" ")) {
				System.out.println("Malformed input, please try again!");
				return;
			}
			
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
				nt.setLeftChild(tRight);
				nt.setRightChild(tLeft);
				
				// Create a new StackNode with the TreeNode Value
				StackNode sn = new StackNode(nt);
				
				// Push the StackNode onto the Stack
				this.stack.push(sn);
			} 
			// Else the token is an operand
			else {
				
				//Create a new TreeNode and StackNode from the value
				TreeNode tn = new TreeNode(tokens[i]);
				StackNode sn = new StackNode(tn);
				
				// Push the StackNode onto the Stack
				this.stack.push(sn);
			}
		}
		
		TreeNode tn = (TreeNode)this.stack.pop().getValue();
		this.head = tn;
	}

	@Override
	public double evaluate_expression_tree(String str) {
		
		// Basic Error Checking
		if ( str.equals(null) || (str.length()) == 0) {
			System.out.println("Expression String is undefined or empty\n");
			return -1.0;
		}
		
		// Split expression into tokens based on a single white space
		this.tokens = str.split(" ");
		
		// Iterate through the tokens
		for (String element : tokens) {
			
			// Error handling to check for Malformed Input (e.g extra spacing)
			if (element.equals("") || element.equals(" ")) {
				System.out.println("Malformed input, please try again!");
				return -1.0;
			}
			
			// If the token is an operator
			if (operators.contains(element)) {
				// Pop twice off the Stack for the two most recent operands
				StackNode snLeft = this.stack.pop();
				StackNode snRight = this.stack.pop();
				
				double result = 0.0;
				switch(element) {
					case "*": result = (double)snRight.getValue() * (double)snLeft.getValue(); break;
					case "/": result = (double)snRight.getValue() / (double)snLeft.getValue(); break;
					case "+": result = (double)snRight.getValue() + (double)snLeft.getValue(); break;
					case "-": result = (double)snRight.getValue() - (double)snLeft.getValue(); break;
				}
				
				// Create a new StackNode with the TreeNode Value
				StackNode sn = new StackNode(result);
				
				// Push the StackNode onto the Stack
				this.stack.push(sn);
			}
			// Else the token is an operand
			else {
				// Parse the operand into a double
				double value = Double.parseDouble(element);
				
				// Create a new StackNode containing the parsed value
				StackNode sn = new StackNode(value);
				
				// Push the StackNode onto the Stack
				this.stack.push(sn);
			}
		}
		
		// Pop the stack and get the value
		return (double)this.stack.pop().getValue();
	}
}
