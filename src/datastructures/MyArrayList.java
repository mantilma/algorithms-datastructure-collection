package datastructures;

/*
 *  Implementing ArrayList with Array in Java
 */
public class MyArrayList {
	private static final int SIZE_FACTOR = 5;
	private Object data[];
	private int size; //current size
	private int index; //last current index
	
	public MyArrayList () {
		this.data = new Object[SIZE_FACTOR];
		this.size = SIZE_FACTOR;
	}
	
	private void increaseSizeAndReallocate() {
		this.size = this.size + SIZE_FACTOR;
		Object temp[] = new Object[this.size];
		for(int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		this.data = temp; 
		System.out.println("*** index:"+this.index+" size:"+this.size+" data size:"+this.data.length);
	}
	
	public void add(Object obj) {
		System.out.println("index:"+this.index+" size:"+this.size+" data size:"+this.data.length);
		if (this.index == this.size-1) {
			//we need to increase the size of data[]
			increaseSizeAndReallocate();
		}
		this.data[index++] = obj;
	}
	
	public Object get(int i) throws Exception {
		if(i < 0) {
			throw new Exception("Negative Value");
		}
		else if (i > this.index - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		}
		return this.data[i];
	}
	
	public void remove(int i) throws Exception {
		if(i < 0) {
			throw new Exception("Negative Value");
		}
		else if (i > this.size - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		}
		System.out.println("Object getting removed: "+this.data[i]);
		for(int x=i; x<this.data.length-1; x++) {
			this.data[x] = this.data[x+1]; 
		}
		this.index--;
	}
	
	public static void main (String[] args) throws Exception {
		MyArrayList mal = new MyArrayList();
		mal.add("0");
		mal.add("1");
		mal.add("2");
		mal.add("3");
		mal.add("4");
		mal.add("5");
		mal.add("6");
		mal.add("7");
		mal.add("8");
		mal.add("9");
		
		mal.remove(5);
		System.out.println(mal.get(7));
	}
}
