package com.hunter.repositories;

import com.hunter.bean.user.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * Created by lixiang on 2018/3/13.
 */

public interface PermissionRepository extends JpaRepository<Permission, String> {


        @Query("select t from t_permission t where exists (select 1 from t_role_permission p where p.rid = t.id and p.rid in (?1))")
        Set<Permission> findAllByRoleId(Set<Integer> ids);
}
