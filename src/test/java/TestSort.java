import com.arithmetic2.sort.Comment;
import org.junit.Test;

/**
 * @author LiuPeng
 * @description 排序测试
 * @date 2018/12/10
 */
public class TestSort {

    @Test
    public void testInsert1() {
        //System.out.println(n*logn);
    }


    @Test
    public void testInsert() {
        int[] arr = Comment.genric(10, 0, 10);
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
        Comment.print(arr);
    }

    @Test
    public void testShell() {
        //int[] arr = Comment.genric(10, 0, 10);
        int[] arr = {9,10,11,12,1,6,7,3,4,2};
        int h = arr.length;
        while (true) {
            h = h / 2;// 步长每次缩小一半
            for (int i = 0; i < h; i++) {
                for (int x = i+h; x < arr.length; x+=h) {// 找到比较的第二个元素
                    int tmp = arr[x];
                    int j;
                    for (j = x - h; j >= 0 && arr[j] > tmp; j =j- h) {// 找到比较的第一个元素
                        arr[j + h] = arr[j];
                        System.out.println("arr[j + h]" +arr[j + h]);
                        System.out.println("arr[x]" +arr[x]);
                    }
                    arr[j+h] = tmp;
                }
            }
            if (h == 1) {
                break;
            }
        }
        Comment.print(arr);
    }
}
