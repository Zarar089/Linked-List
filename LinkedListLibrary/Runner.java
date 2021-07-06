/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListLibrary;

/**
 *
 * @author Zarar Mahmud
 */
import java.util.ArrayList;
import java.util.Collection;

class ArrayListWrapper<T> extends ArrayList{

    ArrayListWrapper() {
        super();
    }
    
    ArrayListWrapper(Collection<?> c) {
        super(c);
    }
    
    ArrayListWrapper(int i) {
        super(i);
    }
    
    
    
    public void printlist(){
        for(int i=0;i<this.size();i++){
            System.out.print(this.get(i)+" ");
        }
        System.out.println("");
    }
}
public class Runner {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList<Integer> List1 = new LinkedList<>();
        ArrayListWrapper<Integer> aList1 = new ArrayListWrapper<>();
        
        List1.add(5);
        List1.add(7);
        List1.add(6);
        List1.add(8);
       
        List1.printList();
        
        List1.deleteVal(7);
        List1.printList();

       
        ArrayList<Integer> list2 = new ArrayList<>();
        
        list2.add(10);
        list2.add(25);
        list2.add(7);
        
        List1.addAllAtIndex(2, list2);
        List1.printList();
         
        Integer[] ListToArr = new Integer[List1.getSize()];
        
        List1.toArray(ListToArr);
        
        for(int i=0;i<List1.getSize();i++){
            System.out.println(ListToArr[i]);
        }
            
       
    }
}
