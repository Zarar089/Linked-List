/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListLibrary;

/**
 *
 * @author Zarar Mahmud
 *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class Node<T> {
    T data;
    Node<T> next;
    
    Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    public void setData(T data)
    {
        this.data = data;
    }
      
    public void setNext(Node<T> next)
    {
        this.next = next;
    }
      
    public T getData()
    {
        return data;
    }
      
    public Node<T> getNext()
    {
        return next;
    }
}

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int listSize;
        
    LinkedList() {    
        head = null;
        listSize = 0;
    }
    
    public Node<T> getHead(){
        return head;
    }
    public void add(T data){
        
        Node<T> node = new Node<>(data);
        
        if(head==null){
            head = node;
        }else{
            
            Node<T> curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next=node;
            
            this.listSize++;
        }
        
        
    }
    
    public void addAtIndex(T data,int pos){
        
        if(pos>listSize-1){
            System.out.println("Position larger than Linked List");
            return;
        }else{
            if(pos==0){
                this.addAtStart(data);
            }else{
                Node<T> node = new Node<>(data);
                Node<T> curr = head;
                for(int i=0;i<pos-1;i++){
                    curr=curr.next;
                }
                Node<T> temp = curr.next;
                curr.next = node;
                node.next = temp;
            
                this.listSize++;
            }
        }  
        
  
    }
    
    public void addAtStart(T data){
        Node<T> node = new Node<>(data);
        
        node.next=head;
        head = node;
        
        this.listSize++;
        
    }
    
    public void addAll(Collection<? extends T> c){
        for(T data:c){
            this.add(data);
        }
    }
    
    public void addAllAtIndex(int index,Collection<? extends T>c){
        for(T data:c){
            this.addAtIndex(data, index);
            index++;
        }
    }
    
    public void delete(int pos){
        if (head == null)
            return;
       
        Node<T> curr = head;

        if (pos == 0)
        {
            head = head.next;   
            return;
        }
        
        for (int i=0; curr!=null && i<pos-1; i++)
            curr = curr.next;
        
        if (curr == null || curr.next == null)
            return;
        
        Node<T> temp = curr.next.next;
        curr.next = temp;
        
    }
    
    public void deleteVal(T key){
        int indx=0;
        for(T data:this){
            if(data==key){
                delete(indx);
                return;
            }
            indx++;
        }
    }
    
    public void deleteAtEnd(){
        
        Node<T> curr = head;
        while(curr.next.next!=null){
            curr = curr.next;
        }
        curr.next = null;
        this.listSize--;
    }
    
    public void removeAll(Collection<?> c){
        int indx=0;
        for(T data:this){
            if(c.contains(data)){
                this.deleteVal(data);
            }
            indx++;
        }
    }
    
    public void removeRange(int strtIndx,int endIndx){
        Node low = null;
        Node curr = head;
        for(int i=0;i<=endIndx+1;i++){
            if(i==strtIndx-1){
                low = curr;
            }
            if(i==endIndx+1&&low!=null){
                low.next=curr;
                break;
            }
            curr=curr.next;
        }
    }
    
    public void retainAll(Collection<?> c){
        int indx=0;
        for(T data:this){
            if(!c.contains(data)){
                this.deleteVal(data);
            }
            indx++;
        }
    }
    
    public T get(int index){
        for(T data:this){
            if(index==0){
                return data;
            }else{
                index--;
            }
        }
        return null;
    }
   
    
    public void printList(){
        Node curr = head;
        while(curr.next!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
    
    @Override
    public Iterator<T> iterator(){
        return new ListIterator<>(this);
    }
   
    
    public int getSize(){
        return this.listSize;
    }
    
    public boolean isEmpty(){
        return this.getSize()==0;
    }
    
    public void clear(){
        while(!isEmpty()){
            this.deleteAtEnd();
        }
    }
    
    public boolean contains(T key){
        for(T data:this){
            if(data.equals(key)){
                return true;
            }
        }
        return false;
    }
    
    public int indexOf(T key){
        int indx = 0;
        for(T data:this){
            if(data == key){
                return indx;
            }else{
                indx++;
            }
            
        }
        return -1;
    }
    
    public int lastIndexOf(T key){
        int last_indx = -1;
        int curr_indx =  0;
        for(T data:this){
            if(data==key&&curr_indx>last_indx){
                last_indx=curr_indx;
            }
            curr_indx++;
        }
        return last_indx;
    }
    
    
    public void set(int index,T data){
        Node<T> curr = head;
        while(index!=0){
            curr=curr.next;
            index--;
        }
        curr.data=data;
    }
    
    public ArrayList<T> subList(int strtIndx,int endIndx){
        ArrayList<T> c = new ArrayList<>();
        int index=0;
        for(T data:this){
            if(index>=strtIndx && index<=endIndx){
                c.add(data);
            }
            index++;
        }
        return c;
    }
    
    public Object[] toArray(){
        Object[] obj = new Object[this.listSize];
        int index=0;
        for(T data:this){
            obj[index]=data;
            index++;
        }
        return obj;
    }
    
    public void toArray(T[] a){
        int index=0;
        for(T data:this){
            a[index]=data;
            index++;
        }
    }
        
}

class ListIterator<T> implements Iterator<T> {
    Node<T> current;
      
    // initialize pointer to head of the list for iteration
    public ListIterator(LinkedList<T> list)
    {
        current = list.getHead();
    }
      
    // returns false if next element does not exist
    @Override
    public boolean hasNext()
    {
        return current != null;
    }
      
    // return current data and update pointer
    @Override
    public T next()
    {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
      
    // implement if needed
    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
