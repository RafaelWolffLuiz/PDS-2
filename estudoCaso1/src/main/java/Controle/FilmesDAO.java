package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Filmes;

public class FilmesDAO implements IFilmesDAO {

	private static FilmesDAO instancia;

	private FilmesDAO() {

	}

	public static FilmesDAO getInstancia() {

		if (instancia == null) {
			instancia = new FilmesDAO();

		}
		return instancia;
	}

	public int inserirFilmes(Filmes end) {

		String SQL = "INSERT INTO filmes (nome, genero, classificacao, preco) VALUES (?, ?, ?, ?)";
		Conexao con = Conexao.getInstancia();
		Connection conDB = con.conectar();

		try {
			PreparedStatement ps = conDB.prepareStatement(SQL);

			ps.setString(1, end.getNome());
			ps.setString(2, end.getGenero());
			ps.setString(3, end.getClassificacao());
			ps.setFloat(4, end.getPreco());

			ResultSet rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharconexao();
		}
		return 0;
	}

	public ArrayList<Filmes> listarFilmes() {

		ArrayList<Filmes> filmes = new ArrayList<Filmes>();

		String SQL = "SELECT * FROM filmes";

		// Criar a "ponte de conexao" com MYSQL

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// criar objeto
				Filmes end = new Filmes();

				// pega os valores de cada coluna de registro

				String nome = rs.getString("nome");
				String genero = rs.getString("genero");
				String classificacao = rs.getString("classificacao");
				Float preco = rs.getFloat("preco");

				// E aqui seria Integer Esses Get, podem várias, se for com números seria getInt
				// //

				end.setNome(nome);
				end.setGenero(genero);
				end.setClassificacao(classificacao);
				end.setPreco(preco);

				// adiciona obj na lista
				filmes.add(end);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharconexao();
		}

		return filmes;
	}

	public int atualizarFilmes(Filmes end) {
		
		String SQL = "UPDATE INTO filmes (nome, genero, classificacao, preco) VALUES (?, ?, ?, ?)";
		Conexao con = Conexao.getInstancia();
        Connection conDB = con.conectar();

        int retorno = 0;
        try {
            PreparedStatement ps = conDB.prepareStatement(SQL);

            ps.setString(1, end.getNome());
			ps.setString(2, end.getGenero());
			ps.setString(3, end.getClassificacao());
			ps.setFloat(4, end.getPreco());

            ResultSet rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharconexao();
        }
 		
		return retorno;
	}


	public int removerFilmes(Filmes end) {
		
		
		String SQL = "DELETE FROM filmes WHERE nome = ?";
		Conexao con = Conexao.getInstancia();
        Connection conDB = con.conectar();

        int retorno = 0;
        try {
            PreparedStatement ps = conDB.prepareStatement(SQL);

            ps.setString(1, end.getNome());
		

            ResultSet rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharconexao();
        }
 		
		return retorno;
	}

}
