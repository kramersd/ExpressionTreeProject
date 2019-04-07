import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException; 
import java.io.InputStreamReader;

public class p2 { 
    public static void main(String[] args) throws IOException { 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in));
        
        String input = reader.readLine();
        System.out.println("The input is: " + input);
        BinaryTree t = new BinaryTree(new TreeNode(""));
        t.build_expression_tree(input);
        TreeNode tn = t.getHead();
        System.out.print("The inorder traversal is: ");
        printInfix(tn);
        System.out.println("\nThe output of the expression is: " + t.evaluate_expression_tree(input));
        reader.close();
    }
    
    public static void printInfix(TreeNode tn) {
    		if (tn != null) {
    			printInfix(tn.getLeftChild());
    			System.out.format("%s " , tn.getValue());
    			printInfix(tn.getRightChild());
    		}
    }
    
    public static void printTree(TreeNode t) {
    		System.out.format("%s: %s\n", "Node Value", t.getValue());
    		if (t.getLeftChild() != null) {
    			System.out.format("%s: %s\n", "Left Child", t.getLeftChild().getValue());
    			
    		}
    		if (t.getRightChild() != null) {
    			System.out.format("%s: %s\n", "Right Child", t.getRightChild().getValue());
    			
    		}
    		
    		if (t.getLeftChild() != null) {
    			printTree(t.getLeftChild());
    		}
    		if (t.getRightChild() != null) {
    			printTree(t.getRightChild());
    		}
    }
} 
