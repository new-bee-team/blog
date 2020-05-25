package group1.service.serviceImpl;

import group1.dao.GetUserAccountDao;
import group1.service.IGetUserAccountService;
import group2.entity.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:35
 * @description:
 **/

@Service
public class GetUserAccountServiceImpl implements IGetUserAccountService {

    @Autowired
    private GetUserAccountDao getUserAccountDao;

    @Override
    public UserAccount getUserAccountById(Integer id) {
        return getUserAccountDao.getUserAccountById(id);
    }
}
