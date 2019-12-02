# ModuleBus 支持跨模块收发消息


1.实现思路：
          参考美团技术团队发布的文章 @link https://tech.meituan.com/2018/12/20/modular-event.html
          消息收发使用LiveEventBus 完成 @link https://github.com/JeremyLiao/LiveEventBus
      
  
    a、通过@ModuleEventCenter注解，定义消息的清单文件
    
    b、通过@EventRegister注解，定义每一条具体的消息，消息的类型
    
    c、编译时通过注解处理器，每个被@ModuleEventCenter注解的类生成一个接口，类中的每一个注解的属性字段都会生成接口中的一个方法。
    
    d、运行时构建基于两级HashMap的LiveData存储结构，第一级key为moduleName，第二级key为eventName。
    
    e、运行时采用interface+动态代理的方式实现真正的消息订阅和发送。
    
    f、每个动态生成的接口都下沉在base_module中，其他业务组件需要依赖于base_module



2.useAge

            initialize(In BaseApplication):
            ModuleBus.getInstance().init(this);

            注册接收器：
            ModuleBus.getInstance().of(Gen$module_a$Interface.class).Gen$event_1$Method().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(ActA.this, s, Toast.LENGTH_SHORT).show();
            }
        });


       
           发送消息： 
           ModuleBus.getInstance().of(Gen$module_b$Interface.class).Gen$eee$Method().post("moduleA send msg to moduleB");
            



3.感谢美团技术团队开源的文章
