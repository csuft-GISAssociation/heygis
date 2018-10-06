package com.heygis.common.system;

import org.springframework.beans.factory.InitializingBean;

/**
 * 系统启动入口，如有非propertise配置文件的配置读取等系统启动需要执行的内容，在此执行
 */
public class SystemLoad implements InitializingBean {
    public void afterPropertiesSet() throws Exception {
        systemInint();
    }

    public void systemInint(){
        System.out.println("systemLoad");
    }
}
