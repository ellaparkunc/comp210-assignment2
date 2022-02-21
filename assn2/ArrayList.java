/*
* Steps:
* 1. read through ins and rem
* 2. read about set & code
* 3. ask questions
* 4. repeat
* 5. write testers
* 6. ask q's*/

package assn2;

public class ArrayList implements List {
   // instance variables
   private double[] elts;
   private int size = 0;
   private int MAX = 1000;

   // default constructor makes an array with MAX elements
   public ArrayList ( ) {
      this.elts = new double[this.MAX];
      this.size = 0;
   }
   
   // alternate constructor allows specific array size to be created
   public ArrayList (int MAX) {
      this.elts = new double[MAX];
      this.size = 0;
      this.MAX = MAX;
   }

	
//================================================================= 
  // You will implement the 4 methods below for assignment 2.
  // IMPORTANT: Note that the methods are provided with default 
  // return values (e.g., "-1" for findLast) so that the code will
  // initially compile.  You should remove the default return value
  // when you implement the methods.
//=================================================================
    
   
  public boolean set ( int index, double element ) {
      //See List.java for a description of the method's behavior and examples.
      //Hint: Ask yourself how this is different from the "ins" method.
      //Hint: Remember that we start indexing with 0 rather than 1.

      /*Your code here */
      if (index<0 || index>size || index>=this.MAX) { return false; }

      this.elts[index] = element;
      return true;
	  /* Make the value stored in list at position "index" be "element".
     This differs from ins in that we do not open up space for
     a new element... we stomp over (i.e., overwrite) the value already there.
     Return false if the index is not valid, and
     return true otherwise. The "set" operation should only
     ever be performed on a valid index within the list as determined
     by "size".
     */
  /*Example:  For example, if the list is
	  8.2, -7.3, 3.4, 5.0, 3.4, 2.1
      then after calling "set(2, 1.9)" the result would be
	  8.2, -7,3, 1.9, 5.0, 3.4, 2.1
    */
  }
      
  public int findLast ( double element ) {
    //See List.java for a description of the method's behavior and examples.
    //Hint: Make sure you understand how this is different from find
	  
    /*Your code here */
      int location = -1;
      //from the last item (item one less than size) to 0,
      for (int i=(size-1); i>=0; i--) {
          //when you come across the place in the list with the element,
          //set location equal to the index of that place
          if (this.elts[i]==element) { location=i; break; }
          //and STOP excecuting code
      }
      return location;

      /* Like find, except here we locate the last occurrence ("find" locates
     the first occurrence)
     return -1 if the element is not in the list (since -1 is not a valid index)
     otherwise return the largest position in the list where element is found
     */
  /* Example:  Suppose we have the following list:
        8.2, -7.3, 3.4, 5.0, 3.4, 2.1
    findLast(3.4) would return "4".  However, findLast(1.2) would return "-1".
    */

  }

  public boolean inSort ( double elt ) {
    //See List.java for a description of the method's behavior and examples.

    /*Your code here */
      //so i'm going to move through the list from 0 to not reaching size
      //and say if both element is greater than i and less than i+1,
      //insert element here (using ins)
      int index = -1;

      for (int j= 0; j<this.size; j++ ) {
          if (elt>= this.elts[j] && elt< this.elts[j+1]) {
              index= j +1; break;
          } else if (elt < this.elts[0]) {
              index = 0;
          } else if (elt > this.elts[this.size-1]) {
              index = this.size-1;
              //question: how do i get this to say false if it doesn't work
              //and make sure it doesn't crash when it doesn't work?
          }
      }
      //ins
      //i starts at array size and goes down by one until it's equal to max
      for (int i=this.size; i>=index; i--) {
          this.elts[i+1] = this.elts[i];
      }
      this.elts[index] = elt;
      this.size++;
      return true;

      /* A form of ins operations, but here we do not insert based on index;
     rather we look through the list and find the first place where there
     are two element values that "straddle" the element we are adding...
     meaning we find a spot in the list where one element is <= to the item
     we are adding, and the next element (next higher index) is > the one we
     are adding. The new element goes between these two.
     If the head element is > the one we are adding, then the new element goes
     at the head; if all elements in the list are <= the one we are adding, the
     new element goes at the end.
     return true if the add succeeds (it will almost always succeed); return false
     if for some reason the insert cannot happen (such as in Array Implementation,
     the array has no room for another element).  If the list is empty, just
     insert the element into the list.

     Example:  list is  3.1, 5.5, 18.2, 23.01
     inSort(7.0)  makes this list:  3.1, 5.5, 7.0, 18.2, 23.01

     Example: list is 3.1, 5.5, 18.2, 23.01
     inSort(1.5) makes this list: 1.5, 3.1, 5.5, 18.2, 23.01

     Example: list is 3.1, 5.5, 18.2, 23.01
     inSort(55.2) makes this list: 3.1, 5.5, 18.2, 23.01, 55.2

     Also note that we do not assume the list is sorted when we start looking
     for a "straddle" so here is a strange (but correct) example

     Example: list is 1.2, 5.5, 17.03, 12.8, 6.6
     inSort(19.0) makes this list:  1.2, 5.5, 17.03, 12.8, 6.6, 19.0

     Note: if we use only inSort to add items to a list (dont use ins)
     then the list will be in increasing sorted order at all times
     */
  }
   
  public boolean bubbleIns  ( double elt ) {

      //See List.java for a description of the method's behavior and examples.
      //Hint: Do any of the methods you're already given help?

      /*Your code here */
      //find first: finds the first instance. if found,
      //remove item from list
      //ins item @ index 0
      //move everything else down by one (ins)

      //if not found,
      //put item at index 0
      //move everything down by one (ins)


      int location = -1;
      //from 0 to one less than size,
      for (int i = 0; i < size; i++) {
          //when you come across the place in the list with the element,
          //set location equal to the index of that place
          if (this.elts[i] == elt) {
              //remove item from list
              rem(i);
              //move everything down one & ins @ line 0
              ins(0, elt);
              return true;
          }

      }
      //no need for else statement here, bc if it goes through the loop w/o returning, elt isn't in there
      //do the exact same thing
      //move everything down one
      ins(0, elt);
      return true;
      //how to write where it may return false???
      //if (this.elts[0] != elt) {
          //return false;
      //}
  }
      /* Another form of ins operation.  In this one, we look through the list
     to see if the element we want to add is already in the list.  If it is,
     we take the first occurrance of it and move that element to the head of
     the list.  If the element we want to add is NOT already in the list then
     we put the new element at the head.  The net effect on size is this: if
     the element is already there, the size does not change; if the element is
     not already there, then we add it as a new head so the size goes up one.
     Return true if the add succeeds (it almost always will); return false if
     for some reason the add cannot happen (such as in Array Implementation,
     the array has no room for a new element to be stored).  If the list is
     empty, just insert the element.

     example: list is 11.3, 45.1, -5.6, 17.3
     bubbleIns(21.0) makes this list:  21.0, 11.3, 45.1, -5.6, 17.3

     list is 11.3, 45.1, -5.6, 17.3
     bubbleIns(-5.6) makes this list: -5.6, 11.3, 45.1, 17.3

     list is 11.3, 45.1, -5.6, 17.3, 45.1, 11.3
     bubbleIns(45.1) makes this list: 45.1, 11.3, -5.6, 17.3, 45.1, 11.3
    */

    //Remove this when you implement the method!

	
   /* Implementation given to you. Do not modify below this. */
   
	@Override
   public boolean ins(int index, double element) {
        /* standard list insert... go to the position in the list given by index,
     make room for the new element by moving elements at index and further
     up one location (to a higher index) so the new element goes in the
     "hole" that is opened
     */
        // if passed-in index is <0, >size, or greater than or equal to max, return false
      if (index<0 || index>size || index>=this.MAX) { return false; }
      //i starts at array size and goes down by one until it's equal to max
      for (int i=this.size; i>=index; i--) {
         this.elts[i+1] = this.elts[i];
      }
      this.elts[index] = element;
      this.size++;
      return true;
   }
   
	@Override
   public boolean rem(int index) {
        //remove
         /* go to location in the list given by index and move all elements further
     along down one position... so that the element in location index+1 is moved
     to index, index+2 is moved to index+1, etc.
     the element that was in location index is gone after the op completes
     */
      if (index>=size || index<0 || index>=this.MAX) { return false; }
      // i starts at index and increases by 1 till it's equal to size
      for (int i=index; i<size; i++) {
          //moves item back by one
         this.elts[i] = this.elts[i+1];
      }
      this.size--;
      return true;
   }
   
	@Override
   public int size() { return this.size; }
    /* returns the count of how many items are in the list
     */
   @Override
   public void clear() { this.size = 0; }
   
	@Override
   public boolean isEmpty() { return this.size == 0; }
    /* shorthand for is the list size() == 0
     */
	@Override
   public double get(int index) {
        /* return the element value stored in the list at location given by index
         */
      if (index<0 || index>=size || index>=this.MAX) { return Double.NaN; }
      return this.elts[index];
   }
	@Override
   public int find( double element ) {
        /* similar to contains, except that find returns the index of the item where
     element is stored; this locates the first such occurrance
     */
      int location = -1;
      //from 0 to one less than size,
      for (int i=0; i<size; i++) {
          //when you come across the place in the list with the element,
          //set location equal to the index of that place
         if (this.elts[i]==element) { location=i; break; }
      }
      return location;
   }
   
	@Override  
   public boolean contains ( double element ) {
        /* returns true if the given element is stored in some list item
         */
      boolean res = false;
      for (int i=0; i<size; i++) {
         if (this.elts[i]==element) { res = true; break; }
      }
      return res;
   }

   /* prints out list */
   public String toString() { 
     if (this.size==0) { return "[empty]"; }
     String res = ""; 
     for (int i=0; i<size; i++) {
       res = res+this.elts[i]+", ";
     } 
     return res;
   }
     
}
