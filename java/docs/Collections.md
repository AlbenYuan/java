# Collection



## 分析思路

开发人员在使用线程的时候一般都是初始化、存值、取值、操作值。涉及到多线程时还会考虑线程安全的问题。针对这些操作，我将对集合的分析从以下几个纬度进行分析：
- 如何初始化 (How to Initialize)
  - 初始容量
  - 初始化存储容器
  
- 如何存值 (How to Save)
  - 以什么方式存储

- 如何取值 (How to Get)
  - 如何定位值位置
- 如何扩容 (How to Increase Capacity)
  - 什么时候扩容
  - 怎么进行扩容
  
- 如何支持多线程 (How to Support Threads)
  - 多线程是否安全
  - 如何支撑多线程安全的

## 数据结构

- 数组
- 链表
- 树
- 图
- 散列表



## Java中的集合
java中的存储数据的的集合主要有：Array、List、Map、Set

### Array
严格的来说，数组不属于Java的集合范畴。其使用连续的存储空间，存储固定数量的同类型的元素。
#### 如何初始化
- 声明

  ```java
  int[] array; // 推荐使用，其书写格式与其他类型的声明格式一致：数据类型 变量名，如：Object obj;
  ```
  ```java
  int array[]; 
  ```
  ```java
  int[] array[];
  ```

- 初始化

  ```java
  array = new int[10];  // 一个长度为10的数组，其可以存放10个整型
  ```
  ```java
  array = {1,2,3,4,5,6,7,8,9,0};  // 一个长度为10的数据，其何以存放10个整型
  ```

以上声明的代码中的`int`可以替换为其他基本数据类型、类、抽象类、接口

#### 如何存值
数组是使用连续的存储空间进行存储数据，其操作有虚拟机完成。开发者只需取值赋值即可。赋值如下：
```java
int index = 0; 
array[index] = 1;  // index >=0, index < array.length 
```
#### 如何取值
数据使用下标进行取值，下标范围:[0, array.length-1]
```java
int i = array[0]; // 获取第一个元素的值 
```

#### 如何支持多线程
数组本身是非线程安全的，使用`synchronized`或者`volatile`做相应控制。


### List

### Map

### Set
