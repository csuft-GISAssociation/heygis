package com.heygis.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PathConstant {

    public static String TOMCAT_HOME;

    public static String ICON_IMG_PATH;

    public static String VTOR_PATH;

    @Value("#{setting[tomcat_home_path]}")
    public void setTomcatHome(String tomcatHome) {
        TOMCAT_HOME = tomcatHome;
    }

    @Value("#{setting[icon_img_path]}")
    public void setIconImgPath(String iconImgPath) {
        ICON_IMG_PATH = iconImgPath;
    }

    @Value("#{setting[vtour_path]}")
    public void setVtorPath(String vtorPath) {
        VTOR_PATH = vtorPath;
    }
}
