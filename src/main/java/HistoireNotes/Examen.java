package HistoireNotes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Comparator;

@AllArgsConstructor
@Getter
@Setter

public class Examen {
    private int id;
    private String titre;
    private Cours cours;
    private LocalDateTime dateTime;
    private int coefficient;

    public double getExamGrade (Examen examen, Etudiant etudiant, Instant t) {
        Note required_note = null;
        for (Note note : etudiant.getNotes()) {
            if (note.getExamen() == examen) {
                required_note = note;
            }
        }
        assert required_note != null;
        return required_note.getChangementNotes().stream()
                .filter(changementNote -> changementNote.getDate().isBefore(t))
                .max(Comparator.comparing(ChangementNote::getDate))
                .map(ChangementNote::getNote)
                .get();
    }
}
