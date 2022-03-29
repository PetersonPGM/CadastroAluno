package Modelos;

public class Produto {
	private String categoria;
	private String nome;
	private Marca marca;
	
	public Produto(String dados) {
		/*Método responsável por separar as informações em espaços para salvar no objeto e arquivos
		 * */
		String[] atributos = dados.split(",");
		
		String[] categoria = atributos[1].split("=");
		String[] nome = atributos[2].split("=");
		
		Marca marcas = new Marca(atributos);
		
		this.categoria = categoria[1].trim();
		this.nome = nome[1].trim();
		this.marca = marcas;
		
		
//		for(int x = 0; x < atributos.length; x++)
//		System.out.println(atributos[x]);
	}
	
	public Produto() {
	}
	
	public String getCategoria() {
		/*Método responsável por buscar a informação requisitada na variável
		 * */
		return categoria;
	}
	public void setCategoria(String categoria) {
		/*Método responsável por colocar a informação buscada em um lugar
		 * */
		this.categoria = categoria;
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
	public Marca getMarca() {
		/*Método responsável por buscar a informação requisitada na variável
		 * */
		return marca;
	}
	public void setMarca(Marca marca) {
		/*Método responsável por colocar a informação buscada em um lugar
		 * */
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		/*Método responsável por transformar as informações em String para mostrar no console ou transformar em objeto
		 * */
		return "Produto X, Categoria = " + categoria + ", Tipo do produto = " + nome + ", Marca = " + marca;
	}
}
