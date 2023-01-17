package com.quicktutorials.learnmicroservices.AccountMicroservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="operations")
@AllArgsConstructor @NoArgsConstructor
public class Operation {

    //String ID, Date DATE, Double VALUE, String DESCRIPTION, String FK_ACCOUNT1, String FK_ACCOUNT2

    @Id
    @Column(name="ID")
    @Getter @Setter
    @NotBlank @NotNull @NotEmpty
    private String id;

    @Column(name="DATE")
    @Getter @Setter
    private Date date;

    @Column(name="DESCRIPTION")
    @Getter @Setter
    private String description;

    @Column(name="VALUE")
    @Getter @Setter
    @NotNull
    private Double value;

    @Column(name="FK_ACCOUNT1")
    @Getter @Setter
    @NotNull @NotBlank @NotEmpty
    private String fkAccount1;

    @Column(name="FK_ACCOUNT2")
    @Getter @Setter
    private String fkAccount2;

    
    //questo metodo con questa annotation prende in automatico la data e setta la variabile "date"
    //che poi vediamo che ha i suoi getter setter 
    @PrePersist
    void getTimeOperation() {
        this.date = new Date();
    }
}

