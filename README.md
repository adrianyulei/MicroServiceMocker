# MicroServiceMocker
##### A Dubbo Service Mocker
MicroServiceMocker入口——App.java

*  	// 1.服务接口名称：自定义，跟需要调用的服务名一致就行
*  	// 2.版本号：注册的dubbo-version信息，譬如：alia-1.0.0
*  	// 3.响应时间：ms，用于模拟相应超时等异常情况
	
`MockServer.run(MyProviderMockImpl.class, new MockServiceInfoDTO("com.alia.service.AliaTestService","", 500));`
