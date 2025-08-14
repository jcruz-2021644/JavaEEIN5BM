package com.kinalitosclothes.modelo;

import com.kinalitosclothes.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar() {
        String sql = "call sp_ListarClientes();";
        List<Clientes> listaClientes = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes cl = new Clientes();
                cl.setCodigoCliente(rs.getInt(1));
                cl.setNombreCliente(rs.getString(2));
                cl.setApellidoCliente(rs.getString(3));
                cl.setCorreoCliente(rs.getString(4));
                cl.setTelefonoCliente(rs.getString(5));
                cl.setDireccionCliente(rs.getString(6));
                cl.setCodigoUsuario(rs.getInt(7));
                listaClientes.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public int agregar(Clientes cli) {
        String sql = "call sp_AgregarCliente(?, ?, ?, ?, ?, ?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombreCliente());
            ps.setString(2, cli.getApellidoCliente());
            ps.setString(3, cli.getCorreoCliente());
            ps.setString(4, cli.getTelefonoCliente());
            ps.setString(5, cli.getDireccionCliente());
            ps.setInt(6, cli.getCodigoUsuario());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;

    }
}
