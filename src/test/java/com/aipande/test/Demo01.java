package com.aipande.test;

import com.aipande.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * Author: WangPan
 * Description:
 * Date-Of-Create:2020/7/22-10:42
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = context.getBean("accountService",IAccountService.class);
        accountService.transfer("张三","李四",new BigDecimal(100));
    }
}
