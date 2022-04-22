package com.example.clinicaOdontologica_Rodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ClinicaOdontologicaRodoApplication {

	private static void cargarBD(){
		Connection connection=null;
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'","sophia","061100");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}catch (SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		cargarBD();
		SpringApplication.run(ClinicaOdontologicaRodoApplication.class, args);

	}

}
