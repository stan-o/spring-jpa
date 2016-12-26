package com.so.webblog.service;

import com.so.webblog.domain.UserRoles;
import java.util.List;

public interface UserRolesService extends BaseService<UserRoles, Integer> {
    List<UserRoles> byUserId(Integer userid);
}
