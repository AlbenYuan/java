# 线程同步

## volatile
可见，声明变量时使用。保证变量的可见性。

## synchronized
同步，使用该关键字声明的变量、方法、代码块，在实际的代码执行中最多有一个线程使用。使用的对象所不可为`null`。

### 使用

```java
public class Entity{
  
    public static synchronized Object obj = new Object();
    
    private synchronized Object obj = new Object();
    
    private synchronized static Object staticLock = new Object();
      
    private Object lock = new Object();
    
    public synchronized void action(){}
            
    public static synchronized void staticAction(){}
    
    public static void staticBlock(){
        synchronized (staticLock){
            
        }
    }
    
    public void block(){
        synchronized (lock){
            
        }
    }
}
```

- 变量
  
  - 静态变量
  - 属性
  - 局部变量
   
  使用的锁是该变量的锁。 如果局部变量，不会被多个线程操作。不建议对其`synchronized`声明。

- 方法

  - 静态方法
  
  - 非静态方法

  静态方法使用的是该类的类对象的锁，即该类对应`java.lang.Class`实例、`Entity.class`；非静态方法使用的是当前对象的锁，即`this`。
   
  
- 代码块

  - 方法中的代码快
    
### 特点

- 可重入

- 不可继承

- 当前对象锁

    方法前的`synchronized`使用的是当前对象的锁，静态方法前使用的是当前类类对象的锁

- 自动操作

    自动获取，自动释放，异常时释放全部锁
