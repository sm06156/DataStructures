package PriorityQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Heap<T extends Comparable<T>>{

	ArrayList<T> arrayList = new ArrayList<T>();
	int size;

	public Heap() {
		T blah = null;
		arrayList.add(blah);
	}

	public T getMin() {
		if(size == 0) return null;
		T temp = arrayList.get(1);
		arrayList.set(1,arrayList.get(size));
		size -= 1;
		topDownHeapify(1);

		return temp;
	}

	public T peek() {
		if(size == 0) return null;
		return arrayList.get(1);
	}

	public void add(T obj) {
		arrayList.add(obj);
		size +=1;
		this.bottomUpHeapify(size);
	}

	public void topDownHeapify(int index) {	
		if(index * 2 > size)return; //Leaf Node
		int leftChild = index * 2;
		int rightChild = index * 2 + 1;
		if(rightChild <= size) {
			int min = (arrayList.get(rightChild).compareTo(arrayList.get(leftChild)) > 0) ? leftChild:rightChild;
			if(arrayList.get(min).compareTo(arrayList.get(index)) < 0) {
				swap(index,min);
				topDownHeapify(min);
			}
		}
		else if((arrayList.get(index).compareTo(arrayList.get(leftChild)) > 0)) {
			swap(index,leftChild);
			topDownHeapify(leftChild);
		}

	}


	public void bottomUpHeapify(int index) {

		if(index <= 1)return;
		int parent = index/2;
		if(arrayList.get(parent).compareTo(arrayList.get(index)) > 0) {
			swap(parent,index); 
			bottomUpHeapify(parent);
		}

	}



	private void swap(int parent, int child) {
		T temp = arrayList.get(parent);
		arrayList.set(parent, arrayList.get(child));
		arrayList.set(child,temp);

	}

	public void printHeap() {

		for(int i = 1; i <= size/2; i++) {
			String parent = "Parent: " + arrayList.get(i).toString();
			String leftChild = "Left Child " + arrayList.get(i*2).toString();
			if(size >= i*2 +1) {
				String rightChild = "Right Child " + arrayList.get(i*2 + 1).toString();
				System.out.println(parent + leftChild +  rightChild);
			}
			else System.out.println(parent + " " + leftChild);
		}
	}

	public void breathPrint() {

		Queue<T> que = new LinkedList<T>();
		que.add(arrayList.get(1));
		System.out.println(arrayList.get(1).toString());
		recursPrint(que,1);
	}


	public void recursPrint(Queue<T> que, int index) {
		Queue<T> temp = new LinkedList<T>();
		if(que.isEmpty()) return;
		while(!que.isEmpty()) {
			que.poll();
			//don't like this lazyness at all but this is for fun anyway
			if(index * 2 <= size) {
				System.out.print(arrayList.get(index * 2) );
				temp.add(arrayList.get(index * 2));
			}
			if(index * 2 + 1 <= size) {
				temp.add(arrayList.get(index * 2 + 1));
				System.out.print("  " + arrayList.get(index * 2 + 1) + "    ");
			}
			index++;
		}
		System.out.println();
		recursPrint(temp,index);
		return;
	}



	public static void main(String[] args) {
		Heap<TestPriorityQueue> tester = new Heap<TestPriorityQueue>();
		populateTester(tester);
		tester.printHeap();
		System.out.println("Min: " + tester.getMin());
		tester.breathPrint();
	}

	public static void populateTester(Heap<TestPriorityQueue> test) {
		Random ran = new Random();
		for(int i = 0; i < 20; i++) {
			int ranNum = ran.nextInt(60) + 60;
			TestPriorityQueue temp = new TestPriorityQueue(ranNum,Character.toString((char) ranNum));//ints and their ASCI values
			test.add(temp);
		}


	}

}
