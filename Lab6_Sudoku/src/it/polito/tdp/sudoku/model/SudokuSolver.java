package it.polito.tdp.sudoku.model;

public class SudokuSolver {
	private int m[][]= new int[9][9];
	
	public void setMatrice(int[][] s){
		m=s;
	}
	
	public int[][] getMatrice(){
		return m;
	}

	public int[][] solve(int passo) {
		if(passo==81){
		 return m;
		}
		for (int i = 1; i < 10; i++) {
			if (m[passo/9][passo%9]!=0){
				int temp[][]=solve(passo+1);
				if(temp!=null) 
					{return temp;
					}
					
			}
			else{
				m[passo/9][passo%9]=i;
				if(isValid( passo, i)){
					int temp[][]=solve(passo+1);
					if(temp!=null) {
						return temp;
					}
				}
				m[passo/9][passo%9]=0;
			}
			
		}
		return null;
	}

	private boolean isValid(int passo, int valore) {
		//controllo riga
		for (int i = 0; i < 9; i++) {
			if(i!=(passo%9)){
			if(m[passo/9][i]==valore){
				return false;
			}
			}
		}
		
		//controllo colonna
		for (int i = 0; i < 9; i++) {
			if(i!=(passo/9)){
				if(m[i][passo%9]==valore){
					return false;
				}
			}
		}
		
		//controllo quadrato
		int riga =passo/9;
		int colonna=passo%9;
		int r=(riga/3);
		r*=3;
		int c=(colonna/3);
		c*=3;
		
		for (int i =r; i < (r+3); i++) {
			for (int j = c; j < (c+3); j++) {
				if(i!=riga || j!=colonna){
				if(m[i][j]==valore){
				return false;
				}
				}
			}
		}
		
		return true;
	}

	
	
}
