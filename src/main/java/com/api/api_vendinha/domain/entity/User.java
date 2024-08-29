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
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String password;

    @Column(name="cpf_cnpj", nullable=false)
    private String cpf_cnpj;

    @Column(name="is_active")
    private Boolean is_active;

}