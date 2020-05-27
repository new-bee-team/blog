package group1.service.impl;

import group1.dao.UserAccountDao;
import group1.service.IUserAccountService;
import group1.util.Convert;
import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;
import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
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
    public Result getUserAccountById(Integer id) {
        UserAccountDO userAccount = userAccountDao.getUserAccountById(id);
        if (null == userAccount)
            return Result.fail(StatusEnum.NO_OPTION);
        UserAccountVO userAccountVO = Convert.doToVo(userAccount);
        if (null == userAccountVO)
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
        return Result.success(userAccountVO);
    }

    @Override
    public Result saveUserAccount(String account, String password) {
        UserAccountDO userAccount = Convert.getDo(account, password);
        if (null == userAccount)
            return Result.fail(StatusEnum.BAD_REQUEST);
        Integer i = userAccountDao.saveUserAccount(userAccount);
        Integer id = userAccount.getId();
        if (i == 1 && id > 0)
            return Result.success(id);
        else
            return Result.fail();
    }
}
