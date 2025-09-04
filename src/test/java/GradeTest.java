import HistoireNotes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class GradeTest {
    Cours cours1;
    Cours cours2;
    Examen examen;
    Examen examen2;
    Enseignant enseignant1;
    Enseignant enseignant2;
    Tuteur tuteur;
    Etudiant etudiant;
    Note note1;
    Note note2;
    ChangementNote changementNote1;
    ChangementNote changementNote2;
    ChangementNote changementNote3;


    @BeforeEach
    public void setUp() {
        enseignant1 = new Enseignant(1, "Ramarozaka", "Toky", LocalDate.now(),
                "toky@gmail.com", "0327068618", Enseignant.Specialite.BACKEND);
        cours1 = new Cours(1, Cours.Label.PROG1, 4, enseignant1 );
        cours2 = new Cours(2, Cours.Label.PROG2, 4, enseignant1);
        examen = new Examen(1, "Examen final", cours1, LocalDateTime.now(), 2);
        examen2 = new Examen(2, "Examen", cours1, LocalDateTime.now(), 3);
        changementNote1 = new ChangementNote(17, Instant.parse("2025-01-01T08:00:00Z"), "bonus +2");
        changementNote2 = new ChangementNote(10, Instant.parse("2025-01-02T08:00:00Z"), "malus -7");
        changementNote3 = new ChangementNote(15, Instant.parse("2025-01-01T08:00:00Z"), "bonus +1");

        var changementNote = List.of(changementNote1, changementNote2);
        note1 = new Note(1, examen, changementNote);
        note2 = new Note(2, examen2, List.of(changementNote3));
        var note = List.of(note1, note2);

        tuteur = new Tuteur(1, "Fitia", "Princia", LocalDate.now(),
                "princia@gmail.com", "0341102130", "Mère");
        etudiant = new Etudiant(1, "Lovamanitra", "Mario", LocalDate.now(),
                "mario@gmail.com", "0340731748", "K1", tuteur, note);
    }

    @Test
    public void geExamGradeTest() {
        double res = examen.getExamGrade(examen, etudiant, Instant.parse("2025-01-01T09:00:00Z"));
        double res2 = examen.getExamGrade(examen, etudiant, Instant.parse("2025-01-02T09:00:00Z"));
        assertEquals(17, res);
        assertEquals(10, res2);
    }

    @Test
    public void getCourseGradeTest() {
        double res = cours1.getCourseGrade(cours1, etudiant, Instant.parse("2025-01-02T09:00:00Z"));
        assertEquals(13, res);
    }
}
