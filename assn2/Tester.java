package assn2;

public class Tester {

    public void set ( List ls ) {
        System.out.println("== Test of set op ==========");
        ls.clear();
        ls.ins(0,3.0);
        System.out.println(ls.set(0,10.0));
        System.out.println(ls);
        ls.set(0,11.1); ls.set(1,12.2);
        System.out.println(ls);
        System.out.println(ls.set(14,111.1));
        System.out.println(ls.set(3,101.01));
        System.out.println(ls);
        return;
    }
double[] hello = {10.0, 12.2, 60, 111.1, 80};
    public void bubbleIns ( List hello) {
        System.out.println("== Test of bubbleIns op ==========");
        hello.clear();
        System.out.println(hello.bubbleIns(10.0));
        System.out.println(hello);
        hello.bubbleIns(11.1); hello.bubbleIns(12.2);
        System.out.println(hello);
        System.out.println(hello.bubbleIns(111.1));
        System.out.println(hello.bubbleIns(101.01));
        System.out.println(hello);
        return;
    }

    public void ins ( List ls ) {
      System.out.println("== Test of ins op ==========");
      ls.clear();
      System.out.println(ls.ins(0,10.0)); 
      System.out.println(ls);
      ls.ins(0,11.1); ls.ins(1,12.2);
      System.out.println(ls);
      System.out.println(ls.ins(14,111.1));
      System.out.println(ls.ins(3,101.01));
      System.out.println(ls); 
      return;
   }
   
   public void rem (List ls) {
     System.out.println("== Test of rem op ==========");
     ls.clear();
     System.out.println(ls.rem(0)); 
     System.out.println(ls);
     ls.ins(0,11.1); ls.ins(1,12.2); ls.ins(2,13.3);
     System.out.println(ls);
     System.out.println(ls.rem(0));
     System.out.println(ls.rem(1));
     System.out.println(ls); 
     System.out.println(ls.size());
     ls.ins(0,14.4); ls.ins(1,17.7);
     System.out.println(ls);
     System.out.println(ls.rem(1));
     System.out.println(ls); 
     System.out.println(ls.rem(100));
     System.out.println(ls);
     return;
   }
   
   public void get (List ls) {
     System.out.println("== Test of get op ==========");
     ls.clear();
     System.out.println(ls.get(0)); 
     System.out.println(ls);
     ls.ins(0,11.1); ls.ins(1,12.2); ls.ins(2,13.3);
     System.out.println(ls);
     System.out.println(ls.get(0));
     System.out.println(ls.get(1));
     System.out.println(ls.get(100));
     System.out.println(ls); 
     System.out.println(ls.size());
     ls.ins(0,14.4); ls.ins(1,17.7);
     System.out.println(ls);
     System.out.println(ls.get(1));
     System.out.println(ls); 
     System.out.println(ls.get(-100));
     System.out.println(ls);
     return;
   }
   
   public void find (List ls) {
     System.out.println("== Test of find op =========");
     ls.clear();
     System.out.println(ls.find(12.2));
     ls.ins(0,11.1);
     System.out.println(ls.find(11.1));
     System.out.println(ls.find(12.2));
     ls.ins(0,22.2); ls.ins(1,33.3); ls.ins(0,44.4);
     System.out.println(ls.find(33.3));
     System.out.println(ls.find(11.1));
     System.out.println(ls.find(-5.5));
     ls.clear();
     System.out.println(ls.find(11.1));
     return;
   }

    public void findLast (List ls) {
        System.out.println("== Test of findLast op =========");
        ls.clear();
        System.out.println(ls.findLast(12.2));
        ls.ins(0,11.1);
        System.out.println(ls.findLast(11.1));
        System.out.println(ls.findLast(12.2));
        ls.ins(1,22.2); ls.ins(2,33.3); ls.ins(3,33.3);
        System.out.println(ls.findLast(33.3));
        System.out.println(ls.findLast(11.1));
        System.out.println(ls.findLast(-5.5));
        ls.clear();
        System.out.println(ls.findLast(11.1));
        return;
    }

   public void isEmpty (List ls) {
      System.out.println("== Test of isEmpty op =======");
      ls.clear();
      System.out.println(ls.isEmpty());
      ls.ins(0,1.1);
      System.out.println(ls.isEmpty());
      ls.ins(0,2.2);
      System.out.println(ls.isEmpty());
      ls.rem(0);
      System.out.println(ls.isEmpty());
      ls.rem(100);
      System.out.println(ls.isEmpty());
      ls.rem(0);
      System.out.println(ls.isEmpty());
      return;
   }
   
   public void contains(List ls) {
      System.out.println("== Test of contains op ======");
      ls.clear();
      return;
   }
   
   public void size (List ls) {
      System.out.println("== Test of size op ==========");
      ls.clear();
      System.out.println(ls.size());
      ls.ins(0,1.1); System.out.println(ls.size());
      ls.ins(0,2.2); System.out.println(ls.size());
      for (int i=2; i<20; i++) { ls.ins(i,i*1.1); }
      System.out.println(ls.size());
      for (int i=0; i<5; i++) { ls.rem(0); }
      System.out.println(ls.size());
      ls.clear();
      System.out.println(ls.size());
      return;
   }
   
   public void clear (List ls) {
      System.out.println("== Test of clear op =========");
      System.out.println(ls.size());
      double n = ls.get(0);
      System.out.println(ls.find(n));
      ls.clear();
      System.out.println(ls.size());
      System.out.println(ls.get(0));
      System.out.println(ls.get(100));
      System.out.println(ls.find(n));
      return;
   }
    /*
    public boolean inSort ( double elt ) {

        if (this.size == 0) {
            ins(0, elt);
            return true;
        }

        if (elt < head.getValue()) {
            ins(0, elt); return true;
        }

        Node current = head;
        int index = -1;

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
    } */
}

