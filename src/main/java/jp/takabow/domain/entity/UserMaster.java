package jp.takabow.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_master", schema = "quarkus_main")
public class UserMaster implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "mail_address", nullable = false)
    @Email
    private String mailAddress;
    @Column(name = "address", nullable = false)
    private String address;

    public UserMaster() {
    }

    public UserMaster(Long id, String userName, @Email String mailAddress, String address) {
        this.id = id;
        this.userName = userName;
        this.mailAddress = mailAddress;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserMaster that = (UserMaster) o;

        return Objects.equals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getUserName(), this.getMailAddress(), this.getAddress());
    }

    @Override
    public String toString() {
        return "UserMaster{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
