package com.epcc.entity;

/**
 * Created by maliang on 2016/12/29.
 */
public class ServiceInfoEntity {

    private String interfaceName;
    private String version;
    private Integer timeout;

    public ServiceInfoEntity(String interfaceName, String version, Integer timeout){
        this.interfaceName = interfaceName;
        this.version = version;
        this.timeout = timeout;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public String getVersion() {
        return version;
    }

}
