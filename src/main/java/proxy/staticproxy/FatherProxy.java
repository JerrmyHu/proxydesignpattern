package proxy.staticproxy;

import proxy.Girl;
import proxy.Person;

public class FatherProxy implements Person {

    private Girl girl;

    public FatherProxy(Girl girl) {
        this.girl = girl;
    }

    public int findLove() {
        return girl.findLove();
    }
}
