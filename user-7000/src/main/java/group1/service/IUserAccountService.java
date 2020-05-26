package group1.service;

import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;

public interface IUserAccountService {

    UserAccountDO getUserAccountById(Integer id);

    Integer saveUserAccount(UserAccountVO userAccount);
}
