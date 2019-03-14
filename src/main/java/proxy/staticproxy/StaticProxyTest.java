package proxy.staticproxy;

import proxy.Girl;

public class StaticProxyTest {

    public static void main(String[] args) {

        new FatherProxy(new Girl()).findLove();

    }
}
