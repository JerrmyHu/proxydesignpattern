package proxy.cglib;


public class CGlibProxyTest {

    public static void main(String[] args) {
        Girl girl = (Girl) new CglibMeipo().getInstace(Girl.class);
        girl.findLove();
    }
}
