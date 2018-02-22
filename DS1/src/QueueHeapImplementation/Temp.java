package QueueHeapImplementation;
import java.util.Arrays;
import java.util.Random;

public class Temp {

	
	static class MyClass{
		int value;
		MyClass next;

		public MyClass(int a) {
			this.value = a;
			this.next = null;
		}

		//default values
		public MyClass() {
		}
		
		
		//Adds value to end of LinkedList
		public void addValue(int a) {
			MyClass current = this;
			while(current.next != null) {
				current = current.next;
			}
			
			current.next = new MyClass(a);

		}
		//current is always next value
		
		public MyClass reverseList(MyClass head) {
			MyClass attempt = new MyClass();
			if(head.next == null) 
				return new MyClass(head.value); 
			else {  
				attempt = reverseList(head.next);
				MyClass temp = attempt;
				while(temp.next != null) {
					temp = temp.next;
				}
				temp.next = new MyClass(head.value);
				return attempt; 
			}
		
		}
	}

	public static void main(String[] args) {


		int[] array = {1,2,3,4,5,6,7,8,9,10};
		rearrange(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
		MyClass linkedList = new MyClass(1);
		linkedList.addValue(2);
		linkedList.addValue(3);
		linkedList.addValue(4);
		
		MyClass reversed = linkedList.reverseList(linkedList);
		System.out.println("Reversed List");
		while(reversed != null) {
			System.out.print(reversed.value + " ");
			reversed = reversed.next;
		}
		
	}



	//ignore red while typing...????
	public static int[] rearrange(int[] arr, int l, int r) {

		if(l >= r) return arr;

		if(arr[l] % 2 != 0 &&  arr[r] % 2 != 1) {
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			rearrange(arr, l+1, r-1);
		}
		else if(arr[l] % 2 == 0) {
			rearrange(arr,l+1,r);
		}
		else if(arr[r] % 2 == 1) {
			rearrange(arr,l,r-1);
		}
		else rearrange(arr,l+1,r-1);


		return arr;
	}

	

}
