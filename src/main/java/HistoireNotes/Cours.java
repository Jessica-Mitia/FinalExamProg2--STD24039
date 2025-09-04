package HistoireNotes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode

public class Cours {
    public enum Label {
        PROG1, PROG2, WEB1, WEB2
    }

    private int id;
    private Label label;
    private int credit;
    private Enseignant enseignant;

    public double getCourseGrade(Cours cours, Etudiant etudiant, Instant t) {
        List<Note> notes = etudiant.getNotes().stream()
                                .filter(note -> note.getExamen().getCours() == cours).toList();
        for (Note note : notes) {
            List<ChangementNote> res = note.getChangementNotes().stream()
                                .filter(changementNote -> changementNote.getDate().isBefore(t))
                                .toList();
        }

    }
}
