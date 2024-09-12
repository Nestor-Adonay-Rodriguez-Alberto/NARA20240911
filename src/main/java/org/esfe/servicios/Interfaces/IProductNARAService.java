package org.esfe.servicios.Interfaces;

import org.esfe.dtos.ProductNARA.ProductNARAGuardar;
import org.esfe.dtos.ProductNARA.ProductNARAModificar;
import org.esfe.dtos.ProductNARA.ProductNARASalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductNARAService
{
    List<ProductNARASalida> obtenerTodos();

    Page<ProductNARASalida> obtenerTodosPaginados(Pageable pageable);

    ProductNARASalida obtenerPorId(Integer id);

    ProductNARASalida crear(ProductNARAGuardar productNARAGuardar);

    ProductNARASalida editar(ProductNARAModificar productNARAModificar);

    void eliminarPorId(Integer id);
}
