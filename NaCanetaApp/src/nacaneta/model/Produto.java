package nacaneta.model;

public class Produto {
	
	public int Id;
	public String descricao;
	public String marca;
	public float preco;

	public Produto(int id, String descricao, String marca, float preco) {
		this.descricao = descricao;
		this.marca = marca;
		this.preco = preco;
		this.Id = id;
	}
	
	public Produto(String descricao, String marca, float preco) {
		this.descricao = descricao;
		this.marca = marca;
		this.preco = preco;
	}
}
