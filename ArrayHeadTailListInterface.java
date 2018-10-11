
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

	//will's
	@Override
	public void addFront(T newEntry) {
		ensureCapacity();
		for(int i = numberOfElements; i > 0; i--) {
			listArray[i] = listArra y[i - 1];
		}
		listArray[0] = newEntry;
		numberOfElements++;
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

	//will's
	@Override
	public T removeBack() {
		T returnObj = null;
		if(!isEmpty()) {
			returnObj = listArray[numberOfElements - 1];
			listArray[numberOfElements - 1] = null;
			numberOfElements--;
		}
		return returnObj;
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

	//will's
	@Override
	public int contains(T anEntry) {
		int indexOfEntry = -1;
		boolean found = false;
		int counter = 0;
		while(counter < numberOfElements && !found){
			if(listArray[counter].equals(anEntry)){
				indexOfEntry = counter;
				found = true;
			}
			counter++;
		}
		return indexOfEntry;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	//will's
	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	//Will's Note to Self.
	// Will, you take the addFront, the contains, the isEmpty, and the removeBack

}
