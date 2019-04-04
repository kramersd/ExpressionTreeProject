
public class Stack {
	private StackNode head;
	
	public Stack(StackNode head) {
		this.setHead(head);
	}

	public StackNode getHead() {
		return head;
	}

	public void setHead(StackNode head) {
		this.head = head;
	}
	
	public void push(StackNode node) {
		StackNode sn = head;
		while ( !(sn.getNext() == null) ) {
			sn = sn.getNext();
		}
		node.setPrevious(sn);
		sn.setNext(node);
	}
	
	public StackNode pop() {
		StackNode sn = head;
		while ( !(sn.getNext() == null) ) {
			sn = sn.getNext();
		}
		if (!(sn.getPrevious() == null)) {
			sn.getPrevious().setNext(null);
		}
		return sn;
	}
}
