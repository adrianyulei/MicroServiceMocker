package com.epcc.generic;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * Created by maliang on 2016/12/29.
 */
public abstract class AbstractServiceMock implements GenericService{

    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        return this.mockerDefiniton(s, strings, objects);
    }

    /**
     * 泛化调用
     *
     * @param method 方法名，如：findPerson，如果有重载方法，需带上参数列表，如：findPerson(java.lang.String)
     * @param parameterTypes 参数类型
     * @param args 参数列表
     * @return 返回值
     * @throws Throwable 方法抛出的异常
     */
    public abstract Object mockerDefiniton(String methodName, String[] parameterTypes, Object[] args);

}
