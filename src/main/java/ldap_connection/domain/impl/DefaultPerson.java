package ldap_connection.domain.impl;

import ldap_connection.domain.Person;

public class DefaultPerson implements Person {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private Object groups;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Object getGroups() {
        return groups;
    }

    public void setGroups(Object groups) {
        this.groups = groups;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("UserImpl[");
        buffer.append(" userName = ").append(userName);
        buffer.append(" email = ").append(email);
        buffer.append(" firstName = ").append(firstName);
        buffer.append(" lastName = ").append(lastName);
        buffer.append("]");
        return buffer.toString();
    }
}
