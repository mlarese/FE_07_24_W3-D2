package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "casa_editrice")
public class CasaEditrice {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome_casa_editrice", nullable = false, length = 50)
    private String nome;
    @Column( length = 50)
    private String citta;
    @Column( length = 50)
    private String email;
    @Column( length = 50)
    private String telefono;
}
