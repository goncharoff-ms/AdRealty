package my.project.domain;


import javax.persistence.*;
import java.util.Set;

/**
 * POJO класс для пользователя
 * @author Max Goncharov
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * id пользователя
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * логин
     */
    @Column(name = "login")
    private String login;

    /**
     * имя
     */
    @Column(name = "name")
    private String name;

    /**
     * пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * телефон
     */
    @Column(name = "phone")
    private String phone;

    /**
     * email
     */
    @Column(name = "email")
    private String email;

    /**
     * id {@link Role}
     */
    @Column(name = "role_id")
    private Long roleId;



    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {

    }

    public User(String login, String name, String password, String phone, String email, Long roleId) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
