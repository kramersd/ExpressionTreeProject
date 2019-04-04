import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException; 
import java.io.InputStreamReader;

public class p2 implements ExpressionTree { 
    public static void main(String[] args) throws IOException { 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in)); 
	    String input = reader.readLine();
        System.out.println("The input is: "+input);
        reader.close();
    }
    
    @Override
    public ExpressionTreeNode build_expression_tree(String s) {
    		ExpressionTreeNode a = new ExpressionTreeNode(s);
    		return a;
    }
    @Override
	public float evaluate_expression_tree(ExpressionTreeNode etn) {
		return 15;
	}
} 
