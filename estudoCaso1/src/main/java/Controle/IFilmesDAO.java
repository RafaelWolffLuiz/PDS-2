package Controle;

import java.util.ArrayList;

import Modelo.Filmes;

public interface IFilmesDAO {

	public int inserirFilmes(Filmes end);

	public ArrayList<Filmes> listarFilmes();

	public int atualizarFilmes(Filmes end);

	public int removerFilmes(Filmes end);

}
