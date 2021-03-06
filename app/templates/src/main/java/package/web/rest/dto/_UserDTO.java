package <%=packageName%>.web.rest.dto;
<% if (openidconnectAuth == 'yes') { %>
import <%=packageName%>.domain.ExternalAccount;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
<% } %>
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDTO {

    @Pattern(regexp = "^[a-z0-9]*$")
    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    <% if (openidconnectAuth != 'yes') { %> 
    @NotNull
    @Size(min = 5, max = 100) <% } %><% if (openidconnectAuth == 'yes') { %>
    @Size(min = 0, max = 100) <% } %>
    private String password;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 100)
    private String email;

    @Size(min = 2, max = 5)
    private String langKey;

    private List<String> roles;<% if (openidconnectAuth == 'yes') { %>

    private Set<ExternalAccount> externalAccounts = new HashSet<>();
<% } %>

    public UserDTO() {
    }

    public UserDTO(String login, String password, String firstName, String lastName, String email, String langKey,
                   List<String> roles) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.langKey = langKey;
        this.roles = roles;
    }
    
    <% if (openidconnectAuth == 'yes') { %>

    public UserDTO(String login, String password, String firstName, String lastName, String email, String langKey,
                   List<String> roles, Set<ExternalAccount> externalAccounts) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.langKey = langKey;
        this.roles = roles;
        this.externalAccounts = externalAccounts;
    }

    public UserDTO(String firstName, String lastName, String email, ExternalAccount externalAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.externalAccounts.add(externalAccount);
    }
    <% } %>

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLangKey() {
        return langKey;
    }

    public List<String> getRoles() {
        return roles;
    }<% if (openidconnectAuth == 'yes') { %>

    public Set<ExternalAccount> getExternalAccounts() {
        return Collections.unmodifiableSet(externalAccounts);
    }
    <% } %>
    @Override
    public String toString() {
        return "UserDTO{" +
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", langKey='" + langKey + '\'' +
        ", roles=" + roles +<% if (openidconnectAuth == 'yes') { %>
        ", externalAccounts=" + externalAccounts + <% } %>
        '}';
    }
}
