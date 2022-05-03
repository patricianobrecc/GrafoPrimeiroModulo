import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
	
	private int qtdMaximaVertices;
	private int qtdAtualVertices, qtdAtualAresta = 0;
	private List<Vertice> vertices = new ArrayList<Vertice>();
	private Map<String, Integer> rotuloEmVertices = new HashMap<>();
	private MatrizAdjacencia matrizAdjacencia;
	
	public Grafo(int qtdVertices) throws IllegalArgumentException {
		if(qtdVertices <= 0) {
			throw new IllegalArgumentException("A quantidade "
					+ "de vertices precisa ser maior que ou "
					+ "igual � 1.");
		}
		this.qtdMaximaVertices = qtdVertices;
	}
	
	public void adicionarVertice(String rotulo) throws Exception {
		//Verificar se ainda � poss�vel adicionar v�rtice no grafo
		if(qtdAtualVertices > qtdMaximaVertices-1) {
			throw new Exception("A quantidade m�xima de vertices �: " + qtdMaximaVertices);
		}
		//Se for poss�vel
		//Criar o v�rtice com o rotulo passado por par�metro
		Vertice novoVertice = new Vertice(rotulo);
		//Adicionar o v�rtice criado na lista de v�rtices
		this.vertices.add(novoVertice);
		//Definir r�tulos em v�rtices
		this.rotuloEmVertices.put(rotulo, qtdAtualVertices);
		//controlar a entrada os v�tices
		this.qtdAtualVertices++;
	}
	
	public void conectarVertices(String rotuloVerticeInicial, 
			String rotuloVerticeFinal) throws Exception{
		if(!existeVertice(rotuloVerticeInicial) || !existeVertice(rotuloVerticeFinal)) {
			throw new Exception("Informe r�tulos v�lidos.");
	
		}
		criarMatrizAdjacencia();
		int indiceVerticeIncial = rotuloEmVertices.get(rotuloVerticeInicial);
		int indiceVerticeFinal = rotuloEmVertices.get(rotuloVerticeFinal);
		this.matrizAdjacencia.conectarVertices(indiceVerticeIncial, indiceVerticeFinal);
		this.qtdAtualAresta++;
	}
	
	public Vertice getVertice(String rotulo) throws Exception{
		if(!existeVertice(rotulo)) {
			throw new Exception("Informe um r�tulo v�lido!");
		}
		int indice = this.rotuloEmVertices.get(rotulo);
		return this.vertices.get(indice);
	}
	
	public List<Vertice> getAdjacentes(String rotulo) throws Exception{
		if(!existeVertice(rotulo)) {
			throw new Exception("Informe um r�tulo v�lido!");
		}
		int indice = rotuloEmVertices.get(rotulo);
		return this.matrizAdjacencia.getAdjacentes(indice);
	}
	
	private void criarMatrizAdjacencia() {
		if(matrizAdjacencia == null) {
			this.matrizAdjacencia = new MatrizAdjacencia(new ArrayList<>(vertices));
		}
	}
	
	private boolean existeVertice(String rotulo) {
		return this.rotuloEmVertices.get(rotulo) != null ? true : false;
	}

	public void exibeMatrizAdjacencia() {
		matrizAdjacencia.exibeMatriz();
}
	
	public void ordemGrafo(){
		System.out.println("Ordem do grafo:" + qtdAtualVertices);
	}
	public void tamanhoGrafo(){
		System.out.println("Ordem do grafo:" + qtdAtualAresta);
	}
	
}
