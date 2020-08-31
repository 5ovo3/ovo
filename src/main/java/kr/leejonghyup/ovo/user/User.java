package kr.leejonghyup.ovo.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "UserInfo")
public class User {

    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "tel")
    private String tel;
    @Column(name = "delete_yn")
    private String delete_yn;
    @Column(name = "reg_date")
    private String reg_date;
}
