
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
	//will's
	@Override
	public void addFront(T newEntry) {
		ensureCapacity();
		for(int i = numberOfElements; i > 0; i--) {
			listArray[i] = listArray[i - 1];
		}
		listArray[0] = newEntry;
		numberOfElements++;
}

	// Sam's
	@Override
	public void addBack(T newEntry) {
		ensureCapacity();
		this.listArray[numberOfElements] = newEntry;
		numberOfElements++;

	}

	// Sam's
	@Override
	public T removeFront() {
		if (!this.isEmpty()) {
			T returnObj = listArray[0];
//			T[] tempArray = (T[]) new Object[listArray.length];
			for (int i = 0; i < numberOfElements; i++) {
//				tempArray[i] = listArray[i];
				listArray[i] = listArray[i + 1];
			}
			listArray[numberOfElements -1 ] = null;
			numberOfElements--;
			return returnObj;
		} else {
			return null;
		}

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
//		T[] tempArray = (T[]) new Array[numberOfElements];
		// changed Array[] to Object[] to avoid type mismatch with addBack
		// changed numberOfElements to listArray.length
		T[] tempArray = (T[]) new Object[listArray.length];
		listArray = (T[]) tempArray;
		
		// added
		numberOfElements = 0;
	}

	// mine
	@Override
	public T getEntry(int givenPosition) throws IllegalArgumentException {
		// validate position
		if (givenPosition >= 0 && givenPosition < numberOfElements) {			
			if (this.isEmpty()) {
	//			throw new IllegalArgumentException("Not a valid position - this structure appears to be empty.");
				// return null if out of bounds (see HeadTailListInterface)
				return null;
			} else if (listArray[givenPosition] == null) {
	//			throw new IllegalArgumentException("Not a valid position - the value is null.");
				// return null if out of bounds (see HeadTailListInterface)
				return null;
	
			} else {
				return listArray[givenPosition];
			}
		} else {
			return null;
		}
	}

	// Sam's
	@Override
	public void display() {
		System.out.print(numberOfElements + " elements; capacity = " + this.listArray.length + "\t");
		if (!this.isEmpty()) {
			System.out.print("[");
			for (int i = 0; i < numberOfElements - 1; i++) {
				System.out.print(listArray[i] + ", ");
			}
			System.out.println(listArray[numberOfElements - 1] + "]");
		}
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

	// Sam's
	@Override
	public int size() {
		return numberOfElements;
	}

	//will's
	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	private void ensureCapacity() {
		// If array is full, triple its length
		int capacity = listArray.length;
		if (numberOfElements >= capacity) {
			int newCapacity = 3 * capacity;
			T[]tempList = (T[]) new Object[newCapacity]; //cast should be fine because the initialized Array is populated with null entries
			for (int i = 0; i < listArray.length; i++) {
				tempList[i] = listArray[i];
			}
			listArray = tempList;
			
		}
		
	}
}
