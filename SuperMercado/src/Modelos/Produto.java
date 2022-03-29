package Modelos;

public class Produto {
	private String categoria;
	private String nome;
	private Marca marca;
	
	public Produto(String dados) {
		/*M�todo respons�vel por separar as informa��es em espa�os para salvar no objeto e arquivos
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
		/*M�todo respons�vel por buscar a informa��o requisitada na vari�vel
		 * */
		return categoria;
	}
	public void setCategoria(String categoria) {
		/*M�todo respons�vel por colocar a informa��o buscada em um lugar
		 * */
		this.categoria = categoria;
	}
	public String getNome() {
		/*M�todo respons�vel por buscar a informa��o requisitada na vari�vel
		 * */
		return nome;
	}
	public void setNome(String nome) {
		/*M�todo respons�vel por colocar a informa��o buscada em um lugar
		 * */
		this.nome = nome;
	}
	public Marca getMarca() {
		/*M�todo respons�vel por buscar a informa��o requisitada na vari�vel
		 * */
		return marca;
	}
	public void setMarca(Marca marca) {
		/*M�todo respons�vel por colocar a informa��o buscada em um lugar
		 * */
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		/*M�todo respons�vel por transformar as informa��es em String para mostrar no console ou transformar em objeto
		 * */
		return "Produto X, Categoria = " + categoria + ", Tipo do produto = " + nome + ", Marca = " + marca;
	}
}
