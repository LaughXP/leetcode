//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写
//入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class _146_LruCache {
  public static void main(String[] args) {
      LRUCache solution = new _146_LruCache().new LRUCache(2);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
      Node head, tail;
      int capacity, size;
      Map<Integer, Node> map;
      public LRUCache(int capacity) {
          this.capacity = capacity;
          map = new HashMap<>(capacity);
          head = new Node(0,0);
          tail = new Node(0,0);
          head.next = tail;
          tail.pre = head;
      }

      class Node {
          int k,v;
          Node pre,next;
          boolean remove;
          Node(int k, int v) {
              this.k = k;
              this.v = v;
          }
      }

      void remove(Node p) {
          p.next.pre = p.pre;
          p.pre.next = p.next;
          size--;
          p.remove = true;
      }
      void insertAfterHead(Node p, boolean put) {
          p.next = head.next;
          p.pre = head;
          head.next.pre = p;
          head.next = p;
          size++;
          p.remove = false;
          if(put) {
              map.put(p.k, p);
          }
      }
      Node getNode(int k) {
          return map.get(k);
      }
      public int get(int k) {
          Node p = getNode(k);
          if(p == null || p.remove) {
              return -1;
          }
          remove(p);
          insertAfterHead(p, false);
          return p.v;
      }
      public void put(int k, int v) {
          Node p = getNode(k);
          if(p == null) {
              p = new Node(k ,v);
              insertAfterHead(p, true);
              if(size > capacity) {
                  remove(tail.pre);
              }
          } else {
              p.v = v;
              if(p.remove) {
                  insertAfterHead(p, false);
                  if(size > capacity) {
                      remove(tail.pre);
                  }
              } else {
                  remove(p);
                  insertAfterHead(p, false);
              }
          }
      }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}