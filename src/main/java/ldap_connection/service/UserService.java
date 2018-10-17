package ldap_connection.service;

import ldap_connection.domain.Person;

public interface UserService {

    public Person getUser(final String userName);
    public Boolean testConn(String username, String password);
}
