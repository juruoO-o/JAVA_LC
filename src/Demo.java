import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {

    public static void main(String[] args) {
        TestInterface target = new TestImpl();
        TestInterface proxyInstance = (TestInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class<?>[]{TestInterface.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before");
                        Object result = method.invoke(target, args);
                        System.out.println("after");
                        return result;
                    }
                });
        proxyInstance.func();
    }
}

interface TestInterface {
    void func();
}

class TestImpl implements TestInterface {
    @Override
    public void func() {
        System.out.println("111");
    }
}