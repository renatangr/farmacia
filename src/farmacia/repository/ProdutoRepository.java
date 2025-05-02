package farmacia.repository;

import farmacia.model.Produto;

public interface ProdutoRepository {

	public void criarProduto(Produto produto);
	public void listarTodosProdutos();
	public void consultarProdutoPorId(int id);
	public void atualizarProduto(Produto produto);
	public boolean deletarProduto(int id);
	
}
