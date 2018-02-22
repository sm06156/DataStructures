package QueueHeapImplementation;

public class Stack<T> implements Queue<T> {

	Nodes<T> list;
	/*
	 * FILOLOLOL
	 */
	public Stack() {
		list = new Nodes<T>();
	}

	
	@Override
	public void top() {
		if(this != null) {
			System.out.println("Top Value: " + this.list.value);
		}

	}
	
	
	@Override
	public T pop() {
		T temp = (T) this.list.value;
		this.list.value = (T) this.list.next.value;
		if(this.list.next != null) {
			this.list.next = this.list.next.next;
		}
		else this.list.next = null;
		return temp;
	}


	@Override
	public void push(T val) {
		if(this.list.value == null) {
			this.list.value = val;
			return;
		}
	
		T temp = (T) this.list.value;
		this.list.value = val;
		Nodes<T> secnd = new Nodes<T>(temp);
		secnd.next = this.list.next;
		this.list.next = secnd;
		
	}
	@Override
	public String toString() {
		System.out.println("List Contents:");
		Nodes curr = this.list;
		while(curr.next != null) {
			System.out.print(curr.value + "->");
			curr = curr.next;
		}
		System.out.println(curr.value);

		return super.toString();
	}
	
	static class Nodes<T> {

		T value;
		Nodes<T> next;

		public Nodes(T a) {
			this.value = a;
			this.next = null;
		}

		//default values
		public Nodes() {
		}


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		Integer[] valuesToBePushed = {1,2,3,4,5};

		for(int i = 0; i < valuesToBePushed.length; i++) {
			stack.push(valuesToBePushed[i]);	
		}

		stack.toString();

		stack.top();
		System.out.println(stack.pop().toString());
		stack.top();
		//Removed 1 from list
		stack.toString();
	}


	
}

