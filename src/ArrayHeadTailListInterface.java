
import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayHeadTailListInterface<T> implements HeadTailListInterface<T> {

	private T[] listArray;
	private int numberOfElements;
	private static final int DEFAULT_CAPACITY = 25;

	public ArrayHeadTailListInterface() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayHeadTailListInterface(int initial_capacity) {
//		listArray = (T[]) new Array[initial_capacity - 1]; //cast should be fine because the initialized Array is populated with null entries
//		numberOfElements = initial_capacity;
		// Changed to tempList
		// Changed from Array to Object
		T[]tempList = (T[]) new Object[initial_capacity]; //cast should be fine because the initialized Array is populated with null entries
		listArray = tempList;
		// changed number of elements to 0 
		numberOfElements = 0;

	}

	@Override
	public void addFront(T newEntry) {
		listArray[0] = newEntry;
		numberOfElements++;
		ensureCapacity();
	}

	@Override
	public void addBack(T newEntry) {
		ensureCapacity();
		this.listArray[numberOfElements] = newEntry;
		numberOfElements++;

	}

	@Override
	public T removeFront() {
		listArray[0] = null;
		
		return null;
	}

	@Override
	public T removeBack() {
		// TODO Auto-generated method stub
		return null;
	}

	// mine
	@Override
	public void clear() {
		T[] tempArray = (T[]) new Array[numberOfElements];
		listArray = (T[]) tempArray;
	}

	// mine
	@Override
	public T getEntry(int givenPosition) throws IllegalArgumentException {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("Not a valid position - this structure appears to be empty.");
		} else if (listArray[givenPosition] == null) {
			throw new IllegalArgumentException("Not a valid position - the value is null.");
		} else {
			return listArray[givenPosition];
		}
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public int contains(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfElements == 0;
		
	}

	private void ensureCapacity() {
		// If array is full, triple its length
		int capacity = listArray.length;
		if (numberOfElements >= capacity) {
			int newCapacity = 3 * capacity;
//			listArray = Arrays.copyOf(listArray, newCapacity);
			T[]tempList = (T[]) new Object[newCapacity]; //cast should be fine because the initialized Array is populated with null entries
			listArray = tempList;
		}
		
	}
}
