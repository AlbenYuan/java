# 线程锁

## java.util.concurrent.locks.Lock
Lock接口定义了锁对象的一些接口。

### 接口

- `void lock();`

    获取锁，获取不到锁则进入锁阻塞状态

- `boolean tryLock();`

    尝试获取锁，获取不到锁，则继续执行。

- `boolean tryLock(long time, TimeUnit unit) throws InterruptedException;`
    
    

- `void unlock();`

    释放锁。

- `void lockInterruptibly() throws InterruptedException;`

- `Condition newCondition();`



