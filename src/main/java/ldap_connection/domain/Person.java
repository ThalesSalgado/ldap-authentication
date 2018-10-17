package ldap_connection.domain;

public interface Person {

    public String getUserName();

    public void setUserName(String userName);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getEmail();

    public void setEmail(String email);

    public String getLogin();

    public void setLogin(String login);

    public Object getGroups();

    public void setGroups(Object groups);
}