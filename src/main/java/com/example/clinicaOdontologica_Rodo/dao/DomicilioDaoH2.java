package com.example.clinicaOdontologica_Rodo.dao;

import com.example.clinicaOdontologica_Rodo.dominio.Domicilio;
import com.example.clinicaOdontologica_Rodo.dominio.Turno;

import java.sql.*;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {
    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'","sophia","061100");
    }

    @Override
    public List<Domicilio> ListarElementos() {
        return null;
    }

    @Override
    public Domicilio buscarlo(int id) {
        Connection connection=null;
        Domicilio domicilio=null;
        try {
            connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM domicilios WHERE id=?");
            preparedStatement.setInt(1,id);//set int: al valor del parametro que esta en la pregunta le va a poner le valor que tenga el segundo parametro
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                domicilio= new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return domicilio;//me va a devolver los datos ya caragdos si es que existe
    }

    @Override
    public Domicilio buscarEmail(String email) {
        return null;
    }

    @Override
    public Domicilio guardar(Turno elemento) {
        return null;
    }

    @Override
    public Domicilio actualizar(Turno elemento) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
