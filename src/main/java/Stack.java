/**
 * @author LiuPeng
 * @description 栈:用数组表示栈
 * @date 2018/6/1
 */
public class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int count) {
        maxSize = count;
        stackArray = new long[maxSize];
        top = -1;
    }

    // 入栈（先入栈顶）
    public void push(long j) {
        stackArray[++top] = j;
    }

    // 出栈（栈顶先出,数组元素减一）
    public long pop() {
        return stackArray[top--];
    }

    // 查看(只能查看最上边的)
    public long peek() {
        return stackArray[top];
    }

    //是否为空栈
    public boolean isEmpty() {
        return top == -1;
    }

    // 栈是否满了
    public boolean isFull() {
        return top == maxSize - 1;
    }


    public static void main(String[] args) {
        Stack stack = new Stack(10);
        for (long i = 0; i < 12; i++) {
            if (!stack.isFull()) {
                stack.push(i);
            } else {
                System.out.println("Cant insert stack is full. ");
            }
        }
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isFull());


        // switch 的写法
        int a = 4;
        switch (a) {
            case 1:
            case 2:
            case 3:
                System.out.println(a);
                break;
            default:
                System.out.println(a + 1);
        }


    }

}
