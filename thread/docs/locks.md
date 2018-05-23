# java.util.concurrent.locks

## Interface

- java.util.concurrent.locks.Condition

- java.util.concurrent.locks.Lock

- java.util.concurrent.locks.ReadWriteLock

### java.util.concurrent.locks.Condition
条件等待，是`java.lang.Object`的`wait/notify`的另一种实现。notify/notifyAll是随机/无差别通知。
而Lock可以创建多个`Condition`等待条件。通知时，只有当前线程等待的条件发出通知，该线程才会被收到通知消息。

### java.util.concurrent.locks.Lock
线程锁、可创建多个等待条件，供不同的线程使用，接受不同的条件通知。

- `void lock();`

    获取锁，获取不到锁则进入锁阻塞状态

- `boolean tryLock();`

    尝试获取锁，获取不到锁，则继续执行。

- `boolean tryLock(long time, TimeUnit unit) throws InterruptedException;`
    
    

- `void unlock();`

    释放锁。

- `void lockInterruptibly() throws InterruptedException;`

- `Condition newCondition();`

    生成一个等待条件

### java.util.concurrent.locks.ReadWriteLock
读写锁、可以生成两把锁，一个只用于读取数据，一个用于操作数据。
写互斥
    - 只有有一个线程获取到写入锁，那么其他线程就无法获取到锁。
    - 如有有一个线程获取到了读取锁，那么其他线程无法获取写入锁
    - 一个线程已经获取了读取锁，其他线程可以继续获取读取锁。
   
## Class

### java.util.concurrent.locks.ReentrantLock
可重入锁，是`java.util.concurrent.locks.Lock`具体实现。


### java.util.concurrent.locks.ReentrantReadWriteLock
可重入读写锁，是`java.util.concurrent.locks.ReadWriteLock`具体实现。





