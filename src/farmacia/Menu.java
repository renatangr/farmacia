package farmacia;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import farmacia.controller.ProdutoController;
import farmacia.model.Cosmetico;
import farmacia.model.Medicamento;

public class Menu {

	public static void main(String[] args) {
		
		ProdutoController produtos = new ProdutoController();
		
		Scanner leia = new Scanner(System.in);
		int opcao = -1, id, tipo;
		String nome, fragrancia, generico;
		float preco;
		
		// Cria contas teste
		Medicamento md1 = new Medicamento(produtos.gerarNumero(), "Puran", 1, 10.20f, "Levotiroxina");
		produtos.criarProduto(md1);
		produtos.criarProduto(new Medicamento(produtos.gerarNumero(), "Queropax", 1, 190.20f, "Hemifumarato de Quetiapina"));
		produtos.criarProduto(new Medicamento(produtos.gerarNumero(), "Dorflex", 1, 25.29f, "Dipirona, citrato de orfenadrina e cafeína"));
		
		Cosmetico cm1 = new Cosmetico(produtos.gerarNumero(),"Shampoo de Babosa Natural", 2, 30.50f, "Doce");
		produtos.criarProduto(cm1);
		produtos.criarProduto(new Cosmetico(produtos.gerarNumero(), "Condicionador de Babosa Natural", 2, 35.60f, "Doce"));
		produtos.criarProduto(new Cosmetico(produtos.gerarNumero(), "Perfume Feminino Good Girl Carolina Herrera", 2, 385.16f, "Doce"));
		
				
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
	        
		        try {
		        System.out.print(" Escolha uma opção: ");
		        opcao = leia.nextInt();
		        } catch(InputMismatchException e) {
		        	System.err.println(" Inválido. Digite apenas valores inteiros.");
		        	leia.nextLine();
		        	keyPress();
		        }
	        
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
		            keyPress();
		        }
		        
		        case 2 -> {
		        	System.out.println("\n┌──────────────────────────────┐");
		            System.out.println("│      ATUALIZAR PRODUTO       │");
		            System.out.println("└──────────────────────────────┘");
		            System.out.print(" Digite o ID do produto: ");
		            id = leia.nextInt();
		            
		            var buscaProduto = produtos.buscarNaCollection(id);
		            
		            if (buscaProduto != null) {
		            	tipo = buscaProduto.getTipo();
		            	
		            	System.out.print(" Nome do produto: ");
			            leia.skip("\\R");
			            nome = leia.nextLine();
			            System.out.print(" Preço do produto: ");
			            preco = leia.nextFloat();
			            
				            if(tipo == 1) {
				            	System.out.print(" Equivalente genérico: ");
				            	leia.skip("\\R");
				            	generico = leia.nextLine();
				            	
				            	produtos.atualizarProduto(new Medicamento(id, nome, tipo, preco, generico));

				            	
				            } else if(tipo == 2) {
				            	System.out.print(" Digite a fragrância do cosmético: ");
				            	leia.skip("\\R");
				            	fragrancia = leia.nextLine();
				            	
				            	produtos.atualizarProduto(new Cosmetico(id, nome, tipo, preco, fragrancia));
			            	
				            }
		            	
		            } else {
		            	System.err.println(" Nenhum resultado obtido pela busca com o ID " + id + ".");
		            }
		        	keyPress();
		        }
		        
		        case 3 -> {
		        	System.out.print(" Digite o ID do produto: ");
		        	id = leia.nextInt();
		        	produtos.consultarProdutoPorId(id);
		        	keyPress();
		        }
		        
		        case 4 -> {
		        	System.out.println("\n┌──────────────────────────────┐");
		            System.out.println("│       DELETAR PRODUTO        │");
		            System.out.println("└──────────────────────────────┘");
		            
		            boolean retornoFuncao = true;
		            
		            do {
			            System.out.print(" Digite o ID do produto: ");
			            id = leia.nextInt();
			            retornoFuncao = produtos.deletarProduto(id);		           
		            } while(retornoFuncao);
		            
		            keyPress();
		        }
		        
		        case 5 -> {
		        	System.out.println("\n┌──────────────────────────────┐");
		            System.out.println("│     PRODUTOS CADASTRADOS     │");
		            System.out.println("└──────────────────────────────┘");
		            produtos.listarTodosProdutos();
		            keyPress();
		        }
		        
		        case 0 -> {
		        	System.out.println(" Saindo do sistema... Até logo!");
		        	leia.close();
		        	System.exit(0);
		        }
		        
		        default -> System.err.println(" Inválido.");
	        } 
		}
	}
	
	public static void keyPress() {
		try {
			System.out.println("\n\n Pressione ENTER para continuar");
			System.in.read();
			
		} catch (IOException e) {
			System.err.println("Inválido. Pressione ENTER para continuar.");
		}
	}

}
