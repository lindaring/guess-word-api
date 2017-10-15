package com.lindaring.guess.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@XmlRootElement
@Table(name="word", catalog="db_guessword", schema="")
public class Word implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="word_id")
    private Integer wordId;
    @Basic(optional=false)
    @NotNull
    @Size(min=1, max=255)
    @Column(name="word")
    private String word;
    @Basic(optional=false)
    @NotNull
    @Column(name="enabled")
    private int enabled;

    public Word(Integer wordId) {
        this.wordId = wordId;
    }
    
}
