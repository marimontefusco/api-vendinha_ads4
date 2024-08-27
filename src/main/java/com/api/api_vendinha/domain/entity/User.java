package com.api.api_vendinha.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity //entity -> classe responsável por comunicar com o BD
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    //Atributos -> igual data.sql
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String password;

    @Column(name="cpf ou cnpj", nullable=false)
    private String cpf_cnpj;

}