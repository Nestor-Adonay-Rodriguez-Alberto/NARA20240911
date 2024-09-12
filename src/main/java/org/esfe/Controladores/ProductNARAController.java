package org.esfe.Controladores;

import org.esfe.dtos.ProductNARA.ProductNARAGuardar;
import org.esfe.dtos.ProductNARA.ProductNARAModificar;
import org.esfe.dtos.ProductNARA.ProductNARASalida;
import org.esfe.servicios.Implementaciones.ProductNARAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ProductNARA")
public class ProductNARAController
{
    // Puente con DB:
    @Autowired
    private ProductNARAService _ProductNARAService;


    @GetMapping
    public ResponseEntity<Page<ProductNARASalida>> mostrarTodosPaginados(Pageable pageable)
    {
        Page<ProductNARASalida> Lista_Productos = _ProductNARAService.obtenerTodosPaginados(pageable);
        if(Lista_Productos.hasContent()){
            return ResponseEntity.ok(Lista_Productos);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/lista")
    public ResponseEntity<List<ProductNARASalida>> mostrarTodos()
    {
        List<ProductNARASalida> Lista_Productos = _ProductNARAService.obtenerTodos();
        if(!Lista_Productos.isEmpty()){
            return ResponseEntity.ok(Lista_Productos);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductNARASalida> buscarPorId(@PathVariable Integer id)
    {
        ProductNARASalida producto = _ProductNARAService.obtenerPorId(id);

        if(producto != null){
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<ProductNARASalida> crear(@RequestBody ProductNARAGuardar productNARAGuardar)
    {
        ProductNARASalida producto = _ProductNARAService.crear(productNARAGuardar);
        return ResponseEntity.ok(producto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductNARASalida> editar(@PathVariable Integer id, @RequestBody ProductNARAModificar productNARAModificar)
    {
        ProductNARASalida producto = _ProductNARAService.editar(productNARAModificar);
        return ResponseEntity.ok(producto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id)
    {
        _ProductNARAService.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }

}
