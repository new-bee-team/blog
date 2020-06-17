//package group1.security;
//
//import group1.dao.UserAccountDao;
//import group1.dao.UserRoleDao;
//import group2.entity.pojo.UserAccountDO;
//import group2.entity.pojo.UserRoleDO;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author: KongKongBaby
// * @create: 2020-06-10 21:17
// * @description:
// **/
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//
//    @Resource
//    private UserAccountDao userAccountDao;
//
//    @Resource
//    private UserRoleDao userRoleDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
//        // 1、获取userAccount的账号密码
//        UserAccountDO userAccountDO = userAccountDao.getUserAccountByAccount(account);
//        if (null == userAccountDO) {
//            throw new UsernameNotFoundException(account + "帐号未找到!");
//        }
//        // 2、获取角色
//        UserRoleDO userRoleDO = userRoleDao.getUserRole(userAccountDO.getId());
//        if (null == userRoleDO) {
//            throw new UsernameNotFoundException(account + "角色未找到!");
//        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + userRoleDO.getRole()));
//        User userDetails = new User(userAccountDO.getAccount(), userAccountDO.getPassword(), authorities);
//        System.out.println(userDetails);
//        return userDetails;
//    }
//}