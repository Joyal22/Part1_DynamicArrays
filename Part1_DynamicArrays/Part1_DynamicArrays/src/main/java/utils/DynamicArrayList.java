package utils;

/**
 *
 * @author michelle
 */
//
public class DynamicArrayList {
    private String[] arr; //creating an array
    private int count; // number of elements stored in array
    private static int cap = 10; // initial capacity
    private int exp; //expantion factor for growing the array

// Default constructor initializes the array with the default capacity
    public DynamicArrayList(){
        this.arr = new String[cap];
        count = 0;
    }
 // Constructor that allows specifying the expansion factor
    public DynamicArrayList(int exp) throws IllegalAccessException {
        if (exp <= 1) {
            throw new IllegalAccessException("expantion must be greater than 1");
        }
        this.exp = exp;
    
    }
// Method to return the number of elements currently stored in the array
    public int Size() {
        return count;
    }
// Method to get the element at a specified position
    public String get(int pos) {
        if (validate(pos) == false)
            throw new IndexOutOfBoundsException("Invalid pos: " + pos);

        else {
            return arr[pos];
        }
    }

    private boolean validate(int pos) {
// Method to validate if a position is within bounds
        if (pos < 0 || pos > count) {
            return false;
        } else {
            return true;
        }
    }
   // Method to find the index of a given element
    public int indexOf(String word) {

        for (int i = 0; i < count; i++) {
            if (arr[i] != null || word != null) {
                if (arr[i].equals(word)) {
                    return i;
                }

            }
        }
        return -1;
    }
// Method to add an element to the end of the array
    public boolean add(String word) {
        if (count == arr.length) {
            growing();
        }
        arr[count] = word;// Add the new element at the end
        return true;

    }
 // Method to grow the array when it's full
    private void growing() {
        int newcap = count+exp;
        String[] grownarr = new String[newcap];
     System.arraycopy(arr, 0, grownarr, 0, count);
        arr = grownarr;
        cap = newcap;
    }
// Method to add all elements from another array to the end of this array
    public void addAll(String [] arrgiven){
 String newarr[] = new String[cap+arrgiven.length];
 System.arraycopy(arr,0,newarr,0,cap);
 System.arraycopy(arrgiven,0,newarr,count,cap+arrgiven.length);
 arr = newarr;
 
    }
// Method to remove a specified element from the array
    public boolean remove(String elm) throws IllegalAccessException{
if (elm == null){
    throw new IllegalAccessException("element is null");

}

for (int i=0; i<count;i++){
    if (arr[i].equals(elm)){

        for(int j =i; j<count-1;j++){
            arr[j]=arr[j+1];
        }
        count--;
        return true;
    }
}
return false;
    }
// Method to create a clone of the array
    public String[] clone(){
 String clonedarr[]= new String[count];
 System.arraycopy(this.arr, 0, clonedarr, 0, count);
 
 return clonedarr;
    }

}
