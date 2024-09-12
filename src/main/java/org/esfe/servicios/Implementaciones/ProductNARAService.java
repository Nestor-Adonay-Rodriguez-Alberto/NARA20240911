package org.esfe.servicios.Implementaciones;

import org.esfe.dtos.ProductNARA.ProductNARAGuardar;
import org.esfe.dtos.ProductNARA.ProductNARAModificar;
import org.esfe.dtos.ProductNARA.ProductNARASalida;
import org.esfe.modelos.ProductNARA;
import org.esfe.repositorios.IProductNARARepository;
import org.esfe.servicios.Interfaces.IProductNARAService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductNARAService implements IProductNARAService
{
    // Representa la DB:
    @Autowired
    private IProductNARARepository _IProductNARARepository;

    @Autowired
    private ModelMapper modelMapper;


    // Retorna Todos Los Registros De La Tabla:
    @Override
    public List<ProductNARASalida> obtenerTodos()
    {
        List<ProductNARA> Lista_Productos = _IProductNARARepository.findAll();

        return Lista_Productos.stream()
                .map(producto -> modelMapper.map(producto, ProductNARASalida.class))
                .collect(Collectors.toList());
    }


    // Retorna Todos Los Registros De La Tabla:
    @Override
    public Page<ProductNARASalida> obtenerTodosPaginados(Pageable pageable)
    {
        Page<ProductNARA> page = _IProductNARARepository.findAll(pageable);

        List<ProductNARASalida> Lista_ProductosDto = page.stream()
                .map(producto -> modelMapper.map(producto, ProductNARASalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(Lista_ProductosDto, page.getPageable(), page.getTotalElements());
    }


    // Obtiene Un Registro Con Ese Mismo ID:
    @Override
    public ProductNARASalida obtenerPorId(Integer id)
    {
        return modelMapper.map(_IProductNARARepository.findById(id).get(), ProductNARASalida.class);
    }


    // Recibe un Objeto y lo Guarda En La DB:
    @Override
    public ProductNARASalida crear(ProductNARAGuardar productNARAGuardar)
    {
        ProductNARA producto = _IProductNARARepository.save(modelMapper.map(productNARAGuardar, ProductNARA.class));
        return modelMapper.map(producto, ProductNARASalida.class);
    }


    // Obtiene un Objeto y lo busca en la DB y lo modifica:
    @Override
    public ProductNARASalida editar(ProductNARAModificar productNARAModificar)
    {
        ProductNARA producto = _IProductNARARepository.save(modelMapper.map(productNARAModificar, ProductNARA.class));
        return modelMapper.map(producto, ProductNARASalida.class);
    }

    // Elimina el registro de la DB con ese ID:
    @Override
    public void eliminarPorId(Integer id)
    {
        _IProductNARARepository.deleteById(id);
    }

}
