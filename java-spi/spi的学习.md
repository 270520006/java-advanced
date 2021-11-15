# Java SPI

​	学习JAVA SPI的目的是为了更好的去进行dubbo和一些源码的学习，还有一些驱动的编写，这里简单介绍下。	

​	SPI全称 Service Provider Interface，是一种服务发现机制。我们编程实现一个功能时，经常先抽象一个interface，内部再定一些方法。具体的实现交给 implments了此接口的类，实现了功能和实现类的分离。

  我们设想一下，如果一个描述汽车功能的interface Car，存在多个实现类BMW、Benz、Volvo，某个场景调用Car的行驶方法，程序就需要确认到底是需要BMW、Benz、Volvo中的那个类对象。如果硬编码到程序中，固然可以，但是出现了接口和实现类的耦合，缺点也显而易见。

  有办法做到在调用代码中不涉及BMW、Benz、Volvo字符，也随意的指定实现类么？当然，SPI就是解决这个问题。

  SPI的实现方式是，在指定的路径下增加一个文本文件，文件的名称是interface的全限定名(包名+接口名)，文件内容每行是一个此接口的实现类的全限定名，多个实现类就会有多行。接口进行调用时，根据接口全限定名，先读取文本文件，解析出具体的实现类，通过反射进行实例化，再调用之。如果增加新的实现类，不需要修改调用代码，只需要在文本文件中增加一行实现类的全限定名即可，删除实现类同理。

​	很多框架都使用了java的SPI机制，如java.sql.Driver的SPI实现（mysql驱动、oracle驱动等）、common-logging的日志接口实现、dubbo的扩展实现等等框架；

## 案例

​	先看案例，再来细说吧，只看概念太抽象了，先看一下工程整体目录：

![image-20211115111004494](/spi的学习/image-20211115111004494.png)

我们这里来模拟个场景，比如我们是下游厂商，负责给人做驱动或者插件的，我们需要给上游厂商提供一些功能：

* 假设上游厂商需要的功能模块叫Car，需要的功能目前只有一个就是goBeijing：

```java
package cn.zsp.spi;
public interface Car {
    void goBeijing();
}
```

* 上游厂商直接使用Java SPI对需求的功能进行遍历使用。至此，上游厂商需要做的已经做完了：
  * 提供功能模块，需要的功能
  * 遍历使用需要的功能

```java
package cn.zsp.spi;
import java.util.Iterator;
import java.util.ServiceLoader;
public class App {
     public static void main(String[] args) {
         ServiceLoader<Car> serviceLoader = ServiceLoader.load(Car.class);
         serviceLoader.forEach(Car::goBeijing);
         //看不懂？没关系，我写个简单的，上下，这两个实现方法一样
         Iterator<Car> iterator = serviceLoader.iterator();
         while (iterator.hasNext()){
             iterator.next().goBeijing();
         }
     }
 }
```

* 到我们下游厂商干活了，我们要先去实现上游厂商的接口，知道她要什么功能，然后重写。
  * 在impl实现Car这个方法，我们这里实现了三个类，偷懒写一起了：

```java
package cn.zsp.spi.impl;
import cn.zsp.spi.Car;
public class Benz implements Car {
    @Override
    public void goBeijing() {
            // TODO Auto-generated method stub
            System.out.println("开着奔驰去北京........");
    }
}

package cn.zsp.spi.impl;
import cn.zsp.spi.Car;
public class Bmw implements Car {
 @Override
 public void goBeijing() {
  System.out.println("开着宝马去北京......");
 }
}

package cn.zsp.spi.impl;
import cn.zsp.spi.Car;
public class Volvo implements Car {
    @Override
    public void goBeijing() {
        System.out.println("开着沃尔沃去北京......");
    }
}
```

* 然后我们需要把这个功能实现类按照我们双方约定的规范配置到配置类里，这样上游厂商就能无脑获取了：
  * 在resource下META-INF（你要是一开始没有这个文件夹，创建就可以了）创建service文件夹，创建文件命名为cn.zsp.spi.Car，编辑内容为下：

```
cn.zsp.spi.impl.Bmw
cn.zsp.spi.impl.Volvo
cn.zsp.spi.impl.Benz
```

注：这里提一嘴，记住了，这名字别写错，是蓝色文件夹java下的全路径名称！今天踩的大坑！

​	说明一下，我这里用的是单模块，多模块也就是分布式也同样可以用，这让你想到了什么？远程调用是吧，对的，dubbo，open feign都有用到这个功能。这是学习这些源码的基础，还请各位仔细打磨基础再去看源码。

## SPI机制的约定

1) 在META-INF/services/目录中创建以接口全限定名命名的文件该文件内容为Api具体实现类的全限定名

2) 使用ServiceLoader类动态加载META-INF中的实现类

3) 如SPI的实现类为Jar则需要放在主程序classPath中

4) Api具体实现类必须有一个不带参数的构造方法

## SPI机制结构图

![img](/spi的学习/081719062588772.jpg)

## JAVA SPI优缺点

* 优点：实现了解耦，不再通过`import`关键字导入实现，而是通过动态的加载实现。使得业务组件插件化。
* 缺点：**ServiceLoader**在加载实现类的时候会全部加载并实例化，无论你是否需要使用到它。而且只能通过迭代去获取实现，无法通过关键字来获取。

