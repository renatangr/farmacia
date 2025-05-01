package farmacia;

import java.util.Scanner;

import farmacia.controller.ProdutoController;
import farmacia.model.Cosmetico;
import farmacia.model.Medicamento;

public class Menu {

	public static void main(String[] args) {
		
		ProdutoController produtos = new ProdutoController();
		
		Scanner leia = new Scanner(System.in);
		int opcao, id, tipo;
		String nome, fragrancia, generico;
		float preco;
		
		while(true) {
			System.out.println("┌──────────────────────────────┐");
	        System.out.println("│       MENU PRINCIPAL         │");
	        System.out.println("├──────────────────────────────┤");
	        System.out.println("│                              │");
	        System.out.println("│ 1 - Cadastrar um produto     │");
	        System.out.println("│ 2 - Atualizar um produto     │");
	        System.out.println("│ 3 - Consultar produto        │");
	        System.out.println("│ 4 - Deletar um produto       │");
	        System.out.println("│ 5 - Listar todos os produtos │");
	        System.out.println("│                              │");
	        System.out.println("│ 0 - Sair                     │");
	        System.out.println("└──────────────────────────────┘");
	        System.out.print(" Escolha uma opção: ");
	        opcao = leia.nextInt();
	        
	        switch(opcao) {
		        case 1 -> {
		        	System.out.println("\n┌──────────────────────────────┐");
		            System.out.println("│     CADASTRO DE PRODUTO      │");
		            System.out.println("└──────────────────────────────┘");
		            System.out.print(" Nome do produto: ");
		            leia.skip("\\R");
		            nome = leia.nextLine();
		            System.out.print(" Preço do produto: ");
		            preco = leia.nextFloat();
		            do {
			            System.out.print(" Tipo do produto (1- Medicamento | 2- Cosmético): ");
			            tipo = leia.nextInt();
			         
				            if(tipo == 1) {
				            	System.out.print(" Equivalente genérico: ");
				            	leia.skip("\\R");
				            	generico = leia.nextLine();
				            	
				            	produtos.criarProduto(new Medicamento(produtos.gerarNumero(), nome, tipo, preco, generico));
				            	break;
				            	
				            } else if(tipo == 2) {
				            	System.out.print(" Digite a fragrância do cosmético: ");
				            	leia.skip("\\R");
				            	fragrancia = leia.nextLine();
				            	
				            	produtos.criarProduto(new Cosmetico(produtos.gerarNumero(), nome, tipo, preco, fragrancia));
				            	break;
				            	
				            } else {
				            	System.err.println(" Inválido!");
				            }
		            } while(true);
		            
		        }
		        case 5 -> {
		        	System.out.println("\n┌──────────────────────────────┐");
		            System.out.println("│     PRODUTOS CADASTRADOS     │");
		            System.out.println("└──────────────────────────────┘");
		            produtos.listarTodosProdutos();
		        }
	        } 
		}
	}

}
