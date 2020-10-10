package com.gu.gan.service.impl;

import com.gu.gan.common.CommonResult;
import com.gu.gan.service.RedisService;
import com.gu.gan.service.UmsMemberService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author gu.sc
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
  private final RedisService redisService;
  @Value("${redis.key.prefix.authCode}")
  private String autoCode;
  @Value("${redis.key.expire.authCode}")
  private Long exAuthCode;

  @Autowired
  public UmsMemberServiceImpl(RedisService redisService) {
    this.redisService = redisService;
  }

  @Override
  public CommonResult generateAuthCode(String telephone) {
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    int limit = 6;
    for (int i = 0; i < limit; i++) {
      sb.append(random.nextInt(10));
    }
    //验证码绑定手机号并存储到redis
    redisService.set(autoCode + telephone, sb.toString());
    redisService.expire(autoCode + telephone, exAuthCode);
    return CommonResult.success(sb.toString(), "获取验证码成功");
  }


  //对输入的验证码进行校验
  @Override
  public CommonResult verifyAuthCode(String telephone, String authCode) {
    if (StringUtils.isEmpty(authCode)) {
      return CommonResult.failed("请输入验证码");
    }
    String realAuthCode = redisService.get(autoCode + telephone);
    boolean result = authCode.equals(realAuthCode);
    if (result) {
      return CommonResult.success(null, "验证码校验成功");
    } else {
      return CommonResult.failed("验证码不正确");
    }
  }
}
