package HistoireNotes;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter

public class Etudiant extends Personne {
    private String groupe;
    private Tuteur tuteur;
    private List<Note> notes;

    public Etudiant(int id, String nom, String prenom, LocalDate dateNaissance, String email, String telephone, String groupe, Tuteur tuteur, List<Note> notes) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.groupe = groupe;
        this.tuteur = tuteur;
        this.notes = notes;
    }
}
