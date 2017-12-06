package pl.s2devs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.s2devs.person.model.Person;
import pl.s2devs.person.repository.PersonRepository;

@SpringBootApplication
public class McServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McServerApplication.class, args);
    }

    @Configuration
    class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        PersonRepository userRepository;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService());
        }

        @Bean
        UserDetailsService userDetailsService() {
            return userEmail -> {
                Person client = userRepository.findByEmail(userEmail);
                if (client != null) {
                    return new org.springframework.security.core.userdetails.User(client.getEmail(),
                            client.getPassword(),
                            true, true, true, true,
                            AuthorityUtils.createAuthorityList("USER"));
                } else {
                    throw new UsernameNotFoundException
                            ("Could not find the user '" + userEmail + "'");
                }
            };
        }
    }


    @EnableWebSecurity
    @Configuration
    class AccessControl extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic()
                    .and()
                    .csrf().disable();
        }

    }
}
