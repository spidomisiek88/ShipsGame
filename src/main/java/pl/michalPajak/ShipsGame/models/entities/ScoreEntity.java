package pl.michalPajak.ShipsGame.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "score")
@Data
public class ScoreEntity {

    @Id
    @GeneratedValue
    private int id;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    private PlayerEntity player;
    private int score;
    @Column(name = "score_date")
    private LocalDate scoreDate;

}
