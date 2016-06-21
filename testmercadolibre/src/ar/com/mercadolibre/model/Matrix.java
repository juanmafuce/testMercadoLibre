package ar.com.mercadolibre.model;

/**
 * 
 * @author fuceneco
 * Clase utilizada para crear el objeto del tipo matriz
 */

public class Matrix {
	
	private int [][] matrix;
	
	private int n;
	
	public Matrix(int n) {
		this.n = n;
		this.matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = new Double(Math.random() * 100).intValue();
			}
		}
	}

	public Matrix(int[][] convertListToMatrix) {
		this.matrix = convertListToMatrix;
		this.n = convertListToMatrix.length;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public int getN() {
		return n;
	}

}
