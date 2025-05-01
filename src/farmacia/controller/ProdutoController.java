package farmacia.controller;

import java.util.ArrayList;

import farmacia.model.Produto;
import farmacia.repository.ProdutoRepository;
import farmacia.util.Cores;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> produtosCadastrados = new ArrayList<Produto>();
	int id = 0;
	
	@Override
	public void criarProduto(Produto produto) {
		produtosCadastrados.add(produto);
		System.out.println(Cores.VERDE + "\n Produto " + produto.getNome() + " cadastrado com sucesso!" + Cores.RESET);
		
	}

	@Override
	public void listarTodosProdutos() {
		for(var produto : produtosCadastrados) {
			produto.visualizar();
		}
		
	}

	@Override
	public void consultarProdutoPorId(int id) {
		
		var produto = buscarNaCollection(id);
		
		if(produto != null) {
			System.out.println("\n┌───────────────────────────────────┐");
            System.out.println("│         PRODUTO ENCONTRADO        │");
            System.out.println("└───────────────────────────────────┘");
			produto.visualizar();
		} else {
			System.err.println(" Nenhum resultado obtido pela busca com o ID " + id + ".");
		}
	}

	@Override
	public void atualizarProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarProduto(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public int gerarNumero() {
		return ++ id;
	}
	
	public Produto buscarNaCollection(int id) {
		
		for(var produto : produtosCadastrados) {
			if(id == produto.getId()) {
				return produto;
			}
			
		}
		return null;
	}


}
