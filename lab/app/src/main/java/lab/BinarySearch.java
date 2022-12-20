package lab;
 
 public class BinarySearch {
      public static int binarySearch(int data[], int value){  
        int first = 0, last = data.length-1; 
        int mid = (first + last)/2;  

        while( first <= last ){  
            if ( data[mid] < value )
              first = mid + 1;     
            else if (data[mid] == value)
              return mid;  
            else 
              last = mid - 1;

            mid = (first + last)/2;  
        }  

        return -1;  
      }
 }        