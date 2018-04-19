# Map
K-V存储方式

* HashMap
  
  Entry[],数组链表的存储方式

* Hashtable

  Entry[],数组和链表的存储方式，操纵方法使用synchronized声明

* ConcurrentHashMap
  
  使用可重入锁，分段同步

* LinkedHashMap 
  
  继承HashMap，重新实现Entry[],使用数组和双向链表存储
  
* WeakHashMap


## HashMap 
非线程安全，无序

## LinkedHashMap
非线程安全，有序

## HashTable
线程安全，无序

## ConcurrentHashMap
线程安全，可重入锁

## WeakHashMap
非线程安全，弱引用





