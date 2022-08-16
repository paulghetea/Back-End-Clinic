package com.softtek;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

//Son los recursos del servidor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
 
    @Value("${security.signing-key}")
    private String signingKey;
 
    @Value("${security.encoding-strength}")
    private Integer encodingStrength;
 
    @Value("${security.security-realm}")
    private String securityRealm;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired    
    private UserDetailsService userDetailsService;        

    @Autowired
    private DataSource dataSource;    

    //Encripta la contraseña
    @Bean
    public BCryptPasswordEncoder passwordEnconder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();        
        return bCryptPasswordEncoder;
    }

    
    //Maneja las autentificaciones
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //Coje el usuario y encripta la contraseña
    @Autowired    
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }

    //Para que sea una sesion sin estados
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http        
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .httpBasic()
        .realmName(securityRealm)
        .and()
        .csrf()
        .disable();                
    }
    
    //Metodo que obtener el servicio del token por defecto
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);            
        defaultTokenServices.setReuseRefreshToken(false);    
        return defaultTokenServices;
    }
    
    //Convierte el token en el mismo tipo de encriptacion que la signingKey (declarada en app.propierties)
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signingKey);
        return converter;
    }

    //Sirve para guardar el token en ram
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter()); //EN MEMORIA
        //return new JdbcTokenStore(this.dataSource); //EN BASE DE DATOS
    }




}