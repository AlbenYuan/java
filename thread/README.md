# Thread
线程

## 创建线程
无论使用什么方式使用线程都需要，完成以下三步
1. 定义执行体，。
1. 创建线程```new Thread();```，不同的实现方式，在创建线程的时候会传入不同的参数。
1. 启动线程`thread.start();`

### 实现方式
这里的实现方式，我的理解是指线程执行内容的实现方式。
1. 继承`Thread`
    1. 定义：定义类[ExtendThread](./src/main/java/com/albenyuan/thread/ExtendThread.java)继承`java.lang.Thread`，
    并重写`run()`方法;
    1. 使用：
        ```java
       new ExtendThread().start();
       ```
1. 实现`Runnable`
    1. 定义：定义类[RunnableThread](./src/main/java/com/albenyuan/thread/RunnableThread.java)，实现`java.lang.Runnable`接口，实现`run()`方法;
    1. 使用：
        ```java
        Runnable runnable = new RunableThread();
        new Thread(runnable).start();
        ```
1. 实现`Callable<T>`

    该方式实现需要使用到`java.util.concurrent.FutureTask`的线程在调用后可以返回线程的执行结果。
    
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


### java.util.concurrent.Callable

#### 优势

1. 支持继承其他类；
1. 可以共享同一资源；
1. 可以返回处理结果。

#### 劣势

1. 不能直接使用`this`访问当前线程，建议使用`Thread.currentThread()`访问当前线程'
1. 需要和`java.util.concurrent.FutureTask<T>`联合使用。