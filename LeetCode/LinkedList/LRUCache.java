class LRUCache {
	HashMap<Integer, DoubleLinkNode> cache;
    int capacity;
    int count;
    DoubleLinkNode head , tail;

    class DoubleLinkNode{
        int key;
        int value;
        DoubleLinkNode pre;
        DoubleLinkNode next;
        public DoubleLinkNode (int key, int value){
            this.key = key;
            this.value = value;
        }
        DoubleLinkNode(){
            this.key = 0;
            this.value = 0;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        cache = new HashMap<>();
        // head and tail are both dummy node
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleLinkNode node = cache.get(key);
        if(node == null)
            return -1;
        else{
            // move to the first, because we just used it
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        // if cache does not have it
        if(!cache.containsKey(key)){
            DoubleLinkNode node = new DoubleLinkNode(key, value);
            cache.put(key,node);
            insertHeadNode(node);
            count++;
            if(count>capacity) {
            DoubleLinkNode tail = removeTail();
            cache.remove(tail.key);
            count--;
            }
        }
        else {
            //move it to head
            DoubleLinkNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    // add
    private void insertHeadNode(DoubleLinkNode node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }

    private void moveToHead(DoubleLinkNode node) {
        removeNode(node);
        insertHeadNode(node);
    }

    private void removeNode(DoubleLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DoubleLinkNode removeTail() {
        DoubleLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }
}
