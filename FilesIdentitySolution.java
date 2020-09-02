package com.udacity.boogle.maps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FilesIdentity {

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

    private static Comparator<String[]> rowComparator = new Comparator<>() {
        @Override
        public int compare(final String[] entry1, final String[] entry2) {
            final String field1 = Arrays.toString(entry1);
            final String field2 = Arrays.toString(entry2);
            return field1.compareTo(field2);
        }
    };

    private static Map<Integer, Integer> getFileAFileBHeaderMap(String[] fileAHeader,
            String[] fileBHeader) {
        Map<Integer, Integer> fileAFileBHeaderMap = new HashMap<>();
        for (int i = 0; i < fileAHeader.length; i++) {
            String header = fileAHeader[i];
            for (int j = 0; j < fileBHeader.length; j++) {
                if (header.equals(fileBHeader[j])) {
                    fileAFileBHeaderMap.put(i, j);
                }
            }
        }
        return fileAFileBHeaderMap;
    }

    private static boolean equalityCheck(String[][] fileA, String[][] fileB) {
        if (Objects.isNull(fileA) || Objects.isNull(fileB) || fileA.length == 0 || fileB.length == 0
                || fileA.length != fileB.length
                || fileA[HEAD_ROW].length != fileB[HEAD_ROW].length) {
            return false;
        }

        Map<Integer, Integer> fileAFileBHeaderMap = getFileAFileBHeaderMap(fileA[HEAD_ROW],
                fileB[HEAD_ROW]);

        if (fileAFileBHeaderMap.size() != fileA[HEAD_ROW].length){
            return false;
        }

        Arrays.sort(fileA, rowComparator);
        Arrays.sort(fileB, rowComparator);

        for (int i = 0; i < fileA.length; i++) {
            for (int j = 0; j < fileA[i].length; j++) {
                int fileBIndex = fileAFileBHeaderMap.get(j);
                if (Objects.nonNull(fileA[i][j]) && Objects.nonNull(fileB[i][fileBIndex])
                        && !fileA[i][j].equals(fileB[i][fileBIndex])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("areEquals " + equalityCheck(fileA, fileB));
    }
}
