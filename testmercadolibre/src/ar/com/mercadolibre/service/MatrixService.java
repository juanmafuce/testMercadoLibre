package ar.com.mercadolibre.service;

import ar.com.mercadolibre.model.Matrix;

/**
 * 
 * @author fuceneco
 * 
 */
public class MatrixService {

	private static MatrixService matrixService = null;

	private MatrixService() {
	}

	public static MatrixService getInstance() {
		if (matrixService == null) {
			matrixService = new MatrixService();
		}

		return matrixService;
	}

	public Matrix getMatrixMedian(Matrix matrix) {

		// convierto la matriz a lista
		int[] listToMedian = convertMatrixToList(matrix);

		// lo paso a una lista ordenada
		int[] listToMedianSorted = ListService.getInstance().sortList(
				listToMedian);

		// busco la/las medianas
		int[] medians = ListService.getInstance().findTheMedians(
				listToMedianSorted);

		// armo la lista con los valores reemplazados para armar la matriz
		// mediana
		int[] listToMatrixMedian = ListService.getInstance()
				.getListToMatrixMedian(medians, listToMedian,
						listToMedianSorted);

		return new Matrix(convertListToMatrix(listToMatrixMedian));

	}

	private int[][] convertListToMatrix(int[] listToMatrixMedian) {
		int count = 0;
		int matrixLenght = (int) Math.sqrt(listToMatrixMedian.length);
		int[][] matrixNew = new int[matrixLenght][matrixLenght];
		// armo nuevamente la matriz
		for (int i = 0; i < matrixLenght; i++) {
			for (int j = 0; j < matrixLenght; j++) {
				matrixNew[i][j] = listToMatrixMedian[count];
				count++;
			}
		}

		return matrixNew;
	}

	private int[] convertMatrixToList(Matrix matrix) {
		int positions = 0;
		int[] listToMedian = new int[matrix.getN() * matrix.getN()];
		// paso la matriz a una lista de nxn
		for (int i = 0; i < matrix.getN(); i++) {
			for (int j = 0; j < matrix.getN(); j++) {
				listToMedian[positions] = (matrix.getMatrix()[i][j]);
				positions++;
			}
		}
		return listToMedian;
	}
	
	
	public void showMatrix(Matrix matrix) {
		for (int i = 0; i < matrix.getN(); i++) {
			for (int j = 0; j < matrix.getN(); j++) {
				System.out.print(matrix.getMatrix()[i][j] + " ");
			}
			System.out.println();
		}
	}

}
