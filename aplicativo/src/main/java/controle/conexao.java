package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

		private static final String USERNAME = "aluno";
		private static final String SENHA = "root";
		private static final String BD = "nome_banco";
		private Connection con; //JBDC
		private static conexao instancia;
	
		private conexao( ) {}  // Construtor Privado
		
		public static conexao getconexao() {
			if(instancia == null) {
				instancia = new conexao();
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
