package com.example.veterinaryclinicnew.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

//    public Pet(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    //    @ManyToOne
//    @JoinColumn(name = "visit_id", referencedColumnName = "id")
//    private Visit visit;

}
