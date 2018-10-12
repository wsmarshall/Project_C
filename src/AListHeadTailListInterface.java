
public class AListHeadTailListInterface<T extends Comparable<? super T>> implements HeadTailListInterface<T> {

	ListInterface<T> aList = new AList(); //initialize to type AList;
	
	
	@Override
	public void addFront(T newEntry) {
		((AList) aList).makeRoom(1);
		aList.add(1, newEntry);
		
	}

	@Override
	public void addBack(T newEntry) {
		aList.add(aList.getLength()+1, newEntry);
		
	}

	@Override
	public T removeFront() {
		T temp = aList.remove(1);
		((AList) aList).removeGap(1);
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
		if(aList.contains(anEntry)) {
			for(int i = 1; i<=aList.getLength(); i++) {
				if(((AList) aList).list[i].equals(anEntry)) {
					return i;
					
				}
			}
		}
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
