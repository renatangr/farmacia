package farmacia.repository;

public interface ProdutoRepository {

	public void criarProduto();
	public void listarTodosProdutos();
	public void consultarProdutoPorId();
	public void atualizarProduto();
	public void deletarProduto();
	
}
