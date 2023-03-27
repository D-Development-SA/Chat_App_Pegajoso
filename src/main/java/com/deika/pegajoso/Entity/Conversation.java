package com.deika.pegajoso.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @NotNull
    @Column(nullable = false)
    private String text;

    private String nameMultimedia;

    @NotNull
    @Column(nullable = false)
    private String time;

    @NotNull
    @Column(nullable = false)
    private String date;

    @PrePersist
    public void generateDateTime(){
        time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
