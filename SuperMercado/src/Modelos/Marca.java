package Modelos;

public class Marca {
	private String nome;
	private double preco;
	
	public Marca(String[] dados) {
		/*M�todo respons�vel por separar as informa��es em espa�os para salvar no objeto e arquivos
		 * */
		String[] mar = dados[3].split("=");
		this.nome = mar[1].trim();
		this.preco = Double.parseDouble(dados[4].trim());
	}
	
	public Marca() {
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
	public double getPreco() {
		/*M�todo respons�vel por buscar a informa��o requisitada na vari�vel
		 * */
		return preco;
	}
	public void setPreco(double preco) {
		/*M�todo respons�vel por colocar a informa��o buscada em um lugar
		 * */
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		/*M�todo respons�vel por transformar as informa��es em String para mostrar no console ou transformar em objeto
		 * */
		return nome + ", " + preco;
	}
}
