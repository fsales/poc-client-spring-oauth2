package br.com.poc.clientspringoauth2.pessoa.api;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestOperations;

@Configuration
public class FeignClientConfiguration {

    private String cpfContrato;

    private OAuth2RestOperations restOperations;


    FeignClientConfiguration(
            @Value("${poc-oauth2.dados-receita.oauth2.cpf-contrato}") String cpfContrato,
            @Qualifier("dadosReceitaOAuth2RestTemplate") OAuth2RestOperations restOperations) {
        this.cpfContrato = cpfContrato;
        this.restOperations = restOperations;
    }

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header("x-cpf-usuario", cpfContrato);
            }
        };
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public OAuth2FeignRequestInterceptor oauth2FeignRequestInterceptor() {

        return new OAuth2FeignRequestInterceptor(restOperations.getOAuth2ClientContext(), restOperations.getResource());
    }
}
