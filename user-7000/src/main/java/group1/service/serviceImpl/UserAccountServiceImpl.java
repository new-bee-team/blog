package group1.service.serviceImpl;

import group1.dao.UserAccountDao;
import group1.service.IUserAccountService;
import group1.util.Convert;
import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:35
 * @description:
 **/

@Service
public class UserAccountServiceImpl implements IUserAccountService {

    @Autowired
    private UserAccountDao userAccountDao;

    @Override
    public UserAccountDO getUserAccountById(Integer id) {
        return userAccountDao.getUserAccountById(id);
    }

    @Override
    public Integer saveUserAccount(String account,String password) {
        UserAccountDO userAccount = Convert.getDo(account,password);
        return userAccountDao.saveUserAccount(userAccount);
    }
}
