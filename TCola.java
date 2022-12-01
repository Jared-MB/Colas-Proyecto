class TCola{

	private int frente, fin, size;
	private Client cola[];

	/**
	 * Constructor
	 * @param size - size of the queue
	 *
	 */
	TCola(int size){
		this.size = size;
		cola = new Client[size];
		frente = fin = 0; 
	}
	
	/**
	 * Check if the queue is empty
	 * @return boolean - true if the queue is empty
	 *
	*/
	public boolean isEmpty(){
		if (frente == fin)
			return true;
		return false;    
	}	

	/**
	 * Check if the queue is full
	 * @return boolean - true if the queue is full
	 *
	*/
	public boolean isFull(){
		if ((fin+1) % size == frente)
			return true;
		return false;
	}
	
	/**
	 * Add a new element to the queue
	 * @param dato - element to add of type Client
	 * @return void
	 *
	*/
	public void inQueue(Client dato){
		if (!isFull()){
			cola[fin] = dato;
			fin = (fin+1) % size;
		}
	}
	
	/**
	 * Remove an element from the queue
	 * @return int - element removed
	 *
	*/
	public Client outQueue(){
		Client dato = null;
		if (!isEmpty()){
			dato = cola[frente];
			frente = (frente+1) % size;
		}
		return dato;
	}

	public Client getFront(){
		return cola[frente];
	}

	public int getNumberElements(){
		int numberElements = 0;
		if (frente < fin){
			numberElements = fin - frente;
		}
		else if (frente > fin){
			numberElements = size - (frente - fin);
		}
		return numberElements;
	}

	public void decrementServiceTime(){
		try {
			getFront().decrementServiceTime();
		}
		catch (Exception e) {
			outQueue();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void print(){
		int fr, fi;
		
		System.out.println("Los datos de la cola son:");
		fr = frente;
		fi = fin;
		while ((fr+1) % size != fi){
			System.out.println(cola[fr]);
			fr = (fr+1) % size;
		}
		System.out.println(cola[fr]+"\n");	
	}	
	
	// Quitar
	public void muestraArregloCola(){
		int i;
		
		System.out.println("El arreglo tiene la siguiente informacion:");
		for (i = 0; i < size; i++)
			System.out.printf("cola[%d] = %d \tfrente = %d\tfinal = %d\n", i, cola[i], frente, fin);
	}	
	
}