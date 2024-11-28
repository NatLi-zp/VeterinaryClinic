package com.example.veterinaryclinicnew.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return id == visit.id && Objects.equals(date, visit.date) && Objects.equals(comment, visit.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, comment);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }
}
