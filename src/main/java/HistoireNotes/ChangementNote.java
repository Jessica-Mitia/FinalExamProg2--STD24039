package HistoireNotes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter

public class ChangementNote {
    private double note;
    private Instant date;
    private String raison;
}
