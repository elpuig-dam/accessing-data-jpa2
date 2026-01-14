package com.example.accessing_data_jpa.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidencies")
public class Incident {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titol;

    //@Lob // Per a textos llargs (es traduirà a CLOB o TEXT) per H2
    @Column(columnDefinition = "TEXT") //per postgresql
    private String descripcio;

    private LocalDateTime dataObertura = LocalDateTime.now();

    private String estat; // Ex: "OBERTA", "TANCADA", "EN_PROCÉS"

    // --- Aquí la relació inversa ---
    // Moltes incidències pertanyen a un client.

    @ManyToOne(fetch = FetchType.LAZY) // LAZY és gairebé sempre millor
    @JoinColumn(name = "customer_id") // Aquesta serà la COLUMNA de la clau forana
    private Customer customer;

    // Constructors, Getters i Setters...

    public Customer getCustomer() {
        return customer;
    }

    protected void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }


    public void setEstat(String estat) {
        this.estat = estat;
    }

    // Important: Cal sobreescriure equals() i hashCode()
    // si es treballa amb entitats fora de la transacció (DTOs, etc.),
    // però per a un exemple inicial, ho podem ometre.


    public Long getId() {
        return id;
    }

    public String getTitol() {
        return titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public LocalDateTime getDataObertura() {
        return dataObertura;
    }

    public String getEstat() {
        return estat;
    }
}
