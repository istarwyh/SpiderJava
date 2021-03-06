package spiderJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: SpiderApplication
 * @Author: YiHui
 * @Date: 2020-11-27 18:09
 * @Version: ing
 */
@SpringBootApplication
public class SpiderApplication {
    public static void main(String[] args) {
//        默认启动端口:127.0.0.1:8080
        SpringApplication.run(SpiderApplication.class, args);
    }
}
