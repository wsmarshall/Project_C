
public class AListHeadTailListInterface<T extends Comparable<? super T>> implements HeadTailListInterface<T> {

	ListInterface<T> aList = new AList(); //initialize to type AList;

	public AListHeadTailListInterface(int initialCapacity){
		ListInterface<T> tempList =  new AList(initialCapacity);
		this.aList = tempList;
	}

	@Override
	public void addFront(T newEntry) {
		//((AList) aList).makeRoom(1);
		//Can omit the makeRoom() invokation since add method calls makeroom.
		aList.add(1, newEntry);
		
	}

	@Override
	public void addBack(T newEntry) {
		aList.add(newEntry);
		//aList.add(aList.getLength()+1, newEntry);
		//can just call the aList.add(newEntry);
		//since aList.add(newEntry) calls the .add(getLength, newEntry method)
		
	}

	@Override
	public T removeFront() {
		T temp = aList.remove(1);
		//((AList) aList).removeGap(1);
		//can omit removeGap method since remove calls it.
		return temp;
	}

	@Override
	public T removeBack() {
		return aList.remove(aList.getLength());
	}

	@Override
	public void clear() {
		aList.clear();
	}

	@Override
	public T getEntry(int givenPosition) {
		return aList.getEntry(givenPosition);
	}

	@Override
	public void display() {
		System.out.println(aList.toArray().toString());
		
	}

	@Override
	public int contains(T anEntry) {
		int containsPosition = -1;
		boolean isFound = false;
		int counter = 1;

		while(counter <= aList.getLength() && !isFound){
			if(aList.getEntry(counter).equals(anEntry)){
				isFound = true;
				containsPosition = counter;
			}
			counter++;
		}
		/*
		if(aList.contains(anEntry)) {
			for(int i = 1; i<=aList.getLength(); i++) {
				if(aList.getEntry(i).equals(anEntry)){
					return i;
					
				}
			}
		}
		*/
		return containsPosition;
	}

	@Override
	public int size() {
		return aList.getLength();
	}

	@Override
	public boolean isEmpty() {
		return aList.isEmpty();
	}

}
