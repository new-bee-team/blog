package group2.enums;

import sun.security.util.Password;

public enum BindPerfixEnum {
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
