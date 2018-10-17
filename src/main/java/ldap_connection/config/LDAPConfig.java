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
        contextSource.setUrl("");
        contextSource.setBase("");
        contextSource.setUserDn("");
        contextSource.setPassword("");
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
