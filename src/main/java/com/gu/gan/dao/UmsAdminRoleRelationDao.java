package com.gu.gan.dao;

import com.gu.gan.mbg.model.UmsPermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 后台用户与角色管理自定义Dao
 * @author gu.sc
 */
@Component
public interface UmsAdminRoleRelationDao {
  /**
   * 获取用户所有权限(包括+-权限)
   */
  List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
