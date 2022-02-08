package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kata.spring.boot_security.demo.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

/*        private final SuccessUserHandler successUserHandler;

            @Autowired
            public WebSecurityConfig(SuccessUserHandler successUserHandler) {
                this.successUserHandler = successUserHandler;
            }*/


    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailServiceImpl userDetailService(){
        return new UserDetailServiceImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()

                //Доступ только для не зарегистрированных пользователей
//                .antMatchers("/users").not().fullyAuthenticated()

/*                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**", "/user-*").hasRole("ADMIN")

                //Доступ только для пользователей с ролью Пользователь
                .antMatchers("/users/**").hasRole("USER")*/

                //Доступ разрешен всем пользователям
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin().defaultSuccessUrl("/index", true)
  //              successHandler(successUserHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService())
                .passwordEncoder(bCryptPasswordEncoder());
    }
}