package lock;

import java.util.concurrent.atomic.AtomicInteger;

public class A {
  // int num = 0 ;
  AtomicInteger atomicInteger = new AtomicInteger();

  public int getNum(){
    return atomicInteger.get();
  }

  public void increase(){
    atomicInteger.incrementAndGet();
    // CAS实现
    // while(true){
    //   int oldValue = atomicInteger.get();
    //   int newValue = oldValue + 1;
    //   if (atomicInteger.compareAndSet(oldValue,newValue)){
    //     break;
    //   }
    // }
  }
}
