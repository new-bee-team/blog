package group1.security;

import group2.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 20:45
 * @description:
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //拦截@PreAuthrize
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    // 认证用户来源————数据库
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 不使用url拦截而使用注解aop拦截
        http.authorizeRequests().antMatchers("/**").permitAll();
    }

    // 配置

    // 密码
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.string2MD5((String)charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(MD5Util.convertMD5(MD5Util.convertMD5((String)charSequence)));
            }
        };
    }
}
