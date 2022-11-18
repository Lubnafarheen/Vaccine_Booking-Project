package lexicon.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AppUser {

    private String username;
    private String password;
    private Set<Role> roles;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
        addRole(Role.ROLE_USER);
    }

    public AppUser(String username, String password, Role role) {
        setUsername(username);
        setPassword(password);
        addRole(role);
    }

    public AppUser(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        setRoles(roles);
    }

    public void addRole(Role role) {
        if (role == null) throw new IllegalArgumentException("Role was null");
        if (roles == null) roles = new HashSet<>();
        roles.add(role);
    }

    public void removeRole(Role role) {
        if (role == null) throw new IllegalArgumentException("Role was null");
        if (roles != null) roles.remove(role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(username, appUser.username) && Objects.equals(roles, appUser.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, roles);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null) throw new IllegalArgumentException("username must not be null");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) throw new IllegalArgumentException("password must not be null");
        if (password.length() < 8) throw new IllegalArgumentException("password must contain minimum of 8 characters");
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        if (roles == null) throw new IllegalArgumentException("roles must not be null");
        this.roles = roles;
    }
}
