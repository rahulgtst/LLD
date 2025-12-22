import java.util.*;

public class Main
{
	public static void main(String[] args) {
		System.out.println("LRU Cache Implementation");
		
		try {
    		LRUCache lruCache = new LRUCache(2);
    		lruCache.put(1, 1);
    		lruCache.put(2, 2);
    		System.out.println("Value for key 1: " + lruCache.get(1));
    		lruCache.put(3, 3);
    		System.out.println("Value for key 2: " + lruCache.get(2));
    		lruCache.put(4, 4);
    		System.out.println("Value for key 1: " + lruCache.get(1));
    		System.out.println("Value for key 3: " + lruCache.get(3));
    		System.out.println("Value for key 4: " + lruCache.get(4));
		} catch(Exception e) {
		    System.out.println("Error in LRU Cache Implementation: " + e.getMessage());
		}
	}
}

class Node {
    private int key;
    private int val;
    
    Node prev;
    Node next;
    
    Node() {
        key = -1;
        val = -1;
        prev = null;
        next = null;
    }
    
    Node(int k, int v) {
        key = k;
        val = v;
        prev = null;
        next = null;
    }
    
    public int getKey() {
        return key;
    }
    
    public int getVal() {
        return val;
    }
    
    public void setVal(int v) {
        val = v;
    }
}

class LRUCache {
    
    private Node head;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> cache;
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public LRUCache(int c) {
        capacity = c;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        insertAtFront(node);
        return node.getVal();
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.setVal(value);
            remove(node);
            insertAtFront(node);
            return;
        }
        if(cache.size() >= capacity) {
            Node lruNode = tail.prev;
            int lruKey = lruNode.getKey();
            remove(lruNode);
            cache.remove(lruKey);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insertAtFront(node);
    }
}
