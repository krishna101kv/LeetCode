class DLLNode{
    String url;
    DLLNode next;
    DLLNode prev;
    DLLNode(String url){
       this.url=url;
    }
}
class BrowserHistory {
    DLLNode head=null;
    DLLNode iterator=null;
    public BrowserHistory(String homepage) {
        head=new DLLNode(homepage);
        iterator=head;
    }
    
    public void visit(String url) {
        DLLNode newNode=new DLLNode(url);
        iterator.next=newNode;
        newNode.prev=iterator;
        iterator=iterator.next;
        return;
    }
    
    public String back(int steps) {
        while(iterator.prev!=null && steps>0){
            steps-=1;
            iterator=iterator.prev;
        }
        return iterator.url;
    }
    
    public String forward(int steps) {
        while(iterator.next!=null && steps>0){
            steps-=1;
            iterator=iterator.next;
        }
        return iterator.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */