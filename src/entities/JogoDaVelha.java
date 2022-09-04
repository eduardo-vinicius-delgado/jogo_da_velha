package entities;

public class JogoDaVelha {

	private char[][] layout = new char[3][3];
	
	public JogoDaVelha() {
		for (int linha = 0; linha < layout.length; linha++) {
			for (int coluna = 0; coluna < layout[linha].length; coluna++) {
				layout[linha][coluna] = ' ';
			}
		}
	}
	
	public char[][] getLayout (){
		return layout;
	}

	public void mostrarLayout() {
		System.out.println();
		for (int linha = 0; linha < layout.length; linha++) {
			for (int coluna = 0; coluna < layout[linha].length; coluna++) {
				if (coluna < 2) {
					System.out.print(" " + layout[linha][coluna] + " | ");
				} else {
					System.out.print(" " + layout[linha][coluna] + "   ");
				}
			}
			if (linha < 2) {
				System.out.print("\n--   --   -- ");
			}
			System.out.println();
		}
	}

	public int adicionarX(int jogada) {
		if(jogada <= 3) {
			layout[0][jogada-1] = 'X';
			return 1;
		}else if(jogada <= 6){
				layout[1][jogada-4] = 'X';
				return 1;
			}else{
				layout[2][jogada-7] = 'X';
				return 1;
			}
		}
	
	public int adicionarO(int jogada) {
		if(jogada <= 3) {
				layout[0][jogada-1] = 'O';
				return 1;
				
		}else if(jogada <= 6){
				layout[1][jogada-4] = 'O';
				return 1;
		}else{
				layout[2][jogada-7] = 'O';
				return 1;
		}
	}
}
