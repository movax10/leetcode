public class FilesIdentity {
// You are given with two csv files that are presented as arrays. First row is always header. 
// Columns in file could be presented in any order
// rows in file(except header row) could be presented in any row
// write a function to check that file content is identical despite columns and row positions
//P.S. given files are identical
    private static int HEAD_ROW = 0;

    private static String[][] fileA = new String[][]{
            {"A", "B", "C", "D", "E"},
            {"1", "2", "3", "4", "E1"},
            {"5", "6", "7", "8", "E2"},
            {"9", "10", "11", "12", "E3"},
            {"13", "14", "15", "16", "E4"},
    };

    private static String[][] fileB = new String[][]{
            {"A", "D", "E", "C", "B"},
            {"9", "12", "E3", "11", "10"},
            {"1", "4", "E1", "3", "2"},
            {"5", "8", "E2", "7", "6"},
            {"13", "16", "E4", "15", "14"}
    };
}
