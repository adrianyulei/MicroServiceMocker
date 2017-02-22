### OGMOCK Reference Documentation


### Authors
Liang.Ma(maliangcrazy@gmail.com)


#### 2.0.1

*Copies of this document may be made for your own use and for distribution to others, provided that you do not charge any fee for such copies and further provided that each copy contains this Copyright Notice, whether distributed in print or electronically.*

#### Table of Contents
___
## I. Overview of OGMOCK
#### 1. Introduction to the OGMOCK

> OGMOCK : Dubbo Service Mock Framework

**OGMOCK**is a mock framework developed by maliang in Bestpay.

## II. Usage of OGMOCK

**Step 1** add dependency
    
    <dependency>
       <groupId>com.epcc</groupId>
       <artifactId>ogmock</artifactId>
       <version>2.0.1</version>
    </dependency>
    
**Step 2**  extends AbstractServiceMock,and override public Object mockerDefiniton(String s, String[] strings, Object[] objects) method.
    
    public class MyMockerImpl extends AbstractServiceMock{
        public Object mockerDefiniton(String s, String[] strings, Object[] objects) {
    
            if (s.equals("testhello")) {
                return "this is a mock service!";
            }
            return null;
        }
    }
mockerDefinition:
    
    String s: method name, such as: testMethod
    String[] strings: method params type, such as: String, Integer, com.bestpay.A
    Object[] objects: method params value: "hello", 100, a


**Step 3** configure resources/dubbo.properties
    
    dubbo.application.name=microservice-mocker
    dubbo.registry.address=zookeeper://127.0.0.1:2181
    dubbo.protocol.port=20880


**Step 4** start mock server container
    
    MockServerContainer.start(MyMockerImpl.class, new ServiceInfoEntity("com.bestpay.demo.testService001","1.0.1", 500));
    
Note that: the params in ServiceInfoEntity: service name, version, timeout.


end.

