package com.github.youssfbr.clients.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{name.required}")
    private String name;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{cpf.required}")
    @CPF(message = "{cpf.invalid}")
    private String cpf;

    @Column(name = "date_register", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegister;

    @PrePersist
    private void prePersist() {
        setDateRegister(LocalDate.now());
    }

}
