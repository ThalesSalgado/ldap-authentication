package ldap_connection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LDAPConfig {

    @Bean
    public LdapContextSource contextSource()
    {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("url do serv ldap");
        contextSource.setBase("nos base do serv para procurar");
        contextSource.setUserDn("usuario do serv ldap");
        contextSource.setPassword("senha do usuario");
        contextSource.setPooled(false);
        contextSource.setReferral("follow");
        contextSource.afterPropertiesSet();

        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(){
        LdapTemplate ldapTemplate = new LdapTemplate(contextSource());
       // ldapTemplate.setIgnorePartialResultException(true);

        return ldapTemplate;
    }
}
