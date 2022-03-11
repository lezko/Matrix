public class Matrix {
    private static Fraction[] getRow(Fraction[][] matrix, int rowIndex, int startIndex) throws Exception {
        Fraction[] result = new Fraction[matrix[0].length];
        for (int i = startIndex; i < result.length; i++) {
            result[i] = matrix[rowIndex][i].copy();
        }
        return result;
    }

    private static Fraction[] getCol(Fraction[][] matrix, int colIndex) throws Exception {
        Fraction[] result = new Fraction[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[i][colIndex].copy();
        }
        return result;
    }

    private static void addSubRow(Fraction[][] matrix, int targetRow, int subRow, Fraction k) throws Exception {
        for (int i = 0; i < matrix[0].length; i++) {
            (matrix[targetRow][i]).add(Fraction.mult(matrix[subRow][i], k));
        }
    }

    private static Fraction[] getMatchingFactor(Fraction[] arr, int numIndex, int startIndex) throws Exception {
        int foundRowIndex = -1;
        Fraction number = arr[numIndex].copy();
        Fraction factor = new Fraction();

        for (int i = startIndex; i < arr.length; i++) {
            if (i != numIndex && arr[i].equals(0) != 0) {
                if (Fraction.mod(number, arr[i]).equals(0) == 0) {
                    factor.reInit(-number.getNumerator(), number.getDenomerator());
                    factor.div(arr[i]);
                    foundRowIndex = i;
                    break;
                }
            }
        }

        if (foundRowIndex == -1) {
            for (int i = startIndex; i < arr.length; i++) {
                if (arr[i].equals(0) != 0) {
                    factor.reInit(-number.getNumerator(), number.getDenomerator());
                    factor.div(arr[i]);
                    foundRowIndex = i;
                    break;
                }
            }
        }

        return new Fraction[]{new Fraction(foundRowIndex), factor};
    }
    
    private static void swapRows(Fraction[][] matrix, int r1Index, int r2Index) {
        Fraction[] r1 = matrix[r1Index];
        Fraction[] r2 = matrix[r2Index];
        matrix[r1Index] = r2;
        matrix[r2Index] = r1;
    }

    public static Fraction calcDet(Fraction[][] matrix) throws Exception {
        makeHalfNull(matrix);
        System.out.println();
        Fraction result = new Fraction(1);
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (r == c) {
                    result.mult(matrix[r][c]);
                }
            }
        }

        return result;
    }
    
    private static void makeHalfNull(Fraction[][] matrix) throws Exception {
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                if (r > c) {
                    if (matrix[r][c].equals(0) != 0) {
                        Fraction[] factor = getMatchingFactor(getCol(matrix, c), r, c);
                        if (factor[1].equals(0) == 0) {
                            swapRows(matrix, r, c);
                            break;
                        } else {
                            addSubRow(matrix, r, (int) factor[0].getNumerator(), factor[1]);
                        }
    
                        System.out.println(r + " " + c);
                        System.out.println("rIndex = " + factor[0].toDouble());
                        System.out.println("k = " + factor[1].toDouble());
                        System.out.println();
                        Matrix.print(matrix);
                        System.out.println();
                    }
                }
            }
        }
    }
    
    public static void print(Fraction[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c].getDenomerator() == 1) {
                    System.out.print(matrix[r][c].getNumerator() + ", ");
                } else {
                    System.out.print(matrix[r][c].getNumerator() + "/" + matrix[r][c].getDenomerator() + ", ");
                }
            }
            System.out.println();
        }
    }
}
