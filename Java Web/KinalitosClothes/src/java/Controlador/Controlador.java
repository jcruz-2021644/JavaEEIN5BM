package Controlador;

import com.kinalitosclothes.modelo.Empleados;
import com.kinalitosclothes.modelo.EmpleadosDAO;
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
        } else if (menu.equals("Cliente")) {
            request.getRequestDispatcher("Index/vistaclienteadmin.jsp").forward(request, response);
        } else if (menu.equals("Usuarios")) {
            request.getRequestDispatcher("Index/VistaUsuarioAdmin.jsp").forward(request, response);
        } else if (menu.equals("Proveedor")) {
            request.getRequestDispatcher("Index/vistaproveedoradmin.jsp").forward(request, response);
        } else if (menu.equals("Categoria")) {
            request.getRequestDispatcher("Index/vistacategoria.jsp").forward(request, response);
        } else if (menu.equals("MetodoPago")) {
            request.getRequestDispatcher("Index/metodopagoadmin.jsp").forward(request, response);
        } else if (menu.equals("Producto")) {
            request.getRequestDispatcher("Index/vistaproductoadmin.jsp").forward(request, response);
        } else if (menu.equals("Pedido")) {
            request.getRequestDispatcher("Index/vistapedidoadmin.jsp").forward(request, response);
        } else if (menu.equals("DetallePedido")) {
            request.getRequestDispatcher("Index/vistadetallepedidoadmin.jsp").forward(request, response);
        } else if (menu.equals("Factura")) {
            request.getRequestDispatcher("Index/VistaFacturaAdmin.jsp").forward(request, response);
        } else if (menu.equals("vistaadmin")) {
            request.getRequestDispatcher("Index/vistaadmin.jsp").forward(request, response);
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
