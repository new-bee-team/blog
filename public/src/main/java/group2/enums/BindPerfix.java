package group2.enums;

import sun.security.util.Password;

public enum BindPerfix {
    PHONE,
    UNPHONE,
    WECHAT,
    UNWECHAT,
    EMAIL,
    UNEMAIL,
    PASSWORD;

    public String getBindPerfix(){

        return this.name()+"_";
    }
}
