package zuochengyun.primary.class02;

public class math_random {

  public static void main(String[] args) {
    int testTime = 10000;
    int count = 0;

    for (int i = 0; i < testTime; i++) {
      if (Math.random()<0.75){ // [0,1)
        count++;
      }
    }
    System.out.println((double)count / (double)testTime);
    System.out.println("============");
    // [0,1)  ->   [0,8)
    count = 0;
    for (int i = 0; i < testTime; i++) {
      if (Math.random()*8 < 5){ // [0,1)
        count++;
      }
    }
    System.out.println((double)count / (double)testTime);
    System.out.println("============");
  }
}
