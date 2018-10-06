package com.heygis.service.abandoned;

import com.heygis.dao.interfaces.UserDAO;
import com.heygis.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 完善个人信息，预备迁移到UserService
 */
public class FillInfoService {

    @Autowired
    UserDAO udi;

    public boolean fillInfo(User user) {
        return udi.fillInfo(user);
    }
}
