package listaLigada;
public class TNodo {
	private int info;
	private TNodo sig;
	TNodo(){
		this.info = -1000000000;
		this.sig = null;
	}
	TNodo(int info){
		this.info = info;
		this.sig = null;
	}
	public void setInfo(int info){
		this.info = info;
	}
	public int getInfo(){
		return this.info;
	}
	public void setEnlace(TNodo enlace){
		this.sig = enlace;
	}
	public TNodo getEnlace(){
		return this.sig;
	}
}