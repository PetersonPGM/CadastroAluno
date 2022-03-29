package Modelos;

public class Marca {
	private String nome;
	private double preco;
	
	public Marca(String[] dados) {
		/*Método responsável por separar as informações em espaços para salvar no objeto e arquivos
		 * */
		String[] mar = dados[3].split("=");
		this.nome = mar[1].trim();
		this.preco = Double.parseDouble(dados[4].trim());
	}
	
	public Marca() {
	}
	
	public String getNome() {
		/*Método responsável por buscar a informação requisitada na variável
		 * */
		return nome;
	}
	public void setNome(String nome) {
		/*Método responsável por colocar a informação buscada em um lugar
		 * */
		this.nome = nome;
	}
	public double getPreco() {
		/*Método responsável por buscar a informação requisitada na variável
		 * */
		return preco;
	}
	public void setPreco(double preco) {
		/*Método responsável por colocar a informação buscada em um lugar
		 * */
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		/*Método responsável por transformar as informações em String para mostrar no console ou transformar em objeto
		 * */
		return nome + ", " + preco;
	}
}
