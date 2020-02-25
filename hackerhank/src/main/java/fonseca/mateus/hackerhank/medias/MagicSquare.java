package fonseca.mateus.hackerhank.medias;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MagicSquare {
	
	private static class Tupla {
		static public Integer[][] first;
		static public Integer[][] second;
	}
	static int[] paths(int pair) {
		int[] r = new int[2];
		if (pair / 2 == 1) {
			r[0] = 7;
			r[1] = 9;
		} else if (pair / 2 == 2) {
			r[0] = 3;
			r[1] = 9;
		} else if (pair / 2 == 3) {
			r[0] = 1;
			r[1] = 7;
		} else if (pair / 2 == 4) {
			r[0] = 1;
			r[1] = 3;
		}

		return r;
	}
	static Integer[][] generateMagicSquare(int first, int second){
		Integer[][] magicSquare = new Integer[3][3];
		
		magicSquare[1][1] = 5;
		
		magicSquare[0][0] = first;
		magicSquare[0][1] = second;
		
		int current; 
		current = Math.abs(magicSquare[0][0] - 10);
		magicSquare[2][2] = current;
		
		current = Math.abs(magicSquare[0][1] - 10);
		magicSquare[2][1] = current;
		
		current = Math.abs(magicSquare[0][0] + magicSquare[0][1] - 15);
		magicSquare[0][2] = current;
		
		current = Math.abs(current - 10);
		magicSquare[2][0] = current;
		
		current = Math.abs(magicSquare[0][0] + magicSquare[2][0] - 15);
		magicSquare[1][0] = current;
		
		current = Math.abs(current - 10);
		magicSquare[1][2] = current;

		return magicSquare;
	}
	
	static Tupla generateMagicSquare(int corner){
		int[] paths = paths(corner);
		
		Tupla magicSquares = new Tupla();
		magicSquares.first = generateMagicSquare(corner, paths[0]);
		magicSquares.second = generateMagicSquare(corner, paths[1]);
		
		return magicSquares;
	}
	
	static List<Integer[][]> generateMagicSquares(){
		List<Integer[][]> magicSquares = new ArrayList<>();
		
		Stream.of(2, 4 , 6 , 8).forEachOrdered(corner -> {
			Tupla generated = generateMagicSquare(corner);
			magicSquares.add(generated.first);
			magicSquares.add(generated.second);
		});
		
		return magicSquares;
	}
	
	static int absoluteDifference(int[][] base, Integer[][] other) {
		
		int acc = 0;
		
		for(int row = 0; row < 3;row++) {
			for(int column = 0; column <3; column++) {
				acc += Math.abs(base[row][column] - other[row][column]);
			}
		}
		
		return acc;
	}
	
	static public int formingMagicSquare(int[][] s) {
		int bestMatch = Integer.MAX_VALUE;		
		
		for(Integer[][] magicSquare : generateMagicSquares()) {
			int current = absoluteDifference(s, magicSquare);
			if(current < bestMatch) bestMatch = current;
		}
		
		return bestMatch;
	}


	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);

		System.out.println(result);

		scanner.close();
	}
}
