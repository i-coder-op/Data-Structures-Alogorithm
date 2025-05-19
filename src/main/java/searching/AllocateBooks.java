package searching;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

    public static void main(String[] args) {
        ArrayList<Integer> books = new ArrayList<>();
        books.addAll(Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9));
//        books.addAll(Arrays.asList(5, 17,100, 11));

        AllocateBooks allocateBooks = new AllocateBooks();
        System.out.println(allocateBooks.books(books, 5));
    }

    public int books(ArrayList<Integer> books, int students) {
        int low = 0;
        int high = 0;
        for (Integer pages : books) {
            if (low < pages) {
                low = pages;
            }

            high = high + pages;
        }

        if (books.size() == students) {
            return low;
        }

        return compute(low, high, books, students);
    }

    int compute(int low, int high, ArrayList<Integer> books, int students) {
        int answer = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean result = isValid(mid, books, students);

            if (!result) {
                low = mid + 1;
            } else {
                answer = mid;
                high = mid - 1;
            }
        }
        return answer;
    }

    boolean isValid(int k, ArrayList<Integer> books, int students) {
        int sum = 0;
        int partitions = 1;
        int p = 0;
        while (p < books.size()) {
            sum = sum + books.get(p);
            if (sum > k) {
                partitions++;
                sum = 0;
            } else {
                p++;
            }
        }
        if (partitions <= students) {
            return true;
        }
        return false;
    }

//    boolean isValid(int k, ArrayList<Integer> books, int students) {
//        int sum = 0;
//        int partitions = 1;
//        int p=0;
//
//        while (p < books.size()) {
//            sum = sum+books.get(p);
//
//            if(sum > k) {
//                partitions++;
//                sum = books.get(p);
//            }
//
//            if (partitions > students) {
//                return false;
//            }
//            p++;
//        }
//
//        System.out.println("k: " + k);
//        System.out.println("partitions: " + partitions);
//
//        return true;
//    }
}
