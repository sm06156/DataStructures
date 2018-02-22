package QueueHeapImplementation;

public class Stack<T> implements Queue<T> {

	@SuppressWarnings("rawtypes")
	Nodes list;
	/*
	 * FILOLOLOL
	 */
	@SuppressWarnings("rawtypes")
	public Stack() {
		list = new Nodes();
	}

	
	@Override
	public void top() {
		if(this != null) {
			System.out.println("Top Value: " + this.list.value);
		}

	}
	
	
	@SuppressWarnings("unchecked")
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


	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		Stack stack = new Stack();
		Integer[] valuesToBePushed = {1,2,3,4,5};
		String[] stringsToBePushed = {"one","two","three","four","five"};

		for(int i = 0; i < valuesToBePushed.length; i++) {
			stack.push(valuesToBePushed[i]);
			stack.push(stringsToBePushed[i]);	
		}

		stack.toString();

		stack.top();
		System.out.println(stack.pop().toString());
		stack.top();
		//Removed 1 from list
		stack.toString();
	}


	
}

