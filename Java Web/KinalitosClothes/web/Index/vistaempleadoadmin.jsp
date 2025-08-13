<%-- Document : vistaproductoadmin Created on : 22 jul 2025, 13:12:45 Author : PC --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta https-equiv=" X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CRUD_Empleado</title>
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/Images/Logo_K.C.png">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/vistaempleadoadmin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    </head>

    <body>
        <nav class="navbar">
            <div class="nav-content">
                <div class="logo">K<span>C</span></div>
                <ul class="menu">
                    <li><a href="Controlador?menu=vistaadmin">Menu</a></li>
                    <li><a href="${pageContext.request.contextPath}/Index/vistaclientesadmin.jsp">Cliente</a></li>
                    <li><a href="${pageContext.request.contextPath}/Index/vistaproveedoradmin.jsp">Proveedor</a></li>
                    <li><a href="${pageContext.request.contextPath}/Index/vistacategoria.jsp">Categoria</a></li>
                    <li><a href="${pageContext.request.contextPath}/Index/metodopagoadmin.jsp">Metodo P.</a></li>
                    <li><a href="${pageContext.request.contextPath}/Index/vistaproductoadmin.jsp">Producto</a></li>
                    <li><a href="${pageContext.request.contextPath}/Index/vistapedidoadmin.jsp">Pedido</a></li>
                    <li><a href="${pageContext.request.contextPath}/Index/vistadetallepedidoadmin.jsp">Detalle P.</a></li>
                    <li><a href="${pageContext.request.contextPath}/Index/VistaFacturaAdmin.jsp">Factura</a></li>
                </ul>
            </div>
        </nav>

        <section>
            <div class="container">
                <h1>Bienvenido al CRUD completo de la entidad <b>Empleados</b></h1>
                <!--apartado y actualizar para crear el empleado-->
                <div class="section">
                    <h2>Agregar o actualizar empleado</h2>
                    <form action="Controlador?menu=vistaempleadoadmin" method="POST">
                        <div class="form-row">
                            <div class="form-group">
                                <input type="text" class="entrada_texto" name="txtNombreEmpleado" id="txtNombreEmpleado" value="${empleado.getNombreEmpleado()}" required>
                                <label class="label-input">Nombre Empleado</label>
                            </div>
                            <div class="form-group">
                                <input type="text" class="entrada_texto" name="txtApellidoEmpleado" id="txtApellidoEmpleado" value="${empleado.getApellidoEmpleado()}" required>
                                <label class="label-input">Apellido Empleado</label>
                            </div>
                            <div class="form-group">
                                <input type="text" class="entrada_texto" name="txtCorreoEmpleado" id="txtCorreoEmpleado" value="${empleado.getCorreoEmpleado()}" required>
                                <label class="label-input">Correo</label>
                            </div>
                            <div class="form-group">
                                <input type="text" class="entrada_texto" name="txtTelefonoEmpleado" id="txtTelefonoEmpleado" value="${empleado.getTelefonoEmpleado()}" required>
                                <label class="label-input">Telefono</label>
                            </div>
                            <div class="form-group">
                                <input type="text" class="entrada_texto" name="txtDireccionEmpleado" id="txtDireccionEmpleado" value="${empleado.getDireccionEmpleado()}" required>
                                <label class="label-input">Dirección</label>
                            </div>
                            <div class="form-group">
                                <input type="text" class="entrada_texto" name="txtCodigoUsuario"  id="txtCodigoUsuario" value="${empleado.getCodigoUsuario()}" required>
                                <label class="label-input">Codigo de Usuario</label>
                            </div>

                            <button type="submit" class="btn_crear_producto" values="Agregar">
                                <span class="bnt_texto">Crear Empleado</span>
                                <span class="btn_icono">
                                    <i class="fa-solid fa-plus"></i>
                                </span>
                            </button>

                            <button type="button" class="btn_actualizar">
                                <span class="bnt_texto">Actualizar</span>
                                <span class="btn_icono">
                                    <i class="fa-solid fa-pen-to-square"></i>
                                </span>
                            </button>
                        </div>

                    </form>
                </div>

                <!-- el buscar y listar -->
                <div class="section">
                    <h2>Lista</h2>
                    <!-- 
                    <form>
                        <div class="form-row">
                            <div class="form-group">
                                <input type="number" class="entrada_texto" name="id" min="1" placeholder="0"
                                    required id="numBuscarCodProducto">
                                <label class="label-input-number">ID del producto a buscar</label>
                            </div>
                        </div>
                        <button type="button" class="btn_buscar">
                            <span class="bnt_texto">Buscar Producto</span>
                            <span class="btn_icono">
                                <i class="fa fa-search"></i></i>
                            </span>
                        </button>
                    </form> -->
                    <div class="table-container">
                        <table>
                            <thead>
                                <tr>
                                    <th scope="col">Codigo del Empleado</th>
                                    <th scope="col">Nombre Empleado</th>
                                    <th scope="col">Apellido Empleado</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Dirección</th>
                                    <th scope="col">Codigo Usuario</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="empleados" items="${empleados}">
                                    <tr>                             
                                        <td>${empleados.getCodigoEmpleado()}</td>
                                        <td>${empleados.getNombreEmpleado()}</td>
                                        <td>${empleados.getApellidoEmpleado()}</td>
                                        <td>${empleados.getCorreoEmpleado()}</td>
                                        <td>${empleados.getTelefonoEmpleado()}</td>
                                        <td>${empleados.getDireccionEmpleado()}</td>
                                        <td>${empleados.getCodigoUsuario()}</td>
                                        <td>
                                            <div class="botonesTabla">
                                                <button type="button" class="btn_editar" name="btnEditarEmpleado" id="btnEditarEmpleado">
                                                    <span class="bnt_texto">Editar</span>
                                                    <span class="btn_icono">
                                                        <i class="fa-solid fa-pen-to-square"></i>
                                                    </span>
                                                </button>

                                                <button type="button" class="btn_eliminar" name="btnEliminarEmpleado" id="btnEliminarEmpleado">
                                                    <span class="bnt_texto">Eliminar</span>
                                                    <span class="btn_icono">
                                                        <i class="fa fa-trash"></i></i>
                                                    </span>
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <form class="mensaje_eliminar">
                        <input type="hidden">
                        <div class="message warning">
                            <i class="fa fa-exclamation-triangle"></i>
                            <strong>¡Atención!</strong> Recuerda que vas a eliminar un registro si lo haces se
                            borrara de
                            forma permanente lo que quiere decir que ya nunca lo recuperaras
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>

</html>