package com.mifloreria.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de gestionar las peticiones web del inventario.
 * Actúa como Controlador en el patrón MVC.
 */
@WebServlet(name = "InventarioServlet", urlPatterns = {"/inventario"})
public class InventarioServlet extends HttpServlet {

    /**
     * Maneja las peticiones HTTP tipo GET (Por ejemplo, cuando el usuario entra a la página).
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Aquí luego conectaremos con la base de datos para pedir la lista de flores
        System.out.println("El gerente (Servlet) recibió la orden de mostrar el inventario.");
        
        // Redirigimos a la vista (la página web que crearemos más adelante)
        request.getRequestDispatcher("inventario.jsp").forward(request, response);
    }

    /**
     * Maneja las peticiones HTTP tipo POST (Por ejemplo, cuando se envía un formulario para crear una nueva flor).
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lógica futura para guardar una nueva flor
    }
}