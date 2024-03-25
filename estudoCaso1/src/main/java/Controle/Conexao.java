package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

		private static final String USERNAME = "aluno";
		private static final String SENHA = "root";
		private static final String BD = "nome_banco";
		private Connection con; //JBDC
		private static Conexao instancia;
	
		private Conexao( ) {}  // Construtor Privado
		
		public static Conexao getInstancia() {
			if(instancia == null) {
				instancia = new Conexao();
			}
			return instancia;
		}
		
		/**
		 * Fecha conexao com o MySQL
		 * @return true ou false dependendo do método con
		 */
		
		public Connection conectar() {
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/"+ BD + "?serverTimezone=UTC", USERNAME, SENHA);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
			
		}
		
	
	public boolean fecharconexao() {
		
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
		
}
