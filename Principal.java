
public class Principal {
		
		public static void main(String[] args) {
			
			/*Vertice v1 = new Vertice("v1");
			Vertice v2 = new Vertice("v2");
			Vertice v3 = new Vertice("v3");
			Vertice v4 = new Vertice("v4");*/
			

			Grafo grafo = new Grafo(5);
				
			try {
				grafo.adicionarVertice("v0");
				grafo.adicionarVertice("v1");
				grafo.adicionarVertice("v2");
				grafo.adicionarVertice("v3");
				grafo.adicionarVertice("v4");
				
				grafo.conectarVertices("v0", "v3");
				grafo.conectarVertices("v0", "v4");
				grafo.conectarVertices("v1", "v3");
				grafo.conectarVertices("v1", "v4");
				grafo.conectarVertices("v2", "v3");
				grafo.conectarVertices("v2", "v3");
				grafo.conectarVertices("v2", "v2");
				grafo.conectarVertices("v3", "v4");
				
				System.out.println("Vizinhos de V1");
				for(Vertice v : grafo.getAdjacentes("v1")) {
					System.out.print(v.getRotulo() + ", ");
				}
				
				
				grafo.exibeMatrizAdjacencia();
				
				grafo.ordemGrafo();
				grafo.tamanhoGrafo();
				
			}catch(Exception e) {
				System.out.println("Error ao criar o grafo.");
				System.out.println("Mensagem: " + e.getMessage());
				System.exit(0);
			}
			
		}

	}