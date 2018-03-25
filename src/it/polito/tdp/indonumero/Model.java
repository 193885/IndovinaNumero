package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {
	
	private int NMAX=100;
	private int TMAX=7;
	
	private int segreto; //numero da indovinare
	private int tentativi; //numeri già immessi
	
	private boolean inGame=false;
	
	public Model(){
		this.inGame = false;
	}
	
	/**
	 * avvia partita generando un nuovo numero segreto da indovinare
	 */
	public void newGame(){
		
		segreto=(int) (Math.random()*NMAX)+1;
    	tentativi=0;
    	inGame=true;
	}
	
	/**
	 * fai tentativo per indovinare numero segreto
	 * @param t valore numerico del tentativo
	 * @return -1 se basso, 0 se ok, +1 se troppo alto
	 */
	
	public int tentativo(int t){
		
		if(!inGame){
			
			throw new IllegalStateException("Partita non in corso");
		}
		
			if (!valoreValido(t)){
				
				throw new InvalidParameterException("Tentativo fuori range");
			}
			
			this.tentativi++;
			
				if(tentativi==TMAX){
					inGame=false;
				}
					if(t==this.segreto){
						inGame=false;
						return 0;
					}
					else if(t < this.segreto){
						return -1;
					}	
					else
						return +1;
	}

	/**
	 * Controlla se il tentativo rispetta il range del gioco
	 * @param tentativo
	 * @return true se rispetta, false altrimenti
	 */
	
		
	public boolean valoreValido(int tentativo){
		return tentativo>=1 && tentativo<NMAX ;
	}
	
	public boolean isInGame() {
		return inGame;
	}

	public int getTentativi() {
		return tentativi;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getSegreto() {
		return segreto;
	}
		
}
