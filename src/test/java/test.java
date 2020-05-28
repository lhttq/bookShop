import cn.lht.entity.BsPassword;
import cn.lht.service.BsPasswordService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void test(){
        //获取配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath" +
                ":applicationContext.xml");
        //获取服务对象
        BsPasswordService bsPasswordService
                = (BsPasswordService)applicationContext.getBean("bsPasswordService");
        //定义对象用来存储用户名密码
        BsPassword bsPassword = new BsPassword();
        //存入用户名
        bsPassword.setBsLoginname("lht");
        //存入密码
        bsPassword.setBsPassword("123");
        //测试
        List<BsPassword> bsPasswordList = bsPasswordService.queryAll(bsPassword);
        System.out.println(bsPasswordList.get(0).toString());
    }
}
