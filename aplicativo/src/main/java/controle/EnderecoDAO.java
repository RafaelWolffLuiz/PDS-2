package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;

public class EnderecoDAO implements IEnderecoDAO {
	
	private static EnderecoDAO instancia;
	
	
	
	private EnderecoDAO() {
		
	}
	
	public static EnderecoDAO getInstancia() {
		
		if (instancia == null) {
			instancia = new EnderecoDAO();
			
			
		}
		return instancia;
	}

	public int inserirEndereco(Endereco end) {
		
		String SQL = "INSERT INTO enderecos (cep, rua) VALUES (?, ?)";
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Endereco> listarEnderecos() {
		
		//ArrayList para armazena resultado do select
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		// Comando SQL a ser executado
		String SQL = "SELECT * FROM enderecos";
		
		// Criar a "ponte de conexao" com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//criar objeto
				Endereco end = new Endereco();
				
				//pega os valores de cada coluna de registro
				String rua = rs.getString("rua");
				String cep = rs.getString("cep");
				// E aqui seria Integer         Esses Get, podem várias, se for com números seria getInt //
				
				end.setCep(cep);
				end.setRua(rua);
				
				//adiciona obj na lista
				enderecos.add(end);
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharconexao();
		}
				
		return enderecos;
	}

	public boolean atualizarEndereco(Endereco end) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removerEndereco(Endereco end) {
		// TODO Auto-generated method stub
		return false;
	}

	public Endereco buscarEnderecoPorCep(int cep) {
		// TODO Auto-generated method stub
		return null;
	}

}
