package group1.service.impl;

import group1.dao.UserAccountDao;
import group1.service.IUserAccountService;
import group1.util.Convert;
import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;
import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:35
 * @description:
 **/

@Service
@Slf4j
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
        log.info("查询用户,id=" + id);
        return Result.success(userAccountVO);
    }

    @Override
    public Result saveUserAccount(String account, String password) {
        // 1、account是否重复？

        // 2、插入account、password返回新增记录的id
        UserAccountDO userAccount = Convert.getDo(account, password);
        if (null == userAccount)
            return Result.fail(StatusEnum.BAD_REQUEST);
        Integer i = userAccountDao.saveUserAccount(userAccount);
        Integer id = userAccount.getId();
        if (i == 1 && id > 0) {
            log.info("插入新用户成功:\t" + userAccount.toString());
            return Result.success(id);
        } else {
            log.info("插入新用户失败:\t" + userAccount.toString());
            return Result.fail();
        }
    }
}