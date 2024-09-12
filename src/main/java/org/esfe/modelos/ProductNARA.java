package org.esfe.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ProductsNARA")
public class ProductNARA
{
    // ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Id;

    @NotBlank(message = "El nombre es requerido")
    public String NombreNARA;

    public String DescripcionNARA;

    @NotNull(message = "El precio es requerido")
    public BigDecimal Precio;


    // Accesors:
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getNombreNARA() {
        return NombreNARA;
    }
    public void setNombreNARA(@NotBlank(message = "El nombre es requerido") String nombreNARA) {
        NombreNARA = nombreNARA;
    }

    public String getDescripcionNARA() {
        return DescripcionNARA;
    }
    public void setDescripcionNARA(String descripcionNARA) {
        DescripcionNARA = descripcionNARA;
    }

    public @NotNull(message = "El precio es requerido") BigDecimal getPrecio() {
        return Precio;
    }
    public void setPrecio(@NotNull(message = "El precio es requerido") BigDecimal precio) {
        Precio = precio;
    }
}
