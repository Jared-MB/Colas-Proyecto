package listaLigada;
public class TLista {
	private TNodo cab;
	private TNodo last;
	public TLista(){
		this.cab = new TNodo();
		this.last = cab;
	}

	public void addLast(int info){
		TNodo newNode = new TNodo(info);
		last.setEnlace(newNode);
		last = newNode;
	}

	public void removeNode(int nodeInfo){
		TNodo previousNode = this.cab;
		TNodo currentNode = previousNode.getEnlace();
		TNodo nextNode = currentNode.getEnlace();
		while(currentNode.getInfo() != nodeInfo && nextNode != null){
			previousNode = currentNode;
			currentNode = currentNode.getEnlace();
			nextNode = currentNode.getEnlace();
		}
		String out;
		if (currentNode.getInfo() == nodeInfo){
			previousNode.setEnlace(nextNode);
			out = "Se ha eliminado el nodo correctamente";
		}
		else {
			out = "No se ha encontrado el nodo";
		}
		System.out.println(out);
	}

	public void insertAtStart(int info){
		TNodo newNode = new TNodo(info);
		newNode.setEnlace(this.cab.getEnlace());
		this.cab.setEnlace(newNode);
	}

	public void addSort(int info){
		TNodo newNode = new TNodo(info);
		TNodo currentNode = cab;
		TNodo nextNode = currentNode.getEnlace();
		while (nextNode != null && nextNode.getInfo() < info){
			currentNode = currentNode.getEnlace();
			nextNode = currentNode.getEnlace();
		}
		newNode.setEnlace(nextNode);
		currentNode.setEnlace(newNode);
	}

	public int getSize(){
		TNodo currentNode = cab;
		int size = 0;
		while (currentNode.getEnlace() != null){
			currentNode = currentNode.getEnlace();
			size++;
		}
		return size;
	}

	public void showList(){
		TNodo currentNode = this.cab.getEnlace();
		while (currentNode.getEnlace() != null){
			System.out.println(currentNode.getInfo());
			currentNode = currentNode.getEnlace();
		}
		System.out.println(currentNode.getInfo());
	}
}
