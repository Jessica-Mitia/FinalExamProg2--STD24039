package HistoireNotes;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter

public class Tuteur extends Personne {
    String lien;

    public Tuteur(int id, String nom, String prenom, LocalDate dateNaissance, String email, String telephone, String lien) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.lien = lien;
    }
}
