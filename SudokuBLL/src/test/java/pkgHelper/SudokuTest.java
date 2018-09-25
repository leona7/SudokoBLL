package pkgHelper;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgGame.Sudoku;

public class SudokuTest {

        @Test
        public void GetRegion() throws Exception{
                int[][] myArray = {{1,2,3,4},
                                {2,3,4,1},{3,4,1,2},{4,1,2,3}};
                Sudoku test = new Sudoku(myArray);
                int[] answer = {1,2,2,3};
                int[] answer1 = {3,4,4,1};

        }
        @Test
        public void getRegionTest() throws Exception{
                int[][] myArray = {{1,2,3,4,5,6,7,8,9},
                                {1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},
                                {1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},
                                {1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},
                                {1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}};
                Sudoku test = new Sudoku(myArray);
                int[] answer = {1,2,3,1,2,3,1,2,3};
                int[] answer2 = {4,5,6,4,5,6,4,5,6};
                int[] answer1 = {7,8,9,7,8,9,7,8,9};

        }

        @Test
        public void isPartialSudokuTest() throws Exception{
                int[][] myArray = {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
                int[][] myArray2 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
                int[][] myArray3 = {{1,4,0,2},{3,2,4,1},{4,1,2,3},{2,3,1,4}};

                Sudoku test1 = new Sudoku(myArray);
                Sudoku test2 = new Sudoku(myArray2);
                Sudoku test3 = new Sudoku(myArray3);
                
                assertTrue(test3.isPartialSudoku());
                assertFalse(test2.isPartialSudoku());

        }
        @Test
        public void isSudokuTest() throws Exception{
                int[][] myArray = {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
                int[][] myArray2 = {{1,4,0,2},{3,2,4,1},{4,1,2,3},{2,3,1,4}};
                int[][] myArray3 = {{1,4,3,2},{3,2,4,1},{4,1,2,3},{2,3,1,4}};

                Sudoku test1 = new Sudoku(myArray);
                Sudoku test2 = new Sudoku(myArray2);
                Sudoku test3 = new Sudoku(myArray3);
                
                assertTrue(test3.isSudoku());
                assertFalse(test2.isSudoku());



        }
        
        @Test
    	public void isValidValueTest() throws Exception {
    		
    		int[][] notasudoku = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
    		Sudoku myFakeSudoku = new Sudoku(notasudoku);
    		assertTrue(myFakeSudoku.isValidValue(1, 0, 0));
    		assertFalse(myFakeSudoku.isValidValue(4, 0, 0));
    		
    	}
}
