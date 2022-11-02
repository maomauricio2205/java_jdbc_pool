package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {


            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();


            System.out.println("============= listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.porId(2L));


/*            System.out.println("============= insertar nuevo producto =============");
            Producto producto = new Producto();
            producto.setNombre("Teclado mecánico");
            producto.setPrecio(500);
            producto.setFechaRegistro(new Date());
            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println);*/


            System.out.println("============= insertar nuevo producto con categoria =============");
            Producto producto2 = new Producto();
            producto2.setNombre("NoteBook Omen HP");
            producto2.setPrecio(2900);
            producto2.setFechaRegistro(new Date());
            //le asignamos una categoria
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto2.setCategoria(categoria);
            // ********** fin asignacion categoria ******
            repositorio.guardar(producto2);
            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println);


    }
}
