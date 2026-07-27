package com.mifloreria.controlador;

import com.mifloreria.modelo.Usuario;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador que gestiona los servicios web de Registro e Inicio de Sesión
 * para MiFloreriaApp de forma eficiente.
 */
public class AuthServlet {

    // Simulación de base de datos en memoria para almacenar los usuarios registrados
    private static Map<String, String> baseDeDatosUsuarios = new HashMap<>();

    /**
     * Servicio web de Registro: Recibe un usuario y contraseña y los almacena.
     * @param usuario Objeto Usuario con las credenciales a registrar.
     * @return Mensaje indicando el éxito o el error del registro.
     */
    public String registrarUsuario(Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getPassword() == null || 
            usuario.getUsername().isEmpty() || usuario.getPassword().isEmpty()) {
            return "Error: El usuario y la contraseña son obligatorios.";
        }
        
        if (baseDeDatosUsuarios.containsKey(usuario.getUsername())) {
            return "Error: El nombre de usuario ya se encuentra registrado.";
        }
        
        baseDeDatosUsuarios.put(usuario.getUsername(), usuario.getPassword());
        return "Registro de usuario exitoso en MiFloreriaApp.";
    }

    /**
     * Servicio web de Inicio de Sesión: Valida las credenciales ingresadas.
     * @param usuario Objeto Usuario con las credenciales a validar.
     * @return Mensaje de autenticación satisfactoria o error.
     */
    public String iniciarSesion(Usuario usuario) {
        if (baseDeDatosUsuarios.containsKey(usuario.getUsername()) && 
            baseDeDatosUsuarios.get(usuario.getUsername()).equals(usuario.getPassword())) {
            return "Autenticación satisfactoria. ¡Bienvenido a MiFloreriaApp!";
        } else {
            return "Error en la autenticación: Usuario o contraseña incorrectos.";
        }
    }
}