/**
 * @author 51350
 */
public class designPattern {

    // 责任链模式核心接口
    interface Handler {
        void setNext(Handler next);
        void handle(int request);
    }

    // 具体处理者1：作为Filter处理所有请求
    static class ConcreteHandler1 implements Handler {
        private Handler next;

        @Override
        public void setNext(Handler next) {
            this.next = next;
        }

        @Override
        public void handle(int request) {
            System.out.println("Filter1 处理了请求：" + request);
            if (next != null) {
                next.handle(request);
            }
        }
    }

    // 具体处理者2：作为Filter处理所有请求
    static class ConcreteHandler2 implements Handler {
        private Handler next;

        @Override
        public void setNext(Handler next) {
            this.next = next;
        }

        @Override
        public void handle(int request) {
            System.out.println("Filter2 处理了请求：" + request);
            if (next != null) {
                next.handle(request);
            }
        }
    }

    // 客户端测试代码
    public static void main(String[] args) {
        // 创建处理链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        // 测试不同请求（现在所有请求都会被两个Filter处理）
        handler1.handle(5);
        // 输出两行
        handler1.handle(15);
        // 输出两行
        handler1.handle(25);
        // 输出两行
    }
}