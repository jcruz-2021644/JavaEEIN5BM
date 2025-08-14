package Controlador;

import com.kinalitosclothes.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    EmpleadosDAO empleadosDAO = new EmpleadosDAO();
    Empleados empleados = new Empleados();
    ClientesDAO clientesDAO = new ClientesDAO();
    Clientes clientes = new Clientes();
    ProductosDAO productosDAO = new ProductosDAO();
    Productos productos = new Productos();
    int codEmpleado;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Index/Principal.jsp").forward(request, response);
            /* ************Empleados************* */
        } else if (menu.equals("vistaempleadoadmin")) {

            switch (accion) {
                case "Listar":
                    List listaEmpleados = empleadosDAO.listar();
                    request.setAttribute("empleados", listaEmpleados);
                    break;
                case "Agregar":
                    String Nombre = request.getParameter("txtNombreEmpleado");
                    String Apellido = request.getParameter("txtApellidoEmpleado");
                    String Correo = request.getParameter("txtCorreoEmpleado");
                    String Telefono = request.getParameter("txtTelefonoEmpleado");
                    String Direccion = request.getParameter("txtDireccionEmpleado");
                    String CodigoUsuario = request.getParameter("txtCodigoUsuario");
                    int CodigoUsuarioC = Integer.parseInt(CodigoUsuario);

                    empleados.setNombreEmpleado(Nombre);
                    empleados.setApellidoEmpleado(Apellido);
                    empleados.setCorreoEmpleado(Correo);
                    empleados.setTelefonoEmpleado(Telefono);
                    empleados.setDireccionEmpleado(Direccion);
                    empleados.setCodigoUsuario(CodigoUsuarioC);
                    empleadosDAO.agregar(empleados);
                    request.getRequestDispatcher("Controlador?menu=vistaempleadoadmin&accion=Listar").forward(request, response);

                    break;

                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Index/vistaempleadoadmin.jsp").forward(request, response);

            /* ***********Clientes**************** */
        } else if (menu.equals("vistaclientesadmin")) {

            switch (accion) {
                case "Listar":
                    List listaClientes = clientesDAO.listar();
                    request.setAttribute("clientes", listaClientes);
                    break;
                case "Agregar":
                    String Nombre = request.getParameter("txtNombreCliente");
                    String Apellido = request.getParameter("txtApellidoCliente");
                    String Correo = request.getParameter("txtCorreoCliente");
                    String Telefono = request.getParameter("txtTelefonoCliente");
                    String Direccion = request.getParameter("txtDireccionCliente");
                    String CodigoUsuario = request.getParameter("txtCodigoUsuario");
                    int CodigoUsuarioC = Integer.parseInt(CodigoUsuario);

                    clientes.setNombreCliente(Nombre);
                    clientes.setApellidoCliente(Apellido);
                    clientes.setCorreoCliente(Correo);
                    clientes.setTelefonoCliente(Telefono);
                    clientes.setDireccionCliente(Direccion);
                    clientes.setCodigoUsuario(CodigoUsuarioC);
                    clientesDAO.agregar(clientes);
                    request.getRequestDispatcher("Controlador?menu=vistaclienteadmin&accion=Listar").forward(request, response);

                    break;

                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Index/vistaclientesadmin.jsp").forward(request, response);
        } else if (menu.equals("Usuarios")) {
            request.getRequestDispatcher("Index/VistaUsuarioAdmin.jsp").forward(request, response);
        } else if (menu.equals("Proveedor")) {
            request.getRequestDispatcher("Index/vistaproveedoradmin.jsp").forward(request, response);
        } else if (menu.equals("Categoria")) {
            request.getRequestDispatcher("Index/vistacategoria.jsp").forward(request, response);
        } else if (menu.equals("MetodoPago")) {
            request.getRequestDispatcher("Index/metodopagoadmin.jsp").forward(request, response);

            /**
             * ************Producto *************
             */
        } else if (menu.equals("vistaproductoadmin")) {
            switch (accion) {

                case "Listar":
                    List listaProductos = productosDAO.listar();
                    request.setAttribute("productos", listaProductos);
                    break;
                case "Agregar":
                    String NombreProducto = request.getParameter("txtNombreProducto");
                    String DescripcionProducto = request.getParameter("txtDescripcion");
                    String PrecioProducto = request.getParameter("txtPrecio");
                    double PrecioProductoC = Double.parseDouble(PrecioProducto);
                    String TallaProducto = request.getParameter("txtTalla");
                    String StockProducto = request.getParameter("txtStock");
                    int StockProductoC = Integer.parseInt(StockProducto);
                    String CodigoProveedor = request.getParameter("txtCodigoProveedor");
                    int CodigoProveedorC = Integer.parseInt(CodigoProveedor);
                    String CodigoCategoria = request.getParameter("txtCodigoCategoria");
                    int CodigoCategoriaC = Integer.parseInt(CodigoCategoria);
                    productos.setNombreProducto(NombreProducto);
                    productos.setDescripcionProducto(DescripcionProducto);
                    productos.setPrecioProducto(PrecioProductoC);
                    productos.setTalla(TallaProducto);
                    productos.setStock(StockProductoC);
                    productos.setCodigoProveedor(CodigoProveedorC);
                    productos.setCodigoCategoria(CodigoCategoriaC);
                    productosDAO.agregar(productos);
                    request.getRequestDispatcher("Controlador?menu=vistaproductoadmin&accion=Listar").forward(request, response);

                    break;

                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    String idEliminar = request.getParameter("id");
                    if (idEliminar != null && !idEliminar.trim().isEmpty()) {
                        try {
                            int codigo = Integer.parseInt(idEliminar);

                            int resultado = productosDAO.eliminar(codigo);

                            if (resultado > 0) {
                                request.setAttribute("mensaje", "Producto eliminado exitosamente");
                            } else {
                                request.setAttribute("error", "Error al eliminar el producto");
                            }

                        } catch (NumberFormatException e) {
                            request.setAttribute("error", "ID de producto inválido");
                        }

                        response.sendRedirect("Controlador?menu=vistaproductoadmin&accion=Listar");
                        return;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Index/vistaproductoadmin.jsp").forward(request, response);
        } else if (menu.equals("Pedido")) {
            request.getRequestDispatcher("Index/vistapedidoadmin.jsp").forward(request, response);
        } else if (menu.equals("DetallePedido")) {
            request.getRequestDispatcher("Index/vistadetallepedidoadmin.jsp").forward(request, response);
        } else if (menu.equals("Factura")) {
            request.getRequestDispatcher("Index/VistaFacturaAdmin.jsp").forward(request, response);

        } else if (menu.equals("vistaadmin")) {
            request.getRequestDispatcher("Index/vistaadmin.jsp").forward(request, response);

        } else if (menu.equals("vistaproducto")) {
            request.getRequestDispatcher("Index/vistaproducto.jsp").forward(request, response);

        } else if (menu.equals("vistadetallepedido")) {
            request.getRequestDispatcher("Index/vistadetallepedido.jsp").forward(request, response);

        } else if (menu.equals("mujer")) {
            request.getRequestDispatcher("Index/mujer.jsp").forward(request, response);
        } else if (menu.equals("hombre")) {
            request.getRequestDispatcher("Index/hombre.jsp").forward(request, response);

        } else if (menu.equals("mispedidos")) {
            request.getRequestDispatcher("Index/mispedido.jsp").forward(request, response);
        } else if (menu.equals("conocenos")) {
            request.getRequestDispatcher("Index/conocenos.jsp").forward(request, response);
        } else if (menu.equals("VistaUsuarioCliente")) {
            request.getRequestDispatcher("Index/VistaUsuarioCliente.jsp").forward(request, response);
        } else if (menu.equals("VistaFacturaCliente")) {
            request.getRequestDispatcher("Index/VistaFacturaCliente.jsp").forward(request, response);

        } else if (menu.equals("index")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
