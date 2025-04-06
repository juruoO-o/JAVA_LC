import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class juc {
    public static void main(String[] args) throws IOException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardOldestPolicy());
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
//        threadPoolExecutor.execute(new myThread2());
//        new myThread1().start();
//        CountDownLatch countDownLatch = new CountDownLatch(100);
//        new Thread(()->{
//            for (int i = 0; i < 100; i++) {
//                countDownLatch.countDown();
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("sub over");
//        }).start();
//        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set(" ");
//
//        countDownLatch.await();
//        System.out.println("main over");
//        Deque<Integer> stk = new ArrayDeque<Integer>(10);
//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        atomicInteger.addAndGet(-1);
//        System.out.println(atomicInteger);
//        new grandClass().func();
        grandClass grandClass = new father();
//        grandClass.func();
        grandClass = new son();
        grandClass.func();
    }


}

class grandClass{
    void func(){
        System.out.println("grand");
    }
}
class father extends  grandClass{
    @Override
    void func(){
        super.func();
        System.out.println("father");
    }
}

class son extends father{
    @Override
    void func() {
        super.func();
        System.out.println("son");
    }
}