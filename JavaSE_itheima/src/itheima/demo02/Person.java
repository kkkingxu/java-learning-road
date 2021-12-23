package itheima.demo02;
/**
 * @author KyleHsu
 */
public class Person {
    private boolean live = true;

    class Heart{
        public void beat(){
            // 内访外：直接访问外部类成员
            if(isLive()){
                System.out.println("心脏正在跳动");
            }else{
                System.out.println("心脏停止跳动");
            }
        }
    }
    public boolean isLive(){
        return live;
    }
    public void setLive(boolean live){
        this.live = live;
    }
}
