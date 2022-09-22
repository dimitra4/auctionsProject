package pms.di.uoa.ecommerce.auctions.modeldb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic
    @Column(name = "username", nullable = false, length = 55)
    private String username;
    @Basic
    @Column(name = "password_id", nullable = false, length = 120)
    private String passwordId;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "tel_number", nullable = true, length = 55)
    private String telNumber;
    @Basic
    @Column(name = "fullname", nullable = true, length = 120)
    private String fullname;
    @Basic
    @Column(name = "country", nullable = true, length = 55)
    private String country;
    @Basic
    @Column(name = "location", nullable = true, length = 255)
    private String location;
    @Basic
    @Column(name = "enabled", nullable = true)
    private boolean enabled;
    @Basic
    @NonNull
    @Column(name = "registration_date", nullable = true)
    private Instant registrationDate;
    @Basic
    @Column(name = "role_role_id", nullable = true)
    private Integer roleRoleId;
    //@OneToMany(mappedBy = "usersByBidderUserId")
    //private Collection<Bids> bidsByUserId;
    //@OneToMany(mappedBy = "usersByCreatorUserId")
    //private Collection<Items> itemsByUserId;
    @ManyToOne
    @JoinColumn(name = "role_role_id", referencedColumnName = "role_id", insertable=false, updatable=false)
    private Role roleByRoleRoleId;

    @OneToMany(mappedBy = "usersByCreatorUserId")
    @JsonIgnoreProperties("usersByCreatorUserId")
    private List<Items> items;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(String passwordId) {
        this.passwordId = passwordId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }
    public Integer getRoleRoleId() {
        return roleRoleId;
    }

    public void setRoleRoleId(Integer roleRoleId) {
        this.roleRoleId = roleRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && Objects.equals(username, users.username)
                && Objects.equals(passwordId, users.passwordId) && Objects.equals(email, users.email)
                && Objects.equals(telNumber, users.telNumber) && Objects.equals(fullname, users.fullname)
                && Objects.equals(country, users.country) && Objects.equals(location, users.location)
                && Objects.equals(enabled, users.enabled) && Objects.equals(roleRoleId, users.roleRoleId)
                && Objects.equals(registrationDate, users.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, passwordId, email, telNumber, fullname, country, location,enabled, registrationDate, roleRoleId);
    }

//    public Collection<Bids> getBidsByUserId() {
//        return bidsByUserId;
//    }
//
//    public void setBidsByUserId(Collection<Bids> bidsByUserId) {
//        this.bidsByUserId = bidsByUserId;
//    }
//
//    public Collection<Items> getItemsByUserId() {
//        return itemsByUserId;
//    }
//
//    public void setItemsByUserId(Collection<Items> itemsByUserId) {
//        this.itemsByUserId = itemsByUserId;
//    }

    public Role getRoleByRoleRoleId() {
        return roleByRoleRoleId;
    }

    public void setRoleByRoleRoleId(Role roleByRoleRoleId) {
        this.roleByRoleRoleId = roleByRoleRoleId;
    }
}
