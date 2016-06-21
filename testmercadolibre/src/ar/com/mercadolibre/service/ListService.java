package ar.com.mercadolibre.service;

/**
 * Clase de servicio utilizada para realizar operaciones con las listas
 * @author fuceneco
 *
 */
public class ListService {

	private static ListService listService = null;

	private ListService() {
	}

	public static ListService getInstance() {
		if (listService == null) {
			listService = new ListService();
		}

		return listService;
	}

	public int[] sortList(int[] listToMedian) {
		int[] listSorted = listToMedian.clone();
		int aux = 0;
		for (int i = 1; i < listSorted.length; i++) {
			for (int j = 0; j < listSorted.length - i; j++) {
				if (listSorted[j] > listSorted[j + 1]) {
					aux = listSorted[j];
					listSorted[j] = listSorted[j + 1];
					listSorted[j + 1] = aux;
				}
			}
		}
		return listSorted;
	}

	public int[] findTheMedians(int[] listToMedianSorted) {

		boolean isOdd = !(listToMedianSorted.length % 2 == 0);
		int medians[] = new int[isOdd ? 1 : 2];

		// itero para buscar las medianas de la matriz
		for (int i = 0; i < listToMedianSorted.length; i++) {
			// me fijo si la cantidad de numeros que contiene la matriz es par o
			// impar
			// en caso de ser par tiene solo una media, sino dos
			if (!isOdd) {
				medians[0] = listToMedianSorted[listToMedianSorted.length / 2];
				medians[1] = listToMedianSorted[(listToMedianSorted.length / 2) - 1];
			} else {
				medians[0] = listToMedianSorted[listToMedianSorted.length / 2];
			}
		}
		
		System.out.println( "Median 1: " + medians[0]);
		if(!isOdd) {
			System.out.println( "Median 2: " + medians[1]);
		}

		return medians;

	}

	public int[] getListToMatrixMedian(int[] medians, int[] listToMedian,
			int[] listToMedianSorted) {
		boolean isOdd = !(listToMedian.length % 2 == 0);

		// itero para intercambiar los valores de las medianas por los valores
		// del vector
		for (int i = 0; i < listToMedian.length; i++) {
			if (!isOdd) {
				if (medians[0] == listToMedian[i]) {
					listToMedian[i] = listToMedian[(listToMedian.length / 2)];
					listToMedian[(listToMedian.length / 2)] = medians[0];
				} else if (medians[1] == listToMedian[i]) {
					listToMedian[i] = listToMedian[(listToMedianSorted.length / 2) - 1];
					listToMedian[(listToMedianSorted.length / 2) - 1] = medians[1];
				}
			} else if (medians[0] == listToMedian[i]) {
				listToMedian[i] = listToMedian[(listToMedian.length / 2)];
				listToMedian[(listToMedian.length / 2)] = medians[0];
			}
		}
		
		return listToMedian;
	}

}
