package com.epcc.registry;

import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.epcc.entity.ServiceInfoEntity;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;

/**
 * Created by maliang on 2016/12/29.
 */
public class ServiceRegistry {

    private ServiceInfoEntity serviceInfoEntity;
    private volatile ServiceConfig<GenericService> service = null;

    public ServiceRegistry(ServiceInfoEntity serviceInfoEntity) {
        this.serviceInfoEntity = serviceInfoEntity;
    }

    public void registry(GenericService T) {
        if (StringUtils.isEmpty(serviceInfoEntity.getInterfaceName()) || serviceInfoEntity.getInterfaceName().length() <= 0) {
            throw new NullArgumentException("The 'interfaceName' should not be " + serviceInfoEntity.getInterfaceName() + ", please make sure you have the correct 'interfaceName' passed in");
        }

        GenericService genericService = T;
        service = new ServiceConfig<GenericService>();

        // set interface name
        service.setInterface(serviceInfoEntity.getInterfaceName());

        // set version
        if (serviceInfoEntity.getVersion() != "" && serviceInfoEntity.getVersion().length() > 0) {
            service.setVersion(serviceInfoEntity.getVersion());
        }

        // set timeout
        if (serviceInfoEntity.getTimeout().toString() != "" && serviceInfoEntity.getTimeout().toString().length() > 0) {
            service.setTimeout(serviceInfoEntity.getTimeout());
        }

        service.setRef(genericService);

        service.export();

    }
}
