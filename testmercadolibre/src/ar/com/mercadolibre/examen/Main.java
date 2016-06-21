package ar.com.mercadolibre.examen;

import ar.com.mercadolibre.model.Matrix;
import ar.com.mercadolibre.service.MatrixService;


 /**
  * @author fuceneco
  *
  */
public class Main {

	public static void main(String[] args) {
		
		Matrix matrix = new Matrix(4);
		System.out.println("Matrix: ");
		MatrixService.getInstance().showMatrix(matrix);
		Matrix matrixMedian = MatrixService.getInstance().getMatrixMedian(matrix);
		System.out.println("Matrix Median: ");
		MatrixService.getInstance().showMatrix(matrixMedian);
		
	}
}
