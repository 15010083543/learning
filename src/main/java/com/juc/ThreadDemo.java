package com.juc;

import lombok.Data;

@Data
public class ThreadDemo implements Runnable {
        public boolean flag = false;
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("update=" + flag);
        }
    }