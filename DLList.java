package adts;

import interfaces.ListInterface;
import nodes.DLLNode;

public class DLList<E> implements ListInterface<E> {
	
	protected boolean found;
	protected boolean isChanged = false;
	protected int size = 0;
	protected DLLNode<E> forwardIterator;
	protected DLLNode<E> backwardIterator;
	protected DLLNode<E> head;
	protected DLLNode<E> tail;
	protected DLLNode<E> location;
	protected DLLNode<E> current;

	public void add(E element) {
		DLLNode<E> current;
		
		DLLNode<E> newNode = new DLLNode<E>(element);
		if (head == null) {
            		head = newNode;
		}
		else if (head.getInfo().compareTo(newNode.getInfo()) > 0){
			newNode.setNext(head);
			newNode.getPrev().setInfo(newNode);
			head= newNode;
		}
		else {
			current = head;
			 while(current.getNextItem() != null && current.getNextItem() < newNode.getInfo()) {
				 current = current.getNextItem();
			 }
			newNode.setNext(current.getNextItem());
			
			if (current.getNextItem() != null) {
				newNoew.getNextItem.setPrevItem(newNode);
			}
			current.setNextItem(newNode);
			newNode.setPreV(current); 
  		}
		size++;
	}
		
	@Override
	public boolean remove(E element) {
		find(element);
		if(found){
			// not head nor tail side of list
			if(location.getNext() != null && location.getPrev() != null) {
				location.getPrev().setNext(location.getNext());
				location.getNext().setPrev(location.getPrev());
			}
			// tail end of list
			else if(location.getNext() == null) {
				tail = tail.getPrev();
				tail.setNext(null);
			}
			// head end of list
			else if(location.getPrev() == null) {
				head = head.getNext();
				head.setPrev(null);
			}
			size--;
			return true;
		}
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
		return head == null;
	}

	@Override
	public boolean contains(E element) {
		/* Return true if the list contains an item such that item.equals(element) 
	 	is true for the element passed as a parameter to the contains method; otherwise, return false.
		*/
		//Not sure if this the correct way this method is suppose to use find and find2 and have not tested 
		find(element);
		find2(element);
		if(found) 
			return true;
		else
			return false;
	}
	
	@Override
	public E get(E element) {
		find(element);
		if(found){
		    return location.getInfo();
		}
		else {	
		    return null;
		}
	}

	@Override
	public void resetIterator() {
		forwardIterator = head;
	}
	
	public void resetBackIterator() {
		backwardIterator = tail;
	}

	@Override
	public E getNextItem() {
		E temp = forwardIterator.getInfo();
		forwardIterator = forwardIterator.getNext();
		if(forwardIterator == null){
			forwardIterator = head;
		}
		return temp;
	}
	
	public E getPrevItem() {
		E temp = backwardIterator.getInfo();
		backwardIterator = backwardIterator.getPrev();
		if(backwardIterator == null) {
			backwardIterator = tail;
		}
		return temp;
	}

	public void find(E element) {
		found = false;
		location = null;
		resetIterator();
		while (forwardIterator.getInfo() != null) {
			if (forwardIterator.getInfo() == element) {
				location = forwardIterator;
				found = true;
				break;
			}
			forwardIterator = forwardIterator.getNext();
		}
	}
	
	public void find2(E element) {
		// Set found
		// Set location. Location is LLNode<E>.
		// binarySearch is 
		found = false;
		location = null;
		E match = null;
		resetIterator();
		
		
		E[] binarySearch = (E[]) new Object[size()];// Make a new array if the list has been changed
		for (int i = 0; i < size(); i++) {
			binarySearch[i] = forwardIterator.getNext().getInfo();
		}
		
		
		int low = 0, high = size() - 1, current = 0;
		while (low < high) {
			if (((Comparable<E>)binarySearch[current]).compareTo(element) == 0) {
				found = true;
				match = binarySearch[current];
			}
			else if (((Comparable<E>)binarySearch[current]).compareTo(element) > 0) {
				high = current;
				current = (high + low) / 2;
			}
			else {
				low = current;
				current = (high + low) / 2;
			}
		}
		resetIterator();
		while (forwardIterator != null) {
			if (forwardIterator.getInfo().equals(match)) {
				location = forwardIterator;
			}
			forwardIterator = forwardIterator.getNext();
		}
			
	}
		
	
	public String toString() {
		String str = " ";
		DLLNode<E> current = head;
		while(current != null) {
			str = str + current.getInfo() + "\n";
			current = current.getNext();
		}
		return str;
	}
