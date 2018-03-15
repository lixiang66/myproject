package com.hunter.repositories;

import com.hunter.bean.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * Created by lixiang on 2018/3/13.
 */

public interface RoleRepository extends JpaRepository<Role, String> {

        @Query("select t from t_role t where exists (select 1 from t_user_role r where r.rid = t.id and r.uid = ?1)")
        Set<Role> findAllByUsername(String username);
}
