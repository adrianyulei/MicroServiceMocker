# MicroServiceMocker
##### A Dubbo Service Mocker
##### V2.0.0

___
##  Usage of this MOCK tool

**Step 1** add personal service dependency
    
    <!-- Personal Service dependencies-->
    <dependency>
        <groupId>com.epcc.control</groupId>
        <artifactId>control-basedata-facade</artifactId>
        <version>0.0.1-SNAPSHOT</version>
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

