package pkgGame;

import java.util.Arrays;
import java.util.HashSet;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int iSize) throws Exception {
		super();
		this.iSize = iSize;
		try {
			if((Math.sqrt(iSize) - Math.floor(Math.sqrt(iSize)))!=0) {
				throw new Exception ();
			}
	}
		catch(Exception e) {
			throw e;
		}
		
		this.iSqrtSize = (int) Math.sqrt(iSize);
	}
	
	public Sudoku(int[][] latinSquare) throws Exception {
		super(latinSquare);
		this.iSize = latinSquare.length;
		this.iSqrtSize = (int) Math.sqrt(iSize);
		try {
			if((Math.sqrt(iSize) - Math.floor(Math.sqrt(iSize)))!=0) {
				throw new Exception();
			}
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	protected int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	
	protected int[] getRegion(int iRegionNbr) {
		int[] region = new int[iSize];
		
		int[][] latinSquare = super.getLatinSquare();
		int row = iRegionNbr - iRegionNbr % iSqrtSize;
		int col = iRegionNbr % iSqrtSize * iSqrtSize;
		int i = 0;
		for(int j = row; j < row + iSqrtSize; j++) {
			for (int k = col; k < col + iSqrtSize; k++) {
				region[i] = latinSquare[j][k];
				i++;
			}
		}
		return region;
	}
	
	protected int[] getRegion(int Col, int Row) {
		int region = Row/iSqrtSize * iSqrtSize + Col/iSqrtSize;
		return getRegion(region);
	}
	
	//isPartialSudoku - returns true if the puzzle is a Sudoku 
	//and any of the values is zero
	
	public boolean isPartialSudoku() {
			for(int i = 0; i < iSize; i++) {
				if(hasDuplicates(getRegion(i)) == false) {
					for(int j = 0; j < iSize; j++) {
						if(hasAllValues(getRow(0), getRegion(j))) {
							return true;
						}
					}
				}
			}
		return false;
	}
	
	//isSudoku - returns true if the puzzle is a latin square
	//and each value of each region exists in the first row of the puzzle
	
	public boolean isSudoku() {
		boolean result = true;
		if(super.ContainsZero()) {
			result = false;
		}
		if(!super.isLatinSquare()) {
			result = false;
		}
		for(int k = 0; k < super.getLatinSquare().length; k++) {
			if(super.hasDuplicates(getRegion(k))) {
				result = false;
				break;
			}
		}
		for(int j = 0; j < super.getLatinSquare().length; j++) {
			if(!super.hasAllValues(getRegion(j), super.getRow(1))) {
				result = false;
				break;
			}
		}
		return result;
		
	}
	
	//isValueValid checks the following:
	//iValue - the value you're attempting
	//Col - column in the puzzle
	//Row - row in the puzzle
	//returns true if iValue is found in the puzzle
	
	public boolean isValidValue(int iValue, int Col, int Row) {

		int[] row = super.getRow(Row);
		int[] col = super.getColumn(Col);
		
		if(super.doesElementExist(col, iValue) && super.doesElementExist(row, iValue)) {
			return true;
		}
		return false;
	}
}
