public class Main {
    public static void main(String[] args) throws Exception {
        int[][] input = ArrayUtils.readIntArray2FromConsole();
        Fraction[][] matrix = new Fraction[input.length][input.length];
        for (int r = 0; r < input.length; r++) {
            for (int c = 0; c < input.length; c++) {
                matrix[r][c] = new Fraction(input[r][c]);
            }
        }
        double det = (Matrix.calcDet(matrix)).toDouble();
//        Matrix.print(matrix);
        System.out.println(det);
    }
//    2 3 -3 4
//    2 1 -1 2
//    6 2 1 0
//    2 3 0 -5

//    1 2 3
//    4 6 3
//    7 5 3
}
