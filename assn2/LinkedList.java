/*
1.  write versions of all the functions
  set *
  findLast *
  inSort *
  bubbleIns *
2. troubleshoot
  set *
  findLast *
  inSort *
 */


package assn2;

public class LinkedList implements List {
  private Node head = null;
  private Node tail = null;
  private int size = 0;

  
//================================================================= 
  // You will implement the 4 methods below for assignment 2.
  // IMPORTANT: Note that the methods are provided with default 
  // return values (e.g., "-1" for findLast) so that the code will
  // initially compile.  You should remove the default return value
  // when you implment the methods.
//=================================================================
   
  public boolean set ( int index, double element ) {
      //See List.java for a description of the method's behavior and examples.
      //Hint: Ask yourself how this is different from the "ins" method.
      //Hint: Remember that we start indexing with 0 rather than 1.

      /*Your code here */
    //this.elts[index] = elt;
    //this.size++;
      //this.elt[index] = element;
      Node current = head;
      //if linked list has no values return false
      if (index<0 || index>this.size) { return false; }
      //iterate through the list
      for (int i = 0; i<this.size; i++) {
        if (index == i) {
          current.setValue(element);
          return true;
        } else {
          //if not the index we're looking for, try the next node
          current = current.getNext();
        }
      }
      return false;
      //otherwise, move pointer to next value and see if new i relates to my index
  //Remove this when you implement the method!
  }
      
  public int findLast ( double element ) {
    //See List.java for a description of the method's behavior and examples.
    //Hint: Make sure you understand how this is different from find
    //do i have to do get previous?
    Node current = head;
    int index = -1;
    //set index at the element but before returning see if there are any more
      for (int i = 0; i<this.size; i++) {
        if (current.getValue() == element) {
          index = i;
        }
        current = current.getNext();
      }
    return index;
  }

  public boolean inSort ( double elt ) {
    //See List.java for a description of the method's behavior and examples.

    /*Your code here */
    if (this.size == 0) {
      ins(0, elt);
      return true;
    }
    //start node at the beginning

    //iterate through the list
    //save j as min
    //save j+1 as max
    //compare elt to both
    if (elt < head.getValue()) {
      ins(0, elt); return true;
    }

    Node current = head;
    int index = -1;
    //i want my question if code to run again for every next value
    //that's why outside of my question i go to the next current value till i get to the last one
    //then it may be giving me the extra
    for (int j = 0; j < this.size-1; j++) {
      //if the element is in between,
      if (current.getValue() < elt && current.getNext().getValue() >= elt) {
        //insert the node after the 'current' value
        //ins(j + 1, elt);
        ins(j+1, elt);
        return true;
      }
      current = current.getNext();
    }
    if (current.getValue() > tail.getValue()) {
      ins(this.size-1, elt);
      return true;
    }
    return false;  //Remove this when you implement the method!
  }
   
  public boolean bubbleIns  ( double elt ) {
    //See List.java for a description of the method's behavior and examples.
    //Hint: Do any of the methods already provided to you help?
    //use contains
    Node current = head;

    if (contains(elt)) {
      //remove element
      for (int i = 0; i < this.size; i++) {
        //when you come across the place in the list with the element,
        //set location equal to the index of that place
        if (current.getValue() == elt) {
          //remove item from list
          rem(i);
          ins(0, elt);
          return true;
        } current = current.getNext();
      }
    } //and if it doesn't contain the element,
    ins(0, elt); return true;

    /*
    Node current = head;
    int location = -1;
    //from 0 to one less than size,
    for (int i = 0; i < size-1; i++) {
      //when you come across the place in the list with the element,
      //set location equal to the index of that place
      if (current.getValue() == elt) {
        //remove item from list
        rem(i);
        //move everything down one & ins @ line 0
        current = head;
        ins(0, elt);
        return true;
      }
    }
    //no need for else statement here, bc if it goes through the loop w/o returning, elt isn't in there
    //do the exact same thing
    //move everything down one
    current = head;
    current.setValue(elt);
    return true;
    /*Your code here */
  }
  
  /* Implementation given to you. Do not modify below this. */

  public int size() { return this.size; }

  public boolean isEmpty() { return this.size == 0; }
  
  public void clear() { this.head=null; this.tail=null; this.size=0; }

  public boolean contains(double element) {
    Node current = head;
    while(current != null) {
      if(current.getValue() == element) { return true; }
      //go to the next node
      current = current.getNext();
    }
    return false;
  }
    
  public boolean rem (int index) {
    if (index<0 || index>=this.size) { return false; } // bad index
    if( isEmpty() ) { return false; } // empty list cant remove anything
    // now here we have a non-empty list and a good index ... in range
    if( index==0 ) { // first, a special case... we are trying to remove head
      if (this.tail == this.head) { // this is the case where list size is 1
        this.tail=null; 
      }
      this.head = this.head.getNext();
      size--;
      return true;
    }
    // here we are removing a node other than head
    // walk list find the node involved
    Node curr = this.head;
    Node prev = null;
    for (int i=0; i<index; i++) { prev=curr;  curr=curr.getNext(); }
    // now curr points to the node to remove... 
    // prev points to node before it
    prev.setNext(curr.getNext());
    // special case... did we remove the last node?
    if (curr==this.tail) { this.tail = prev; }
    size--;
    return true;
  }

  public double get(int index) {
    if (index<0 || index>=this.size ) { return Double.NaN; }
    Node current = head;
    int i = 0;
    while (i<index) { current=current.getNext(); i++; }
    return current.getValue();
  }
    
  public boolean ins (int index, double element) {
    //if index is out of range return false
    if (index<0 || index>this.size) { return false; }
    //starts pointer @ head
    Node current = head;
    int i = 0;
    if(index == 0) {
      //if the list is empty,
      //add to the end of the list
      if(isEmpty()) { insLast(element); return true; } 
      else {
        //list not empty, inserting @ 0
        Node newNode = new NodeImpl(element, head);
        head = newNode;
        size++;
        return true;
      }
    } 
    else if(index == size) {
      insLast(element); // adds to last
      return true;
    }
    while(current != null) {
      if(i == (index - 1)) {
        //go to the next node of current (which started @ head)
        Node temp = current.getNext();
        Node newNode = new NodeImpl(element, temp);
        current.setNext(newNode);
        size++;
        return true;
      }
      //otherwise, move pointer to next value and see if new i relates to my index
      else { current=current.getNext(); i++; }
    }
    return true;
  }

  public int find (double element) {
    Node current = head;
    int index = 0;
    while(current != null) {
      if(current.getValue() == element) { return index; }
      index++;
      current = current.getNext();
    }
    return -1;
  }

  private void insLast (double element) {
  // adds always to end of the list, always extends the list
  // and makes the size go up by one
  // this is a helper method, not part of interface List
    Node newNode = new NodeImpl(element, null);
    if(isEmpty()) { head=newNode; tail=newNode; size++; } 
    else { tail.setNext(newNode); tail=newNode; size++; }
  }

  public String toString() {
  // creates String representation of the list
    if (this.size==0) { return "[empty]"; }
    String list = "";
    Node current = head;
    while(current != null) {
      if(current.getNext() == null) { list+= current.getValue();}
      else { list += current.getValue() + " -> "; }
      current = current.getNext();
    }
    return list;
  }
}
