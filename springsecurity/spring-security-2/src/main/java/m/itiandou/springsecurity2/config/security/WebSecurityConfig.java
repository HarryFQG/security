package m.itiandou.springsecurity2.config.security;

import m.itiandou.springsecurity2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author fengqigui
 * @description security 安全认证类
 * @date 2018/05/02 10:25
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{


    @Autowired
    private UserService userService;

    @Autowired
    private TokenAuthorityFilter tokenAuthorityFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 前置拦截器
        http.addFilterBefore(tokenAuthorityFilter, BasicAuthenticationFilter.class);
        http.csrf().disable()
                .rememberMe().alwaysRemember(true)
                .and().headers().frameOptions().sameOrigin()
                // 无需拦截的URL
                .and().authorizeRequests().antMatchers("/index/**","/logout/**","/pageOne/**","/","/login").permitAll()
                // 只要验证的了都放过
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

}
