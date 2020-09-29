package br.com.poc.clientspringoauth2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*")
                .permitAll();
    }

  /*  @Bean
    public OAuth2RestTemplate oauth2RestTemplate(ClientCredentialsResourceDetails details) {
        return new OAuth2RestTemplate(details);
    }*/


    @Bean
    @ConfigurationProperties("security.oauth2.client")
    protected ClientCredentialsResourceDetails client() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    @Primary
    protected OAuth2RestTemplate clientOAuth2RestTemplate() {
        return new OAuth2RestTemplate(client());
    }

    @Bean
    @ConfigurationProperties("security.oauth2.dados-receita")
    protected ClientCredentialsResourceDetails oktaOAuth2Details() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean("dadosReceitaOAuth2RestTemplate")
    protected OAuth2RestTemplate dadosReceitaOAuth2RestTemplate() {
        return new OAuth2RestTemplate(oktaOAuth2Details());
    }


}
