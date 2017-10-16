package com.lindaring.guess.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@XmlRootElement
@Table(name="user", catalog="db_guessword", schema="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="user_id")
    private Integer userId;
    @Basic(optional=false)
    @NotNull
    @Size(min=1, max=255)
    @Column(name="name")
    private String name;
    @Basic(optional=false)
    @NotNull
    @Column(name="score")
    private int score;

    public User(Integer userId) {
        this.userId = userId;
    }
    
}
