package com.kinalitosclothes.modelo;

import com.kinalitosclothes.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public Empleados validar(String correoEmpleado, String telefonoEmpleado) {
        // instanciar el objeto de la entidad Empleado
        Empleados empleado = new Empleados();
        //agregar una cariable de tipo string para muestra de consulta sql
        String sql = "call sp_ValidarEmpleado(?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, correoEmpleado);
            ps.setString(2, telefonoEmpleado);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                empleado.setCorreoEmpleado(rs.getString("correoEmpleado"));
                empleado.setTelefonoEmpleado(rs.getString("telefonoEmpleado"));
            }
        } catch (Exception e) {
            System.out.println("El usuario o contraseña son incorrectos");
            e.printStackTrace();
        }
        return empleado;
    }

    public List listar() {
        String sql = "call sp_ListarEmpleados();";
        List<Empleados> listaEmpleados = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleados em = new Empleados();
                em.setCodigoEmpleado(rs.getInt(1));
                em.setNombreEmpleado(rs.getString(2));
                em.setApellidoEmpleado(rs.getString(3));
                em.setCorreoEmpleado(rs.getString(4));
                em.setTelefonoEmpleado(rs.getString(5));
                em.setDireccionEmpleado(rs.getString(6));
                em.setCodigoUsuario(rs.getInt(7));
                listaEmpleados.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    public int agregar(Empleados emp) {
        String sql = "call sp_AgregarEmpleado(?, ?, ?, ?, ?, ?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getApellidoEmpleado());
            ps.setString(3, emp.getCorreoEmpleado());
            ps.setString(4, emp.getTelefonoEmpleado());
            ps.setString(5, emp.getDireccionEmpleado());
            ps.setInt(6, emp.getCodigoUsuario());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;

    }

    
}
