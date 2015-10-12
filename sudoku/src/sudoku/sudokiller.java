package sudoku;

public class sudokiller {

//sudokiller.java
//
//Previous: sudokiller.gf  Up: Software  Next: sudokiller.js
///*******************************************************************************
// * SudoKiller.java - A Graphical Java Sudoku solver                            *
// *                                                                             *
// * Source code is made up of multiple files (one for each class) that are      *
// * shown, here, sequentially.                                                  *
// *                                                                             *
// * Download sources                                                            *
// *******************************************************************************/
//
///*******************************************************************************
// * Main.java                                                                   *
// *******************************************************************************/
//package sudokiller;
//
///**
// * Sudoku game solver.
// * It creates a GUI with a default puzzle; you can replace it with the puzzle
// * you want to solve. Then click the 'Start' button (or type 'ALT-s') to get the
// * solution.
// *
// * @author Daniele Mazzocchio
// * @version 1.0
// */
//public class Main {
//    
//    /**
//     * Creates the GUI with a default puzzle.
//     * @params args Command-line arguments (unused)
//     */
//    public static void main(String[] args) {
//        int[][] board = {{0, 6, 0, 1, 0, 4, 0, 5, 0},
//                         {0, 0, 8, 3, 0, 5, 6, 0, 0},
//                         {2, 0, 0, 0, 0, 0, 0, 0, 1},
//                         {8, 0, 0, 4, 0, 7, 0, 0, 6},
//                         {0, 0, 6, 0, 0, 0, 3, 0, 0},
//                         {7, 0, 0, 9, 0, 1, 0, 0, 4},
//                         {5, 0, 0, 0, 0, 0, 0, 0, 2},
//                         {0, 0, 7, 2, 0, 6, 9, 0, 0},
//                         {0, 4, 0, 5, 0, 8, 0, 7, 0}};
//        
//        new SwingSudoKiller(new SwingSudokuBoard(board));
//    }   
//}
//
//
///*******************************************************************************
// * SudokuBoard.java                                                            *
// *******************************************************************************/
//package sudokiller;
//
///**
// * This is the base class for implementing a Sudoku board.
// * It mostly is a two-dimensional <code>int<code> array and provides
// * basic methods for getting/setting cells contents. Board cells are identified
// * by their row and column and are zero-indexed.
// * 
// * @author Daniele Mazzocchio
// * @version 1.0
// */
//public class SudokuBoard {
//    final int EMPTY = 0;      // Empty cells marker
//    final int size;           // Size of the board (number of rows and columns)
//    final int box_size;       // Size of the inner boxes
//
//    private int[][] board;    // 2D array representing the game board
//
//    /**
//     * Creates an empty board.
//     * @param size Number of rows and columns of the board.
//     */
//    public SudokuBoard(int size) {
//        board = new int[size][size];
//        this.size = size;
//        this.box_size = (int) Math.sqrt(size);
//    }
//    
//    /**
//     * Creates and initializes the board.
//     * @param board Array to initialize the board contents.
//     */
//    public SudokuBoard(int[][] board) {
//        this(board.length);
//        this.board = board;
//    }
//    
//    /**
//     * Puts a number into a specific cell.
//     * @param num Number to put into the board cell.
//     * @param row Cell's row.
//     * @param col Cell's column.
//     */
//    public void setCell(int num, int row, int col) {
//        board[row][col] = num;
//    }
//
//    /**
//     * Returns the number contained in a specific cell.
//     * @param row Cell's row.
//     * @param col Cell's column.
//     * @return The number contained in the cell.
//     */
//    public int getCell(int row, int col) {
//        return board[row][col];
//    }
//}
//
//
///*******************************************************************************
// * SudoKiller.java                                                             *
// *******************************************************************************/
//package sudokiller;
//
///**
// * This is the base class for implementing a Sudoku solver.
// * It provides a simple method for guessing the solution, but lets subclasses
// * decide how to display it.
// * 
// * @author Daniele Mazzocchio
// * @version 1.0
// */
//abstract class SudoKiller {
//    private SudokuBoard sb;    // Puzzle to solve;
//
//    /**
//     * Initializes the game board.
//     * @param sb The puzzle to solve.
//     */
//    public SudoKiller(SudokuBoard sb) {
//        this.sb = sb;
//    }
//    
//    /**
//     * Check if a number is, according to Sudoku rules, a legal candidate for
//     * the given cell.
//     * @param num Number to check.
//     * @param row Cell's row.
//     * @param col Cell's column.
//     * @return <code>false<code> if <code>num<code> already appears in the row,
//     *         column or box the cell belongs to or <code>true<code> otherwise.
//     */
//    private boolean check(int num, int row, int col) {
//        int r = (row / sb.box_size) * sb.box_size;
//        int c = (col / sb.box_size) * sb.box_size;
//        
//        for (int i = 0; i < sb.size; i++) {
//            if (sb.getCell(row, i) == num ||
//                sb.getCell(i, col) == num ||
//                sb.getCell(r + (i % sb.box_size), c + (i / sb.box_size)) == num) {
//                return false;
//            }
//        }
//        return true;
//    }
//    
//    /**
//     * Test all candidate numbers for a given cell until the board is complete.
//     * @param row Cell's row.
//     * @param col Cell's column.
//     * @return <code>false<code> if no legal numbers are found for this cell.
//     */
//    public boolean guess(int row, int col) {
//        int nextCol = (col + 1) % sb.size;
//        int nextRow = (nextCol == 0) ? row + 1 : row;
//        
//        try {
//            if (sb.getCell(row, col) != sb.EMPTY)
//                return guess(nextRow, nextCol);
//        }
//        catch (ArrayIndexOutOfBoundsException e) {
//                return true;
//        }
//
//        for (int i = 1; i <= sb.size; i++) {
//            if (check(i, row, col)) {
//                sb.setCell(i, row, col);
//                if (guess(nextRow, nextCol)) {
//                    return true;
//                }
//            }
//        }
//        sb.setCell(sb.EMPTY, row, col);
//        return false;
//    }
//}
//
//    
///*******************************************************************************
// * SwingSudokuBoard.java                                                       *
// *******************************************************************************/
//package sudokiller;
//
//import java.awt.*;
//import javax.swing.*;
//
///**
// * This class represents a graphical Sudoku board.
// * It is mostly a two-dimensional <code>JTextField<code> array
// * providing all the functionality of a <code>SudokuBoard<code> object.
// * Board cells are identified by their row and column and are zero-indexed.
// *
// * @author Daniele Mazzocchio
// * @version 1.0
// */
//public class SwingSudokuBoard extends SudokuBoard {
//    private JTextField[][] cells;          // Graphical game board
//    private JPanel panel = new JPanel();   // Container
//
//    /**
//     * Draws an empty board.
//     * @param size Number of rows and columns of the board.
//     */
//    public SwingSudokuBoard(int size) {
//        super(size);
//        cells = new JTextField[size][size];
//        panel.setLayout(new GridLayout(size, size));
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++)  {
//                cells[row][col] = new JTextField(1);
//                panel.add(cells[row][col]);
//            }
//        }
//    }
//
//    /**
//     * Draws and initializes the board.
//     * @param board Array to initialize the board contents.
//     */
//    public SwingSudokuBoard(int[][] board) {
//        this(board.length);
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                setCell(board[row][col], row, col);
//            }
//        }
//    }
//    
//    /**
//     * Puts a number into a specific text field.
//     * @param num Number to put into the text field (cell).
//     * @param row Cell's row.
//     * @param col Cell's column.
//     */
//    public void setCell(int num, int row, int col) {
//        super.setCell(num, row, col);
//        String text = (num == EMPTY) ? "" : String.valueOf(num);
//        cells[row][col].setText(text);
//    }
//    
//    /**
//     * Returns the number contained in a specific text field (cell).
//     * @param row Cell's row.
//     * @param col Cell's column.
//     * @return The number contained in the cell.
//     */
//    public int getCell(int row, int col) {
//        int cell;
//
//        try {
//            cell = Integer.parseInt(cells[row][col].getText());
//        }
//        catch (NumberFormatException e) {
//            cell = EMPTY;
//        }
//        return cell;
//    }
//    
//    /**
//     * Returns the JPanel containing the board.
//     * @return Returns the board container.
//     */
//    public JPanel getPanel() {
//        return panel;
//    }
//}
//
//
///*******************************************************************************
// * SwingSudoKiller.java                                                        *
// *******************************************************************************/
//package sudokiller;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
///**
// * Graphical Sudoku game solver.
// * The user should fill the board with the puzzle to solve and click the
// * 'Start' button (or type 'ALT-s') to get the solution.
// *
// * @author Daniele Mazzocchio
// * @version 1.0
// */
//public class SwingSudoKiller extends SudoKiller {
//
//    /**
//     * Draw the game board.
//     * @param ssb The puzzle to solve.
//     */
//    public SwingSudoKiller(SwingSudokuBoard ssb) {
//        super(ssb);
//        final JPanel panel = ssb.getPanel();
//
//        Runnable runner = new Runnable() {
//            public void run() {
//                final JFrame frame = new JFrame("SudoKiller");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                ActionListener al = new ActionListener() {
//                    public void actionPerformed(ActionEvent ae) {
//                        if (! guess(0, 0))
//                            JOptionPane.showMessageDialog(frame, "Solution not found!");
//                    }
//                };
//                frame.setLayout(new GridBagLayout());
//                addComponent(frame, panel, 0, 0, 1, 1);
//                
//                JButton b = new JButton("Start!");
//                b.setMnemonic(KeyEvent.VK_S);
//                b.addActionListener(al);
//                addComponent(frame, b, 0, 1, 1, 1);
//
//                frame.setSize(240, 280);
//                frame.setVisible(true);
//            }
//        };
//        EventQueue.invokeLater(runner);
//    }
//    
//    /**
//     * Add a component to the GUI.
//     * @param container Container to add the component to.
//     * @param component The component to be added.
//     * @param gridx Horizontal cell position inside the grid.
//     * @param gridy Vertical cell position inside the grid.
//     * @param gridwidth Number of cells in a row for the text field.
//     * @param gridheight Number of cells in a column for the text field.
//     */
//    private static void addComponent(Container container, Component component,
//        int gridx, int gridy, int gridwidth, int gridheight) {
//        Insets insets = new Insets(0, 0, 0, 0);
//        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth,
//                gridheight, 1, 1, GridBagConstraints.CENTER,
//                GridBagConstraints.BOTH, insets, 0, 0);
//        container.add(component, gbc);
//    }
//}
//sudokiller.java
//
//Previous: sudokiller.gf  Up: Software  Next: sudokiller.js
//	
//	
}
	
	