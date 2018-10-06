package com.heygis.common.system;

import com.heygis.constants.PathConstant;
import com.heygis.dao.DB.DBConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class SystemLoadTest {

    @Test
    public void testSystemInint(){
        System.out.println(PathConstant.TOMCAT_HOME);
        System.out.println(DBConfig.getUrl());
    }
}
