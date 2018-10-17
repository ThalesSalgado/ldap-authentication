package ldap_connection.service.impl;

import ldap_connection.domain.Person;
import ldap_connection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.*;

import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private LdapTemplate ldapTemplate;

    public Person getUser(final String userName) {

        List<Person> person = ldapTemplate.search(query()
                .where("objectclass").is("person").and("mail").like(userName+"@tqi.com.br"), new PersonAttributesMapper());

        if(person.size()==0)
           return null;

        return person.get(0) ;

    }


    public Boolean testConn(String username, String password){
        Filter filter = new EqualsFilter("sAMAccountName",username);
        return ldapTemplate.authenticate("OU=TQI",filter.encode(),password);

    }


}
