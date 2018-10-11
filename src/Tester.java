
public class Tester {

	public static void main(String[] args) {
		HeadTailListInterface<Integer> list = new ArrayHeadTailListInterface<Integer>(10);
		list.addBack(7);
		System.out.println(list);
	}

}
