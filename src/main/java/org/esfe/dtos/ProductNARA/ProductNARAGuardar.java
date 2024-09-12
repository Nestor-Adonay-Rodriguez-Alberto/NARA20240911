package org.esfe.dtos.ProductNARA;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
public class ProductNARAGuardar implements Serializable
{
    //ATRIBUTOS:
    private String NombreNARA;
    private String DescripcionNARA;
    private BigDecimal Precio;
}
