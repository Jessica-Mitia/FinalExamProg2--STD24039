package HistoireNotes;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public abstract class Personne {
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String email;
    private String telephone;
}
