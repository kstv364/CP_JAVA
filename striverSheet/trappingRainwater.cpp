long getTrappedWater(long *arr, int n){
    // Write your code here.
    
    // two pointer approach
    // formula min(leftmax, rightmax) - a[i];
    
    // move right if arr[l] < arr[r] -> this guarantees for all subsequent i there is a building of length >= arr
    
    int l = 0, r = n-1;
    long sum = 0 ;
    long leftmax = 0, rightmax = 0;
    while(l<=r){
        if(arr[l] <= arr[r]){
            if(arr[l] > leftmax) leftmax = arr[l]; // this is the max
            else /// collect
                sum += leftmax - arr[l]; // there is another of heigh arr[r] >= leftmax
            
            l++;
        }
        else{
             if(arr[r] > rightmax) rightmax = arr[r]; // this is the max
            else /// collect
                sum += rightmax - arr[r]; // there is another of heigh arr[r] >= 
            r--;
        }
    }
    return sum;
}
