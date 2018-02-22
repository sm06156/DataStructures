package PriorityQueue;

public class TestPriorityQueue implements Comparable<TestPriorityQueue>{

	int value;
	String name;
	
	public TestPriorityQueue(int val,String name) {
		this.value = val;
		this.name = name;
	}

	@Override
	public int compareTo(TestPriorityQueue o) {
		
		return this.value - o.value;
	}
	@Override
	public String toString() {
		
		return String.valueOf(value) + ":" + name;
		
	}
}
