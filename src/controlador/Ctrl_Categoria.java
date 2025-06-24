package controlador;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Categoria;

public class Ctrl_Categoria {
    
    //METODO PARA GUARDA CATEGORIA
   public boolean guardar(Categoria objeto) {
      boolean respuesta = false;
      Connection cn = Conexion.conectar();

      try {
         PreparedStatement consulta = (PreparedStatement)cn.prepareStatement("insert into tb_categoria values(?,?,?)");
         consulta.setInt(1, 0);
         consulta.setString(2, objeto.getDescripcion());
         consulta.setInt(3, objeto.getEstado());
         if (consulta.executeUpdate() > 0) {
            respuesta = true;
         }

         cn.close();
      } catch (SQLException e) {
         System.out.println("Error al guardar categoria" + String.valueOf(e));
      }

      return respuesta;
   }

   
   //METODO PARA COMPROBAR SI YA EXISTE CATEGORIA
   public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '" + categoria + "';";
        Statement st;
        
        try {
            com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) Conexion.conectar();
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar categoria" + String.valueOf(e));
        }

        return respuesta;
    }
   
   // METODO PARA ACTUALIZAR CATEGORIA
   public boolean actualizar (Categoria objeto, int idCategoria) {
      boolean respuesta = false;
      Connection cn = Conexion.conectar();

      try {
         PreparedStatement consulta = (PreparedStatement)cn.prepareStatement("update tb_categoria set descripcion=? where idCategoria ='"+idCategoria+"'");
         consulta.setString(1,objeto.getDescripcion());
         
         if (consulta.executeUpdate() > 0) {
            respuesta = true;
         }

         cn.close();
      } catch (SQLException e) {
         System.out.println("Error al actualizar categoria:" + e);
      }

      return respuesta;
   }
   
   // METODO PARA ELIMINAR CATEGORIA
   public boolean eliminar (int idCategoria) {
      boolean respuesta = false;
      Connection cn = Conexion.conectar();

      try {
         PreparedStatement consulta = (PreparedStatement)cn.prepareStatement("delete from tb_categoria where idCategoria ='"+idCategoria+"'");
         consulta.executeUpdate();
         
         if (consulta.executeUpdate() > 0) {
            respuesta = true;
         }

         cn.close();
      } catch (SQLException e) {
         System.out.println("Error al eliminar categoria:" + e);
      }

      return respuesta;
   }   
   
}
