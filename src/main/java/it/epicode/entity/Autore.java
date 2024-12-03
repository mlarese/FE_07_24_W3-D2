package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "autori")
@Data
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // , unique = true
    @Column(name = "nome_autore", nullable = false , length = 50)
    private String nome;

    @Column(name = "cognome_autore", nullable = false, length = 50)
    private String cognome;

    @Column(name = "anno_nascita")
    private Integer annoNascita;

}
