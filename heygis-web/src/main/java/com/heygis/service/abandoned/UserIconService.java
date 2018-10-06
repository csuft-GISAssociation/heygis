package com.heygis.service.abandoned;

import java.io.FileOutputStream;
import java.io.OutputStream;

import com.heygis.common.util.EncodeUtil;
import com.heygis.constants.PathConstant;
import com.heygis.dao.interfaces.UserDAO;
import com.heygis.dto.User;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户头像更新和存储文件，预备迁移到UserService
 */
public class UserIconService {

    @Autowired
    private UserDAO udi;

    public UserIconService() {
    }

    public boolean updateImg(User user) {
        if (udi.updateIconImg(user)) {
            return true;
        }
        return false;
    }

    public boolean toImg(String base64, User user) {
        if (base64 == null) { // 图像数据为空
            return false;
        }
        try {
            // Base64解码
            byte[] bytes = EncodeUtil.dncoderByBase64(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            String path = PathConstant.TOMCAT_HOME + "webapps/heygis_img/icon/" + user.getAccount() + "_img.jpg";
            OutputStream out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
            if (updateImg(user)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }
}
