import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException; 
import java.io.InputStreamReader;

public class p2 { 
    public static void main(String[] args) throws IOException { 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter an input:");
	    String input = reader.readLine();
        System.out.println("The input is: " + input);
        BinaryTree t = new BinaryTree(new TreeNode(""));
        t.build_expression_tree(input);
        TreeNode tn = t.getHead();
        printTree(tn);
       
        reader.close();
    }
    
    public static void printTree(TreeNode t) {
    		System.out.format("%s: %s\n", "Node Value", t.getValue());
    		if (t.getLeftChild() != null) {
    			System.out.format("%s: %s\n", "Left Child", t.getLeftChild().getValue());
    			
    		}
    		if (t.getRightChild() != null) {
    			System.out.format("%s: %s\n", "Right Child", t.getLeftChild().getValue());
    			
    		}
    		
    		if (t.getLeftChild() != null) {
    			printTree(t.getLeftChild());
    		}
    		if (t.getRightChild() != null) {
    			printTree(t.getRightChild());
    		}
    }
} 
