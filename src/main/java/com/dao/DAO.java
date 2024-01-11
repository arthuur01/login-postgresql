package com.dao;
import java.sql.*;



public class DAO {
	protected Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";
        String serverName = "localhost";
        String mydatabase = "test";
        int porta = 5432;
        String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
        String username = "postgres";
        String password = "amiguel101";
        boolean status = false;
        
        try {
        	Class.forName(driverName);
        	conexao = DriverManager.getConnection(url, username, password);
        	status = (conexao == null );
        	System.out.println("Conexão feita com sucesso");
        }catch(ClassNotFoundException e){
        	System.out.println("Driver não econtrado");
        	
        }catch(SQLException e) {
        	System.out.println("Erro na conexão" + e.getMessage());
        }
        return status;
	}
	public boolean close() {
		boolean status = false;
		try {
			conexao.close();
			status = true;
		}catch(SQLException e) {
			System.out.println("Erro ao fechar a conexão" + e.getMessage());
		}
		
		return status; 
	}
}
