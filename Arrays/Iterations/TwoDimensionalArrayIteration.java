class TwoDimensionalArrayIteration{
  
      public void kthSmallest(int[][] matrix) {

         // Iterate the rows
        for (int row=0; row < matrix.length; row++){
            // Iterate the columns
            for (int col=0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col]+ " ");
            }
            System.out.println();
        }
    }

}
