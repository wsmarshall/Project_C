
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
		listArray = (T[]) new Array[initial_capacity - 1]; //cast should be fine because the initialized Array is populated with null entries
		numberOfElements = initial_capacity;
	}

	@Override
	public void addFront(T newEntry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBack(T newEntry) {
		// TODO Auto-generated method stub

	}

	@Override
	public T removeFront() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		return false;
	}

}
