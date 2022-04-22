//usamos dao para acceder a la base de datos
package com.example.clinicaOdontologica_Rodo.dao;
import com.example.clinicaOdontologica_Rodo.dominio.Domicilio;
import com.example.clinicaOdontologica_Rodo.dominio.Odontologos;
import com.example.clinicaOdontologica_Rodo.dominio.Paciente;
import com.example.clinicaOdontologica_Rodo.dominio.Turno;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDaoH2 implements IDao<Paciente>{

    //conexion
    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'","sophia","061100");
    }

    @Override
    public List<Paciente> ListarElementos() {
        Connection connection=null;
        List<Paciente> listaPacientes=new ArrayList<>();
        Paciente paciente=null;
        Odontologos odontologos =null;
        Domicilio domicilio=null;

        //debemos conectarnos para buscar la info
        try {
            DomicilioDaoH2 domicilioDaoH2 =new DomicilioDaoH2();
            //debo conectarme para buscar la info de paciente
            connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM pacientes");
            ResultSet rs=preparedStatement.executeQuery();
            //rs=resulset

            while (rs.next()){
                int id_dom=rs.getInt(7);
                domicilio=domicilioDaoH2.buscarlo(id_dom);
                paciente=new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6).toLocalDate(),domicilio, odontologos);
                listaPacientes.add(paciente);//ya encontre el 1° paciente,cargalo; asi cargamnos a todos los pacientes
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
        return listaPacientes;
    }

    @Override
    public Paciente buscarlo(int id) {
        Connection connection = null ;
        PreparedStatement preparedStatement;
        Paciente paciente=null;
        Odontologos odontologos =null;
        Domicilio domicilio=null;
        try {
            connection = getConnection();
            preparedStatement= connection.prepareStatement("SELECT * FROM pacientes WHERE ID = ?");
            preparedStatement.setInt(1,id);
            DomicilioDaoH2 domicilioDaoH2 =new DomicilioDaoH2();

            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int id_paciente = rs.getInt(1);
                String apellido = rs.getString(2);
                String nombre = rs.getString(3);
                int dni = rs.getInt(4);
                String email = rs.getString(5);
                LocalDate fechaIngreso=rs.getDate(6).toLocalDate();
                int idDomicilio = rs.getInt(7);

                domicilio = domicilioDaoH2.buscarlo(idDomicilio);

                paciente=new Paciente(id_paciente,nombre,apellido,dni,email,fechaIngreso,domicilio,odontologos);
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


        return paciente;
    }


    @Override
    public Paciente buscarEmail(String email) {
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio;
        Odontologos odontologos =null;

        //debemos conectarnos para buscar la info
        try {
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            //debo conectarme para buscar la info de paciente
            connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE email LIKE ?");
            preparedStatement.setString(1,email);
            ResultSet rs=preparedStatement.executeQuery();//ejecuto consulta
            while (rs.next()){
                int id_dom = rs.getInt(7);
                domicilio=domicilioDaoH2.buscarlo(id_dom);
                paciente=new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6).toLocalDate(),domicilio, odontologos);
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
        return paciente;
    }

    @Override
    public Paciente guardar(Turno elemento) {
        return null;
    }

    @Override
    public Paciente actualizar(Turno elemento) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
