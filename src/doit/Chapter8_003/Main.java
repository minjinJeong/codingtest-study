package doit.Chapter8_003;

import java.util.*;

/**
 * 각 정렬 알고리즘을 이용하여,
 * 입력받은 N만큼의 수를 오름차순 정렬하는 코드
 */

public class Main {
    public static void main(String[] args) throws Exception {
        // insertionSort();
        // quickSort();
        // mergeSort();
        radixSort();
    }
    
    private static void insertionSort() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // temp : 정렬할 데이터, j : 정렬된 범위
        int temp, j;
        for (int i = 1; i < N; i++) {
            
            temp = A[i];

            for (j = i-1; j >= 0; j--) {

                if(A[j] > temp) {
                    // 선택 데이터보다 클 경우 한 칸 뒤로 Shift
                    A[j+1] = A[j];
                }
                else {
                    // 선택 데이터보다 작을 경우 반복문 종료
                    break;
                }
            }

            A[j+1] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }
    
    private static void quickSort() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        quick(A, 0, N-1);

        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }
    
    public static void quick(int[] arr, int left, int right) {
        // base condition
        if (left >= right) {
            return;
        }
        int pivot = arr[right];
        
        int sortedIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, sortedIndex);
                sortedIndex++;
            }
        }
        swap(arr, sortedIndex, right);
        quick(arr, left, sortedIndex - 1);
        quick(arr, sortedIndex + 1, right);
    }
    
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    private static void mergeSort() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        devide(A, 0, N);

        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }

    private static void devide(int[] arr, int low, int high) {
        if (high - low < 2) {
            return;
        }

        int mid = (low + high) / 2;
        devide(arr, 0, mid);
        devide(arr, mid, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low];
        int t = 0, l = low, h = mid;

        while (l < mid && h < high) {
            if (arr[l] < arr[h]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[h++];
            }
        }

        while (l < mid) {
            temp[t++] = arr[l++];
        }

        while (h < high) {
            temp[t++] = arr[h++];
        }

        for (int i = low; i < high; i++) {
            arr[i] = temp[i - low];
        }
    }
    
    private static void radixSort() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 자릿수 (개수)
        int MaxNumber = A[0];
        for (int num : A){
        	if (num > MaxNumber) {
                MaxNumber = num;
            }
        }
        
        // bucket 초기화
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }

        // 자릿수를 기준으로 정렬
        for (int exp = 1; exp <= MaxNumber; exp *= 10) {

            // 버킷에 분류하여 저장
            for (int num : A) {
                int digit = (num / exp) % 10;
                buckets[digit].add(num);
            }

            // 버킷에서 꺼내기 (정렬)
            int index = 0;
            for (int digit = 0; digit < buckets.length; digit++) {
                while (!buckets[digit].isEmpty()) {
                    A[index++] = buckets[digit].poll();
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }
}