package farmacia.controller;

import java.util.ArrayList;
import java.util.Scanner;

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
		var buscaProduto = buscarNaCollection(produto.getId());
		
		if(buscaProduto != null) {
			produtosCadastrados.set(produtosCadastrados.indexOf(buscaProduto), produto);
			System.out.println(Cores.VERDE + "\n O produto ID " + produto.getId() + " foi atualizado com sucesso." + Cores.RESET);
			
		} else {
			System.err.println(" Não foi obtido nenhum resultado para o ID pesquisado.");
		}
		
	}

	@Override
	public boolean deletarProduto(int id) {
		var produto = buscarNaCollection(id);
		Scanner leia = new Scanner(System.in);
		String resposta;
		
		if(produto != null) {
			System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│      PRODUTO CADASTRADO      │");
            System.out.println("└──────────────────────────────┘");
			produto.visualizar();
			do {
				System.out.print(" Confirma a exclusão do produto? (S/N) ");
				resposta = leia.nextLine();
				
				if(resposta.equalsIgnoreCase("S")) {
					produtosCadastrados.remove(produto);
					System.out.println(Cores.VERDE + " O produto foi excluído com sucesso." + Cores.RESET);
					return false;
				} else if (resposta.equalsIgnoreCase("N")) {
					System.out.println(Cores.VERDE + " Operação cancelada." + Cores.RESET);
					return false;					
				} else {
					System.err.println("Inválido.");
					return true;
				}
			} while(true);
		} else {
			System.err.println(" Não foi obtido nenhum resultado para o ID pesquisado.");
			return true;
		}
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
