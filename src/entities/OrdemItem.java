package entities;

public class OrdemItem {
	
	private Integer quantidade;
	private double preco;
	
	private Produto produto; //apenas composição nao é associação
	
	public OrdemItem() {
		
	}

	public OrdemItem(Integer quantidade, double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void Produto(Produto produto) {
		this.produto = produto;
	}
	
	public double subTotal() {
		return preco * quantidade;
	}
	@Override
	public String toString() {
		return getProduto().getNome()
				+", $"
				+ String.format("%.2f", preco)
				+ ", Quantidade: "
				+ quantidade
				+ ", SubTotal: $"
				+ String.format("%.2f", subTotal());
				
		
				
	}
}
