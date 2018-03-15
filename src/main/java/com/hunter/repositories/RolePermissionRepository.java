package com.hunter.repositories;

import com.hunter.bean.user.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lixiang on 2018/3/13.
 */

public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

}
