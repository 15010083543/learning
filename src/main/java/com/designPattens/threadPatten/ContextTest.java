package com.designPattens.threadPatten;

import java.util.stream.IntStream;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/9 20:18
 * @Description: TODO
 */
public class ContextTest {
    public class Context { // 上下文类  public class Context {

        private String name;
        private long id;
        public long getId() {      return id;    }
        public void setId(long id) {      this.id = id;    }
        public String getName() {      return this.name;    }
        public void setName(String name) {      this.name = name;    }
    }

    public class QueryIdAction {

        public void execute(Context context) {
            try {
                Thread.sleep(1000L);
                long id = Thread.currentThread().getId();
                context.setId(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public class QueryNameAction {

        public void execute(Context context) {
            try {
                Thread.sleep(1000L);
                String name = Thread.currentThread().getName();
                context.setName(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class ExecutionTask implements Runnable {
        private QueryNameAction queryNameAction = new QueryNameAction();
        private QueryIdAction queryIdAction = new QueryIdAction();

        @Override
        public void run() {
            final Context context = new Context();
            queryNameAction.execute(context);
            System.out.println("The name query successful");
            queryIdAction.execute(context);
            System.out.println("The id query successful");
            System.out.println("The Name is " + context.getName() + " and id " + context.getId());
        }

    }

    public static void main(String[] args) {
        IntStream.range(1, 5)
                .forEach(i -> new Thread(new ContextTest().new ExecutionTask()).start());
    }

}

