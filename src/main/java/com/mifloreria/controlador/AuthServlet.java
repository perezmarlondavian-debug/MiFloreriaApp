package com.mifloreria.controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mifloreria.modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Servlet REST que expone los servicios de Registro e Inicio de Sesión
 * para MiFloreriaApp.
 */
@WebServlet("/api/auth/*")
public class AuthServlet extends HttpServlet {

    private static final Map<String, String> baseDeDatosUsuarios = new ConcurrentHashMap<>();
    private static final int BCRYPT_ROUNDS = 12;
    private static final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo(); // "/registrar" o "/login"

        Usuario usuario;
        try {
            usuario = gson.fromJson(request.getReader(), Usuario.class);
        } catch (Exception e) {
            enviarRespuesta(response, HttpServletResponse.SC_BAD_REQUEST, "Error: el cuerpo enviado no es un JSON válido.");
            return;
        }

        if (pathInfo == null) {
            enviarRespuesta(response, HttpServletResponse.SC_NOT_FOUND, "Ruta no encontrada. Usa /api/auth/registrar o /api/auth/login.");
            return;
        }

        switch (pathInfo) {
            case "/registrar" -> {
                String resultado = registrarUsuario(usuario);
                int status = resultado.startsWith("Error")
                        ? HttpServletResponse.SC_BAD_REQUEST
                        : HttpServletResponse.SC_CREATED;
                enviarRespuesta(response, status, resultado);
            }
            case "/login" -> {
                String resultado = iniciarSesion(usuario);
                int status = resultado.startsWith("Error")
                        ? HttpServletResponse.SC_UNAUTHORIZED
                        : HttpServletResponse.SC_OK;
                enviarRespuesta(response, status, resultado);
            }
            default -> enviarRespuesta(response, HttpServletResponse.SC_NOT_FOUND,
                    "Ruta no encontrada. Usa /api/auth/registrar o /api/auth/login.");
        }
    }

    private String registrarUsuario(Usuario usuario) {
        if (usuario == null || esVacio(usuario.getUsername()) || esVacio(usuario.getPassword())) {
            return "Error: El usuario y la contraseña son obligatorios.";
        }

        String username = usuario.getUsername().trim();

        if (usuario.getPassword().length() < 8) {
            return "Error: La contraseña debe tener al menos 8 caracteres.";
        }

        String hash = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt(BCRYPT_ROUNDS));
        String existente = baseDeDatosUsuarios.putIfAbsent(username, hash);

        if (existente != null) {
            return "Error: El nombre de usuario ya se encuentra registrado.";
        }

        return "Registro de usuario exitoso en MiFloreriaApp.";
    }

    private String iniciarSesion(Usuario usuario) {
        if (usuario == null || esVacio(usuario.getUsername()) || esVacio(usuario.getPassword())) {
            return "Error en la autenticación: Usuario o contraseña incorrectos.";
        }

        String hashAlmacenado = baseDeDatosUsuarios.get(usuario.getUsername().trim());

        boolean valido = hashAlmacenado != null
                && BCrypt.checkpw(usuario.getPassword(), hashAlmacenado);

        if (valido) {
            return "Autenticación satisfactoria. ¡Bienvenido a MiFloreriaApp!";
        }
        return "Error en la autenticación: Usuario o contraseña incorrectos.";
    }

    private boolean esVacio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    private void enviarRespuesta(HttpServletResponse response, int status, String mensaje) throws IOException {
        response.setStatus(status);
        response.getWriter().write(gson.toJson(Map.of("mensaje", mensaje)));
    }
}