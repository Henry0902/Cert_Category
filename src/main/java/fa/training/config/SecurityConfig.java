package fa.training.config;
import fa.training.auth.CustomMemberDetailService;
import fa.training.auth.CustomMemberDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    CustomMemberDetailService memberDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    // config for authentication.
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(memberDetailService).passwordEncoder(passwordEncoder);
    }

    private static final String[] permitAllLink = {
            "/register",
            "/login",
            "/",
            "/js/**",
            "/css/**",
            "/api/v1/profile"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> {
            auth.requestMatchers(permitAllLink).permitAll();

            auth.requestMatchers("/admin/**")
                    .hasAnyRole("ADMIN", "MEMBER")
                    .anyRequest().authenticated();

        }).formLogin(form -> {
            form.loginPage("/login")
                    .loginProcessingUrl("/login-check")
                    .defaultSuccessUrl("/")
                    .permitAll();
        }).logout(logout -> {
                logout.logoutUrl("/log-out")
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .permitAll();
                }
        );
        return httpSecurity.build();
    }


}
