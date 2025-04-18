package com.zosh.model;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private  String name;

    @NotNull
    @Column(unique = true)
    private  String  categoryId;

    @ManyToOne
    private Category percentCategory;

    @NotNull
    private  Integer level;




}
