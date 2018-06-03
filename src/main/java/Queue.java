/**
 * @author LiuPeng
 * @description 队列
 * @date 2018/6/1
 */
public class Queue {

   private int maxSize;
   private int[] queue;
   private int front;
   private int rear;

   public Queue(int size){
        maxSize = size;
        queue = new int[maxSize];
        front = 1;
        rear = 0;
   }

   public void insert(int num){
        if (maxSize != rear+1){
            queue[rear++] = num;
        } else{
            System.out.println("can not insert queue is full");
        }
   }

   public void remove(){
       if (rear != 0) {
           front ++;
           rear --;
       } else {
           System.out.println("can not remove queue is empty");
       }
   }

   // 查看
   public int peek(){
       return queue[front-1];
   }

   public boolean isEmpty(){
       return rear == 0;
   }

    public boolean isFull(){
        return maxSize == rear+1;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        for (int i = 0; i < 6; i++) {
            queue.insert(i);
        }
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
        System.out.println("--");
    }
}
