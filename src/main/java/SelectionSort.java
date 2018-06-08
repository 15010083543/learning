/**
 * @author LiuPeng
 * @description 选择排序：其中的一个元素和所有元素比较
 * @date 2018/5/31
 */
public class SelectionSort {
    
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 7, 6};
        for (int i = 0; i < array.length; i ++){
            for (int j = i + 1 ; j < array.length; j++) {// 关键的比较
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
