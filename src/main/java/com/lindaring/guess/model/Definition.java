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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name="definition", catalog="db_guessword", schema="")
public class Definition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="definition_id")
    private Integer definitionId;
    @Basic(optional=false)
    @NotNull
    @Lob
    @Size(min=1, max=65535)
    @Column(name="meaning")
    private String meaning;
    @JoinColumn(name="pos_id", referencedColumnName="pos_id")
    @ManyToOne(optional=false)
    private Pos pos;

    public Definition(Integer definitionId) {
        this.definitionId = definitionId;
    }
    
}
