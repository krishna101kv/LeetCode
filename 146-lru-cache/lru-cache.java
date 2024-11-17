class LRUCache {

    class DllNode {
        int key, val;
        DllNode prev, next;

        DllNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int maxSize;
    private int currentSize = 0;
    private final Map<Integer, DllNode> cache = new HashMap<>();
    private final DllNode head = new DllNode(-1, -1);
    private final DllNode tail = new DllNode(-1, -1);

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DllNode node = cache.get(key);
            remove(node);
            addToTail(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DllNode node = cache.get(key);
            remove(node);
            node.val = value;
            addToTail(node);
        } else {
            if (currentSize == maxSize) {
                DllNode lru = head.next; // Least Recently Used Node
                remove(lru);
                cache.remove(lru.key);
            } else {
                currentSize++;
            }
            DllNode newNode = new DllNode(key, value);
            cache.put(key, newNode);
            addToTail(newNode);
        }
    }

    private void remove(DllNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(DllNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */