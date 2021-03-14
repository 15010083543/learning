package com.base.lock;

/**
 * @Author: liupeng
 * @DateTime: Created in 2021/2/25 14:34
 * @version: 1.0
 * @Description: TODO
 */
public class TestConsumerAndProduct {

    static int num = 0;
    static boolean flag = true;

    public static void main(String[] args) {
        TestConsumerAndProduct testConsumerAndProduct = new TestConsumerAndProduct();
        for (int i = 0; i < 10; i++) {
            new Thread(new Consuer(testConsumerAndProduct)).start();
            new Thread(new Product(testConsumerAndProduct)).start();
        }

    }

    static class Consuer implements Runnable {
        private TestConsumerAndProduct testConsumerAndProduct;
        public Consuer(TestConsumerAndProduct testConsumerAndProduct){
            this.testConsumerAndProduct = testConsumerAndProduct;
        }

        @Override
        public void run() {
            synchronized (testConsumerAndProduct) {
                while (flag) {
                    try {
                        testConsumerAndProduct.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num--;
                flag = true;
                System.out.println("consuer="+num);
                testConsumerAndProduct.notify();
            }

        }
    }

   static class Product implements Runnable {
        private TestConsumerAndProduct testConsumerAndProduct;
        public Product(TestConsumerAndProduct testConsumerAndProduct){
            this.testConsumerAndProduct = testConsumerAndProduct;
        }

        @Override
        public void run() {
            synchronized (testConsumerAndProduct) {
                while (!flag) {
                    try {
                        testConsumerAndProduct.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                flag = false;
                System.out.println("product="+num);
                testConsumerAndProduct.notify();
            }
        }
    }


}
