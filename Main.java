import listaLigada.TLista;

public class Main {
	public static void main(String args[]){

		TCola queue = new TCola(6);

		// FOR THE ID´S
		TLista totalClients = new TLista();

		// FOR THE LOGS
		int waitTime = 0;

		for (int time = 0; time < 60 || (time >= 60 && queue.getNumberElements() != 0); time++){
			System.out.println("Minuto: " + (time + 1));
			// WE CHECK THE TIME AND IF ITS MORE THAN 60 CANT ADD MORE CLIENTS
			if(time == 60){
				System.out.println("YA NO SE ACEPTARAN NUEVOS CLIENTES");
			}

			// WE CHECK IF THE QUEUE HAS SOME CLIENTS
			// IF IT DOES WE DECREMENT THE SERVICE TIME OF THE FIRST CLIENT
			if(!queue.isEmpty()){
				// IF THE SERVICE TIME OF THE FIRST CLIENT IS 0 WE THROW AN ERROR AND WE REMOVED THE CLIENT
				try {
					queue.decrementServiceTime();
					System.out.println("El cliente " + queue.getFront().getId() + " esta siendo atendido, tardara " + queue.getFront().getServiceTime() + " minutos en salir de la cola");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			// WE CHECK IF THE WAITING TIME IS 0 SO WE CAN DECREMENT IT PROPERLY
			if(waitTime != 0){
				waitTime--;
			}

			// WE CHECK IF THE QUEUE IS FULL SO WE CAN ADD A NEW CLIENT
			if(!queue.isFull() && time < 60){
				Client client = Utils.generateClientWithProbability((totalClients.getSize() + 1), 0.25f);
				if (client != null){
					if(waitTime != 0){
						System.out.println("Cliente " + client.getId() + " llega al banco, sera atendido en " + waitTime + " minutos");
					}
					else {
						System.out.println("Cliente " + client.getId() + " llega al banco, sera atendido de inmediato, tardara " + client.getServiceTime() + " minutos");
					}
					queue.inQueue(client);
					waitTime += client.getServiceTime();
					totalClients.addLast(client.getId());
				}
			}
			if(queue.isEmpty()){
				System.out.println("No hay clientes en la cola");
			}
			else{
				System.out.println("Hay " + (queue.getNumberElements() - 1) + " cliente(s) en la cola");
			}
			System.out.println("-------------------------------");
		}
	}
}
