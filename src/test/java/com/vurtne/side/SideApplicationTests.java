package com.vurtne.side;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class SideApplicationTests {



    @Test
    void contextLoads() {
    }

    @Resource
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("DCblimbFfpkYBk5A1dokV3nMgnAKFxPb");
        System.out.println("==================");
        System.out.println(result);
        System.out.println("==================");
    }

}
