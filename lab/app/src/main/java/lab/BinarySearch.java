package lab;
 
 public static int binarySearch(int data[] int value){  
   int first = 0, last = data.length-1; 
   int mid = (first + last)/2;  
   while( first <= last ){  
      if ( arr[mid] < value ){  
        first = mid + 1;     
      } else if ( arr[mid] == value ){  
        return mid;  
        break;  
      } else {  
         last = mid - 1;  
      }  
      mid = (first + last)/2;  
   }  
   if ( first > last ){  
        return -1;  
   }  
 }  


