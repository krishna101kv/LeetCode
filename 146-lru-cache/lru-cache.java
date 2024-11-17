class LRUCache {
    class DllNode {
        int key, val;
        DllNode prev, next;

        DllNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Map<Integer, DllNode> cache = new HashMap<>();
    private final DllNode head = new DllNode(-1, -1);
    private final DllNode tail = new DllNode(-1, -1);
    private final int capacity;
    private int currentSize = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DllNode currentNode = cache.get(key);
            deleteNode(currentNode);
            addNodeAtTail(currentNode);
            return currentNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DllNode currentNode = cache.get(key);
            deleteNode(currentNode);
            currentNode.val = value;
            addNodeAtTail(currentNode);
        } else {
            if (currentSize == capacity) {
                DllNode lru = head.next;
                deleteNode(lru);
                cache.remove(lru.key);
                currentSize--;
            }
            DllNode newNode = new DllNode(key, value);
            addNodeAtTail(newNode);
            cache.put(key, newNode);
            currentSize++;
        }
    }

    private void deleteNode(DllNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeAtTail(DllNode node) {
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