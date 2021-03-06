package com.gu.gan;

import com.gu.gan.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
@MapperScan({"com.macro.mall.tiny.mbg.mapper", "com.gu.gan.dao"})
public class GanApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(GanApplication.class, args);
    SpringContextUtil.setApplicationContext(context);
  }

}
