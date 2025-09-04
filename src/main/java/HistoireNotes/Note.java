package HistoireNotes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter

public class Note {
    private int id;
    private Examen examen;
    private List<ChangementNote> changementNotes;
}
