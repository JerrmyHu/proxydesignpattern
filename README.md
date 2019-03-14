# proxydesignpattern
JDK动态代理中要求目标类实现的接口数量不能超过65535个，是因为在tcp udp协议的开头，会分别有16位来存储源端口号和目标端口号，所以端口个数是2^16-1=65535个，所以在Proxy中的getProxyClass0这个方法中会做接口限制



<h1>对代理模式的认识</h1>
&nbsp&nbsp代理模式就是指为其他对象提供一种代理，用于控制对这个对象的访问，代理对象是在客户端和目标对象之间起到中介的作用，代理模式出现就是保护目标对象和增强目标对象功能<br>
<h1>代理模式的优缺点</h1>
&nbsp优点：<br>
&nbsp&nbsp1、代理模式可以将代理对象和真实调用的目标对象分离
&nbsp&nbsp2、代理模式在一定层度生降低了系统的耦合度，增加系统的扩展性
&nbsp&nbsp3、起到保护目标对象目的和增强目标对象的功能
&nbsp缺点：<br>
&nbsp&nbsp1、代理模式会造成系统中类的增加
&nbsp&nbsp2、代理模式实在客户端和目标对象中增加一个代理对象，会造成请求处理速度变慢，也增加了系统的复杂度
<h1>实现代理模式的方式</h1>
 &nbsp&nbsp1、静态代理
 &nbsp&nbsp2、jdk动态代理
 &nbsp&nbsp3、CGlib动态代理<br>
 <h1>静态代理</h1>
 &nbsp&nbsp静态代理中的代理对象和目标对象就是一对一的关系，一个代理对象只能为对应的目标对象进行代理，写法非常的简单
 <h1>jdk动态代理</h1>
 &nbsp&nbsp动态代理的基本思路是和静态代理一致的，只是动态代理的代理类更加强大，具有更好的扩展性。jdk实现动态代理：代理类实现InvocationHandler，重写invoke方法就可以实现。
 &nbsp&nbspjdk proxy实现的原理是采用字节重组，利用新生的对象来代替原始对象，从而达到动态代理的目的。
 &nbsp&nbspjdk proxy生成新对象的过程：
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp1、拿到被代理对象的引用，通过反射获取它的所有接口
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2、jdk proxy类会重新生成一个新的类，同时新生的类会实现被代理类中的所有实现的接口
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp3、动态生成代码，新增的业务逻辑有一定的逻辑代码去调用
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp4、将重组好的代码编译生成.class文件
 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp5、重新将这个class文件加载到jvm中运行
&nbsp&nbspjdk proxy生成新对象的这一个过程就是字节码重组，在JDK中有一个规范，在classpath下只要是$开头的class文件一般都是自动生成，<br>

<h1>cglib动态代理</h1>

<h1>静态模式和动态代理区别</h1>
&nbsp1、静态代理只能通过手动完成代理操作，如果代理类增加新的方法，代理类要通过新增，违反了开闭原则
&nbsp2、动态代理采用在运行时动态生成代码的方式，取消了对被代理类的扩展限制，遵循开闭原则
&nbsp3、若动态代理要对目标类增加逻辑扩展，结合策略模式，这要增加策略类就可以文成，不需要修改代理类
 
 

