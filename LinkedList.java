public class LinkedListApp {
	public static void main(String[] args){
		LinkedList<Integer> queue = new LinkedList<>();
		// queue in
		queue.add(1); queue.add(2); queue.add(3); queue.add(4);
		// queue out
		queue.delete(0);

		LinkedList<Integer> stack = new LinkedList<>();
		// stack in
		stack.add(1); stack.add(2); stack.add(3); stack.add(4);
		// stack out
		stack.delete(stack.getSize()-1);
	}
}
public class LinkedList<T> {
    Node<T> root;
    int size = 0;
    public LinkedList(){ setRoot(null); }
    public LinkedList(T t){ setRoot(new Node(t)); setSize(getSize()+1); }

    public void add(T t){
        Node<T> addNode = new Node(t);
        Node<T> current = getRoot();
        if(current==null){ setRoot(addNode); }
        else{
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(addNode);
        }
        setSize(getSize()+1);
    }
    public T get(int index){
        if(index>=size){ return null; }
        Node<T> current = getRoot();
        for(int i=0;i<index;i++){
            current = current.getNext();
        }
        return current.getData();
    }
    public void delete(int index){
        if(index>=size){ return; }
        Node<T> current = getRoot();
        for(int i=0;i<index-1;i++){
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        setSize(getSize()-1);
    }

    public Node<T> getRoot() { return root; }
    public void setRoot(Node<T> root) { this.root = root; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
}
class Node<T>{
    T data;
    Node<T> previous;
    Node<T> next;
    Node(T t){ this.data = t; previous = null; next = null; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public Node<T> getNext() { return next; }
    public void setNext(Node<T> next) { this.next = next; }
}