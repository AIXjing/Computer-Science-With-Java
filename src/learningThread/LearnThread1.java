package learningThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class LearnThread1 {
  static Runnable runnable =
      () -> {
        System.out.println(Thread.currentThread().getName() + " is running...");
        for (int i = 0; i < 10; i++) {
          try {
            Thread.sleep(300);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName() + " count: " + i);
        }
      };
  static Supplier supplier =
      () -> {
        System.out.println(Thread.currentThread().getName() + "supplier is running...");
        for (int i = 0; i < 10; i++) {
          try {
            Thread.sleep(800);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName() + " supplier count: " + i);
        }
        return "Finished";
      };

  public static void main(String[] args) throws Exception {
    System.out.println(Thread.currentThread().getName() + " is running...");
    // demo1();
    //    demo2();
    demo3();
    for (int i = 0; i < 10; i++) {
      Thread.sleep(2000);
      System.out.println("main count: " + i);
    }
  }

  public static void demo1() throws Exception {
    System.out.println(Thread.currentThread().getName() + " - demo1 is running...");
    Thread t = new Thread(runnable);
    t.start();
  }

  public static void demo2() throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    executorService.submit(runnable);
  }

  public static void demo3() throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(supplier, executorService);
    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(supplier, executorService);
    future1.thenCombine(
        future2,
        (f1, f2) -> {
          System.out.println(f1 + f2);
          return f1 + f2;
        });
  }
}
