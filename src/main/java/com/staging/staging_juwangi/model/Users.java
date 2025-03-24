package com.staging.staging_juwangi.model;
import javax.persistence.*;


@Entity
@Table(name = "users")
public class
Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "kontak")
    private String kontak;

    @Column(name = "umur")
    private Long umur;

    @Column(name = "status")
    private String status;

    @Column(name = "password")
    private String password;

    @Column(name = "negara")
    private String negara;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public Long getUmur() {
        return umur;
    }

    public void setUmur(Long umur) {
        this.umur = umur;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole(){
        return "USERS";
    }


}