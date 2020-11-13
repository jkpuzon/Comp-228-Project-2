package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class DLList<E> implements ListInterface<E> {
	
	protected boolean found;
	protected int frontIterator, backIterator, size; // Not sure what data type this is i don't think it's an int just put that as a place holder
	protected LLNode<E> head;
	protected LLNode<E> tail;
	protected LLNode<E> location; // I believe we use this node to point to what ever we are searching for in the find methods, then in the methods... 
				     // we use the current to make whatever operation we need to use on that element whether it's with the remove, contains, or get methods
				     // after we are done using current in the methods it should be set to null
	public DLList() {
		
	}

	@Override
	public void add(E element) {
		
		
	}

	@Override
	public boolean remove(E element) {
		find(element);
		if(location.getInfo() != null){
			location.getPrev().setNext(location.getNext());
			location.getNext().setPrev(location.getPrev());
			size--;
			return true;
		else{
			return false;
		}
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return false;
	}

	@Override
	public boolean contains(E element) {
		
		return false;
	}

	@Override
	public E get(E element) {
		
		return null;
	}

	@Override
	public void resetIterator() {
		
		
	}
	
	public void resetBackIterator() {
		
	}

	@Override
	public E getNextItem() {
		
		return null;
	}
	
	public E getPrevItem() {
		
		return null;
	}

	public E find(E element) {
		
		return null;
	}
	
	public E find2(E element) {
		
		return null;
	}
	
	public String toString(){
		
	}

}
