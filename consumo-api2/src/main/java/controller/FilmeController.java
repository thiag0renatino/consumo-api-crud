package controller;

import model.dao.FilmeDAO;
import model.vo.Filme;
import view.ViewConsole;

public class FilmeController {
	
	private FilmeDAO dao;
	private ViewConsole view;
	
	
	public FilmeController(FilmeDAO dao, ViewConsole view) {
		this.dao = dao;
		this.view = view;
	}

	public void cadastrarFilme(Filme filme) {
		
		view.exibirMensagem(dao.insert(filme) ? "Filme Cadastrado!" : "ERRO: Filme Não Cadastrado");
	}
	
	public void deletarFilme(String title) {
		
		view.exibirMensagem(dao.delete(title) ? "Filme Excluído!" : "ERRO: Filme Não Excluído");
	}
	
	public void atualizarFilme(String Metascore, String Title) {
		
		view.exibirMensagem(dao.updateMetascore(Metascore, Title) ? "MetaScore Atualizado!" : "ERRO: MetaScore Não Atualizado");
	}
	
	public Filme buscarFilme(String Title) {
		
		Filme filme = dao.read(Title);
		view.exibirMensagem(filme.toString());
		return filme;
	}
	
	
	

}
