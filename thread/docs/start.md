# Thread
线程

## 创建线程
无论使用什么方式使用线程都需要，完成以下三步
1. 定义执行体；
1. 创建线程```new Thread()```，不同的实现方式，在创建线程的时候会传入不同的参数；
1. 启动线程`thread.start()`。

### 实现方式
这里的实现方式，我的理解是指线程执行内容的实现方式。
1. 继承`java.lang.Thread`
    1. 定义：定义类[ExtendThread](./src/main/java/com/albenyuan/thread/ExtendThread.java)继承`java.lang.Thread`，
    并重写`run()`方法;
    1. 使用：
        ```java
       new ExtendThread().start();
       ```
1. 实现`java.lang.Runnable`
    1. 定义：定义类[RunnableThread](./src/main/java/com/albenyuan/thread/RunnableThread.java)，实现`java.lang.Runnable`接口，实现`run()`方法;
    1. 使用：
        ```java
        Runnable runnable = new RunableThread();
        new Thread(runnable).start();
        ```
1. 实现`java.util.concurrent.Callable<T>`

    该方式实现需要使用到`java.util.concurrent.FutureTask<T>`的线程在调用后可以返回线程的执行结果。
    
    1. 定义：定义类[CallableThread](./src/main/java/com/albenyuan/thread/CallableThread.java)，
    实现`java.util.concurrent.Callable<T>`接口，并实现`T call()`方法；
    1. 使用：
        ```java
        Callable callable =new CallableThread();
        FutureTask futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        Integer value = fetureTask.get();
        ```

备注：[ThreadTest](./src/test/java/com/albenyuan/thread/ThreadTest.java) 给出了各个方式的创建和启动方式。
        
        
## 比较

### java.lang.Thread

#### 优势

1. 编程简单；
1. 可使用`this`访问当前线程。

#### 劣势

1. 已经继承Thread类，不支持再继承其他类；
1. 无法直接返回处理结果。

### java.lang.Runnable

#### 优势

1. 支持继承其他类；
1. 可以共享同一资源。

#### 劣势

1. 无法直接返回处理结果；
1. 不能直接使用`this`访问当前线程，建议使用`Thread.currentThread()`访问当前线程。


### java.util.concurrent.Callable<T>

#### 优势

1. 支持继承其他类；
1. 可以共享同一资源；
1. 可以返回处理结果。

#### 劣势

1. 不能直接使用`this`访问当前线程，建议使用`Thread.currentThread()`访问当前线程'；
1. 需要和`java.util.concurrent.FutureTask<T>`联合使用。


# 线程的方法

## java.lang.Thread的方法

### 静态方法
- `public static int activeCount()`
    
    获取当前线程组中的active线程数量。
    
- `public static native void yield()`

    线程让步，声明当前线程可退让资源。只是声明，是否让步有系统决定。

- `public static native Thread currentThread()`
    
    获取当前执行的线程对象。

- `public static native void sleep(long millis)`、`public static void sleep(long millis, int nanos)`
    
    使当前线程休眠millis毫秒的时长+nanos纳秒的时长。此方方法进行了重载，支持不穿入第二个参数。

### 非静态行为

- `public void start()`
    
    启动线程，
    
- `public void run()` 
    
    线程的执行体，
    
- `public final void join()`、`public final synchronized void join(long millis)`    

    阻塞当前线程，知道子线程执行完毕或者阻塞超时。其内部调用了

- `public long getId()` 

    获取线程的id
    
- `public void interrupt()`

    中断线程

- `public boolean isInterrupted()`

    返回线程中断状态，true：线程已中断，false：线程未中断


- `public State getState()`

    获取线程的状态：
    - `State.NEW`：新建
    - `State.RUNNABLE`：正在执行        
    - `State.BLOCKED`：锁阻塞
    - `State.WAITING`：等待且未设置超时时间
    - `State.TIMED_WAITING`：等待且设置了超时时间
    - `State.TERMINATED`：终结
   
- `public final void setPriority(int newPriority)`、`public final void getPriority()`

    获取线程的优先级

- `public final synchronized void setName(String name)`、`public final String getName()`

    设置/获取线程的名字

- `public final native boolean isAlive()`

    线程是否是活跃状态
    
-  ~~public void destroy()~~ 

    销毁线程，已经`@Deprecated`，且不支持了。

-  ~~public final void resume()~~ 

    重启线程，已经`@Deprecated`，且不支持了。

-  ~~public final void suspend()~~

    暂停线程，已经`@Deprecated`，且不支持了。


# 线程的状态



## 系统中的状态

## java.lang.Thread.State

 - `State.NEW`：
        
        新建状态，还未启动。还没有调用`start()`方法
        
    - `State.RUNNABLE` 
    
        已经调用了`start()`，正在执行、等待虚拟机资源、等待系统资源
        
    - `State.BLOCKED` 
        
        等待锁，等待对象锁，等待代码块锁
    
    - `State.WAITING` 
    
        使用的锁对象调用了`wait()`方法、调用了`Thread.join()`且未设置超时时间、调用了`LockSupport.park()`方法。
    
    - `State.TIMED_WAITING`
    
        使用的锁对象调用了`wait(long)`方法、调用了`Thread.join(long)`且设置超时时间、调用了`LockSupport.park()`方法。
    
    - `State.TERMINATED`


