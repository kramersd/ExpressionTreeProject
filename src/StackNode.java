
public class StackNode {
	private Object value;
	private StackNode next;
	private StackNode previous;
	
	public StackNode(Object val) {
		this.setValue(val);
		this.setPrevious(null);
		this.setNext(null);
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public StackNode getNext() {
		return this.next;
	}

	public void setNext(StackNode next) {
		this.next = next;
	}

	public StackNode getPrevious() {
		return this.previous;
	}

	public void setPrevious(StackNode previous) {
		this.previous = previous;
	}
}
