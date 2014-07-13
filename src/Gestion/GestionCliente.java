/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion;
import CapaDatos.Conexion;
import Clases.Cliente;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTable;
/**
 *
 * @author Gabriel
 */
public class GestionCliente {
    
 private Cliente cliente = new Cliente ("","","",0);

    public GestionCliente() 
    {
        Conexion.setCadena("jdbc:mysql://localhost:50/factura1");
        Conexion.setUsuario("root");
        Conexion.setClave("");
        
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente (Cliente cliente){
        this.cliente=cliente;
    }
    
    
    public void Grabar() throws SQLException 
    {        
        try
        {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("insert into cliente (cedula, nombre, direccion, cupo) values ('"+cliente.getCedula()+"','"+cliente.getNombre()+"','"+cliente.getDireccion()+"', "+cliente.getCupo()+")");
            Conexion.GetInstancia().Desconectar();    
        }
        catch(SQLException ex)
        {
            throw ex;            
        }
        
    }

    public void Modificar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("UPDATE cliente SET Direccion = '"+cliente.getDireccion()+"', Cupo = '"+cliente.getCupo()+"' WHERE Cedula = "+cliente.getCedula());
            Conexion.GetInstancia().Desconectar();    
        }
        catch(SQLException ex)
        {
            throw ex;            
        }
    }

    public void Nuevo() throws SQLException 
    {    
        cliente.setCedula("SD");
        cliente.setNombre("SD");
        cliente.setDireccion("SD");
        cliente.setCupo(00.00);
    }

    public void Eliminar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("DELETE FROM Cliente WHERE Cedula = "+cliente.getCedula());
            Conexion.GetInstancia().Desconectar();    
        }
        catch(SQLException ex)
        {
            throw ex;            
        }
    }

    public void Consultar() throws SQLException 
    { 
        try
        {            
            Conexion.GetInstancia().Conectar();
           JTable jb = new JTable();
           //jb = 
           Conexion.GetInstancia().Ejecutar("DELETE FROM Cliente WHERE Cedula = "+cliente.getCedula());
            
            Conexion.GetInstancia().Desconectar(); 
        }
        catch(SQLException ex)
        { 
            throw ex;
        }
    }
    
}

