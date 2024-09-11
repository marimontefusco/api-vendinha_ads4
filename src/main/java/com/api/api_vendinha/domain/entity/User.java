package com.api.api_vendinha.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity //entity -> classe responsável por representar a tabela e comunicar com o BD
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

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="senha", nullable = false)
    private String password;

    @Column(name="cpf_cnpj", nullable=false)
    private String cpf_cnpj;

    @Column(name="is_active", nullable = false)
    private Boolean is_active;

}