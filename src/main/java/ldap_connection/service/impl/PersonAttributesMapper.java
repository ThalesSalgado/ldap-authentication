package ldap_connection.service.impl;

import ldap_connection.domain.Person;
import ldap_connection.domain.impl.DefaultPerson;
import org.springframework.ldap.core.AttributesMapper;


import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class PersonAttributesMapper implements AttributesMapper<Person> {

    @Override
    public Person mapFromAttributes(Attributes attrs) throws NamingException {
        Person user =  new DefaultPerson();

        if (attrs.get("cn") != null)
            user.setUserName((String) attrs.get("cn").get());

        if (attrs.get("cn") != null) {
            user.setFirstName((String) attrs.get("cn").get());
        }

        if (attrs.get("sn") != null) {
            user.setLastName((String) attrs.get("sn").get());
        }

        if (attrs.get("mail") != null) {
            user.setEmail((String) attrs.get("mail").get());
        }

        if (attrs.get("sAMAccountName") != null)
            user.setLogin((String) attrs.get("sAMAccountName").get());

        //Teste se é possivel pegar os grupos aqui
        if (attrs.get("memberOf") != null)
            user.setGroups(attrs.get("memberOf").get());

        return user;
    }
}
