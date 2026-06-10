<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario - Mi Florería</title>
    <style>
        /* Estilos básicos para cumplir con un diseño limpio */
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
    </style>
</head>
<body>

    <h2>Gestión de Inventario - Mi Florería App</h2>
    <p>Módulo de visualización de productos registrados en el sistema.</p>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre de la Flor</th>
                <th>Precio Unitario</th>
                <th>Stock Acumulado</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Rosas Rojas</td>
                <td>$ 5000.0</td>
                <td>120</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Girasoles</td>
                <td>$ 8000.0</td>
                <td>45</td>
            </tr>
        </tbody>
    </table>

</body>
</html>