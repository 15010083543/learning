/**
 * @author LiuPeng
 * @description 冒泡排序:相邻两个元素之间的比较(注意顺序)
 * @date 2018/5/31
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 2, 5, 7, 6};
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length-1; j++) {
                if(array[j] > array[j+1]){ // 关键比较
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
