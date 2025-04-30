 public class MedianFinder { //O(log n ) solution: PriorityQueue
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    public MedianFinder() {
        left=new PriorityQueue<>((a,b)->b-a);//MaxHeap
        right=new PriorityQueue<>();//MinHeap
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(left.isEmpty() || num<=left.peek()){
            left.add(num);
        }else{
            right.add(num);
        }//Balance the difference
        if(left.size()>right.size()+1){
            right.add(left.remove());
        }else if(right.size()>left.size()){
            left.add(right.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())/2.0;
        }else{
            return left.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

//  public class MedianFinder { //O(nlog n ) solution: Sort and find middle
//     private List<Integer> store;

//     public MedianFinder() {
//         store = new ArrayList<>();
//     }

//     // Adds a number into the data structure.
//     public void addNum(int num) {
//         store.add(num);
//     }

//     // Returns the median of current data stream
//     public double findMedian() {
//         Collections.sort(store);
//         int n = store.size();
//         if (n % 2 == 1) {
//             return store.get(n / 2);
//         } else {
//             return (store.get(n / 2 - 1) + store.get(n / 2)) / 2.0;
//         }
//     }
// }