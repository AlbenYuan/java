# 线程通信
单线程下，应用代码依次执行。代码直接完毕，人物也就结束了。然而在多线程下，存在多个线程协调完成任务的情况。
这种情况下就需要线程之间进行消息传递、信号通知以达到协调的效果。

## 场景

- A、B任意执行
- A、B线程先后执行
- A、B交替执行
- A、B执行完毕后，C开始执行


## 方式

- wait

- join

- notify

- CountdownLatch

- CyclicBarrier

- FutureTask/Callable
