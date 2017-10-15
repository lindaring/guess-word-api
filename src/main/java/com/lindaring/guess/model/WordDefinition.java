package com.lindaring.guess.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name="word_definition", catalog="db_guessword", schema="")
@XmlRootElement
public class WordDefinition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;
    @JoinColumn(name="word_id", referencedColumnName="word_id")
    @ManyToOne(optional=false)
    private Word word;
    @JoinColumn(name="definition_id", referencedColumnName="definition_id")
    @ManyToOne(optional=false)
    private Definition definition;

    public WordDefinition(Integer id) {
        this.id = id;
    }
    
}
