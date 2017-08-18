/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.db.ConectarDB;
import com.proyecto.modelo.Producto;
import com.proyecto.modelo.Usuario;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class UsuarioDaoImpl implements IDAO{

    ConectarDB con;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    String respuesta = null;
    
    Usuario usuario;
    private Object out;
    
    
    public UsuarioDaoImpl() {
        con = new ConectarDB();
        con.setDriver("com.mysql.jdbc.Driver");
        con.setUrl("jdbc:mysql://localhost:3306/ventas");
        con.setUsuario("root");
        
        con.setPassword("");
    }
    

    @Override
    public String insertar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarPorID(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int contar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Object id){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    @Override
    public List<?> busquedaPorParametro(String field, Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> existeUsuario(String usuario, String clave) throws Exception {
        
        
        List<Usuario> ListaUsuario = new ArrayList();
        
        try{
            
            psmt = con.conectar().prepareStatement("SELECT * FROM usuarios WHERE usuario=? AND password=? AND estado='Activo'");
            
            psmt.setString(1, usuario);
            psmt.setString(2, clave);
            
            rs = psmt.executeQuery();
            
            while(rs.next()){
                
                ListaUsuario.add(Usuario.load(rs));
                
            }
            
            
        } catch(SQLException e){
        
            
            System.out.println("Error al listar los usuarios: "+e.toString());
            
            
        }finally{
            if(psmt!=null){
                psmt.close();
            }
            if(rs!=null){
                rs.close();
            }
            
            con.desconectar();
        }
        
        return ListaUsuario;
    }

    @Override
    public String generarCodigo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
