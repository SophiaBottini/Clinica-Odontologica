package com.example.clinicaOdontologica_Rodo.dao;

import com.example.clinicaOdontologica_Rodo.dominio.Domicilio;
import com.example.clinicaOdontologica_Rodo.dominio.Odontologos;
import com.example.clinicaOdontologica_Rodo.dominio.Paciente;
import com.example.clinicaOdontologica_Rodo.dominio.Turno;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OdontologoDaoH2 implements IDao<Odontologos>{

    //conexion
    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'","sophia","061100");
    }

    @Override
    public List<Odontologos> ListarElementos() {
       Connection connection = null ;
        PreparedStatement preparedStatement;
        List<Odontologos>odontologos=new ArrayList<>();

        //nos conectamos para obtener la informacion
        try {
            connection=getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FORM ODONTOLOGOS");
            ResultSet rs=preparedStatement.executeQuery();

            while (rs.next()){
                int id_odontologo = rs.getInt(1);
                String apellido = rs.getString(2);
                String nombre = rs.getString(3);
                String matricula = rs.getString(4);

                Odontologos odontologo = new Odontologos(id_odontologo,apellido,nombre,matricula);
                odontologos.add(odontologo);
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
        return odontologos;
    }

    @Override
    public Odontologos buscarlo(int id) {
        Connection connection = null ;
        PreparedStatement preparedStatement;
        Odontologos odontologo=null;

        try {
            connection = getConnection();
            preparedStatement= connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID = ?");
            preparedStatement.setInt(1,id);

            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int id_odontologo = rs.getInt(1);
                String apellido = rs.getString(2);
                String nombre = rs.getString(3);
                String matricula = rs.getString(4);

                odontologo=new Odontologos(id_odontologo,apellido,nombre,matricula);
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


        return odontologo;
    }

    @Override
    public Odontologos buscarEmail(String email) {
        return null;
    }

    @Override
    public Odontologos guardar(Turno elemento) {
        return null;
    }

    @Override
    public Odontologos actualizar(Turno elemento) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
