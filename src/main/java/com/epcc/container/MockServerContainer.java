package com.epcc.container;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.epcc.entity.ServiceInfoEntity;
import com.epcc.registry.ServiceRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by maliang on 2016/12/29.
 */
public class MockServerContainer {

    private static GenericService genericService;
    private static ServiceInfoEntity serviceInfoEntity;
    private static ServiceRegistry registry;

    public static void start(HashMap<Class, ServiceInfoEntity> map) throws IllegalAccessException, InstantiationException {
        for (Class cls : map.keySet()) {
            genericService = (GenericService) cls.newInstance();
            serviceInfoEntity = map.get(cls);
            registry = new ServiceRegistry(serviceInfoEntity);
            registry.registry(genericService);
        }
        try {
            System.out.println("dubbo service has bean started sucessfully...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
