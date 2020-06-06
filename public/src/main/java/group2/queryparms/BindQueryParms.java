package group2.queryparms;

import group2.entity.vo.BindVo;

public class BindQueryParms {
    public String phone;
    public    String email;
    public   String weChatOpenId;


    public BindQueryParms(BindVo vo ) {
     vo.setPhone( this.phone );
     vo.setEmail( this.email );
     vo.setWeChatOpenId( this.weChatOpenId );


    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeChatOpenId() {
        return weChatOpenId;
    }

    public void setWeChatOpenId(String weChatOpenId) {
        this.weChatOpenId = weChatOpenId;
    }
}
