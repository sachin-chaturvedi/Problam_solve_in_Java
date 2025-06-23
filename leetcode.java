package Question_solving;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode {



                                                                       // Question-1


  public List<List<Integer>> generate(int numRows) {
    if (numRows == 0)
      return new ArrayList<>();
    if (numRows == 1) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(Arrays.asList(1));
      return result;
    }

    List<List<Integer>> prevRows = generate(numRows - 1);
    List<Integer> newRow = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      newRow.add(1);
    }

    for (int i = 1; i < numRows - 1; i++) {
      newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));
    }

    prevRows.add(newRow);
    return prevRows;
  }



                                                           // Question-2


  static int insartsearch(int arr[], int target) {
    int n = arr.length;
    int sum = 0;
    int i = 0;

    while (i < n) {

      if (arr[i] >= target) {
        sum = i;
        return sum;
      }
      i++;

    }
    sum = n;
    return sum;
  }
       
                                                            // Question-3


  static int rectangular(int nums[]) {
    int n = nums.length;
    int larger = Integer.MIN_VALUE;

    int mid = n / 2;
    if (n % 2 == 0) {
      mid = n / 2 - 1;
    }
    if (n == 2) {
      int i = n - 1;

      if (nums[i - 1] < nums[i]) {
        return nums[i - 1];

      } else {
        return nums[i];
      }

    }

    int temp = 0, sum = 0, index = 0;

    for (int i = 0; i <= mid - 1; i++) {
      if (larger < nums[i]) {
        larger = nums[i];
        temp = i;
      }
    }
    int j = n - 1;
    while (j > mid) {
      if (larger >= nums[j]) {
        index = j - temp;
        nums[j] = (nums[j] * index);
      }

      if (nums[j] > sum) {
        sum = nums[j];
        return sum;
      }

      j--;

    }
    int i = n - 1;
    while (i > mid) {
      if (larger < nums[i]) {
        index = i - temp;
        nums[i] = (larger * index);
      }

      if (nums[i] > sum) {
        sum = nums[i];
        return sum;
      }

      i--;

    }
    return 0;

  }

  static int goodspair(int nums[], int nums1[], int k) {
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums1.length; j++) {
        if (nums[i] % (nums1[j] * k) == 0) {
          total++;
        }
      }
    }
    return total;
  }

  static int waterlevel(int nums[]) {
    int sum = Integer.MIN_VALUE;
    int mull_index = 0;
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        index++;
        if (nums[j] > nums[i]) {
          mull_index = nums[i] * index;
          if (mull_index > sum) {
            sum = mull_index;
          }
        } else {
          mull_index = nums[j] * index;
          if (mull_index > sum) {
            sum = mull_index;
          }
        }
      }
      index = 0;
    }
    return sum;

  }

  static List<List<Integer>> add_three_arr(int nums[]) {
    Set<List<Integer>> l1 = new HashSet<>();
    List<List<Integer>> output = new ArrayList<>();
    int i = 0;

    while (i <= nums.length - 3) {
      int j = 1;
      int k = 2;
      while (j <= nums.length - 2 || k <= nums.length - 1) {
        if (nums[i] + nums[j] + nums[k] == 0) {
          l1.add(Arrays.asList(nums[i]));
          l1.add(Arrays.asList(nums[j]));
          l1.add(Arrays.asList(nums[k]));
        }
        j++;
        k++;
      }
      i++;
    }
    output.addAll(l1);
    return output;
  }

  static int Remove_val_number(int nums[], int val) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[k] = nums[i];
        System.out.print(nums[k]);
        k++;

      }
    }
    return k;
  }

  static boolean search(int nums[], int target) {

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        return true;
      }
    }
    return false;
  }

  static void subarray(int nums[]) {
    int nums_1[] = nums;

    for (int i = 0; i < nums_1.length; i++) {
      for (int j = i; j < nums_1.length; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(nums_1[k] + " ");

        }
      }
    }
  }

  static int profit(int price[]) {
    int ans = 0;

    for (int i = 0; i < price.length; i++) {

      int j = price.length - 1;
      while (j >= i + 1) {
        int temp = price[j] - price[i];
        if (temp > ans) {
          ans = temp;
        }
        j--;
      }
    }

    return ans;
  }

  // static void Three_sum(int nums[]) {
  // ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();
  // // for(int i =0;i<nums.length;i++){
  // // l1.add(new ArrayList<>());
  // // }
  // for (int i = 0; i < nums.length - 2; i++) {

  // for (int j = i + 1; j < nums.length - 1; j++) {

  // if (nums[i] + nums[j] + nums[j + 1] == 0) {
  // l1.add(nums[i]);
  // l1.add(nums[j]);
  // l1.add(nums[j + 1]);
  // }
  // }
  // }

  // System.out.println(l1);
  // }

  static int value(int b) {
    int count = 0;
    while (b > 0) {
      b = b / 10;
      count++;
    }
    return count;
  }

  static int findNumber(int nums[]) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      int ans = value(n);
      if (ans % 2 == 0) {
        if (ans > count) {
          count = ans;
        }
      }
    }
    return count;
  }

  static int maxsum(int num[][], int row, int colume) {
    int maxsum = Integer.MIN_VALUE;
    for (int[] ints : num) {
      int sum = 0;
      for (int intno : ints) {
        sum += intno;
      }
      if (maxsum < sum) {
        maxsum = sum;
      }

    }
    return maxsum;
  }

  // There are present in binery search Question solution;

  static int order_Agnostic_binarysearch(int arrs[], int target) {
    int start = 0;
    int end = arrs.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arrs[mid] == target) {
        return mid;
      }
      if (arrs[start] < arrs[end]) {

        if (target < arrs[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;

        }
      } else {
        if (target > arrs[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;

        }
      }

    }
    return -1;

  }

  static int cleling_binary_search(int arrs[], int target) {
    int start = 0;
    int end = arrs.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (arrs[mid] == target) {
        return arrs[mid];
      }
      if (arrs[mid] > target) {
        end = mid - 1;

      } else {
        start = mid + 1;
      }

    }
    return arrs[start];
  }

  static int search(int arrs[], int target, boolean knowtheIndex) {
    int ans = -1;
    int start = 0;
    int end = arrs.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arrs[mid] < target) {
        start = mid + 1;
      } else if (arrs[mid] > target) {
        end = mid - 1;
      } else {
        ans = mid;
        if (knowtheIndex) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }

    }

    return ans;
  }

  static List<Integer> double_accending(int arr[], int target) {
    ArrayList<Integer> l2 = new ArrayList<>();

    int start = search(arr, target, true);
    int end = search(arr, target, false);
    l2.add(0, start);
    l2.add(1, end);
    if (l2.size() == 0) {
      l2.add(0, -1);
      l2.add(1, -1);
    }
    return l2;
  }

  static int infinity_array(int arrs[], int target, int start, int end) {

    while (start < end) {
      int mid = start + (end - start) / 2;
      if (arrs[mid] < target) {
        start = mid + 1;
      } else if (arrs[mid] > target) {
        end = mid - 1;
      } else {
        return mid;
      }

    }

    return -1;

  }

  static int infinity_array_ans(int arrs[], int target) {

    int start = 0;
    int end = 1;
    int ans = 0;

    while (arrs[end] < target) {
      int newstart = end + 1;
      end = end + (end - start + 1) * 2;
      start = newstart;
      ans = infinity_array(arrs, target, start, end);

    }

    return ans;

  }

  static int mountan_search_gain_large_value(int arrs[]) {
    int ans = Integer.MIN_VALUE;
    int start = 0;
    int end = arrs.length;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (arrs[mid] > arrs[mid + 1]) {
        end = mid;
      } else if (arrs[mid] < arrs[mid + 1]) {
        start = mid + 1;
      }
      if (ans < arrs[mid]) {
        ans = arrs[mid];

      }

    }
    return ans;
  }

  static int squer_root(long target) {
    int ans = Integer.MIN_VALUE;
    int n = 0;

    while (n * n <= target) {
      if (ans <= n) {
        ans = n;
      }
      n++;
    }
    return ans;

  }

  static int peak_value(int arrs[]) {
    int start = 0;
    int ans = Integer.MIN_VALUE;

    int end = arrs.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (arrs[mid] < arrs[mid + 1]) {
        start = mid + 1;
      } else if (arrs[mid] > arrs[mid + 1]) {
        end = mid;
      }
      if (ans < arrs[mid])
        ans = mid;

    }
    return ans;

  }

  static int accending_decending_order(int arrs[], int target, int start, int end) {

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arrs[mid] == target) {
        return mid;
      }
      if (arrs[start] < arrs[end]) {

        if (target < arrs[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;

        }
      } else {
        if (target > arrs[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;

        }
      }

    }
    return -1;
  }

  static int min_second(int arrs[], int target) {
    int ans = Integer.MAX_VALUE;
    // to know the peak value ;
    int pick = peak_value(arrs);
    int start = 0;
    int end = pick;
    int acc = accending_decending_order(arrs, target, start, end);
    int newstart = pick + 1;
    int newend = arrs.length - 1;
    int dec = accending_decending_order(arrs, target, newstart, newend);
    ans = acc;
    if (ans > dec) {
      ans = dec;
    }

    return ans;
  }

  static int pivot_array(int arrays[]) {
    int start = 0;
    int end = arrays.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (mid < end && arrays[mid] > arrays[mid + 1]) {
        return mid;
      }
      if (mid > start && arrays[mid] < arrays[mid - 1]) {
        return mid - 1;
      }
      if (arrays[start] > arrays[mid]) {
        end = mid - 1;
      } else if (arrays[start] < arrays[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }

    }
    return -1;

  }

  static int search5(int array[], int target, int start, int end) {
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] < target) {
        start = mid + 1;
      } else if (array[mid] > target) {
        end = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  static int rotate_array_solution(int arrs[], int target) {
    int pivot = pivot_array(arrs);
    int ans = 0;
    if (pivot == -1) {
      ans = -1;
    }
    if (pivot == arrs.length - 1) {
      int start = 0;
      int end = arrs.length - 1;
      ans = search5(arrs, target, start, end);

    }
    if (arrs[pivot] <= target) {
      int start = 0;
      int end = pivot;
      ans = search5(arrs, target, start, end);
    }
    if (arrs[0] > target) {

      int start = pivot + 1;
      int end = arrs.length - 1;
      ans = search5(arrs, target, start, end);
    }
    return ans;

  }

  static int pivot_in_doublicat_array(int array[]) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (mid > start && array[mid] < array[mid - 1]) {
        return mid - 1;
      }
      if (array[mid] > array[mid + 1] && mid < end) {
        return mid;
      }

      if (array[start] == array[mid] && array[mid] == array[end]) {
        if (array[start] > array[start + 1]) {
          return start;
        }
        start++;
        if (array[end] < array[end - 1]) {
          return end - 1;
        }
        end--;
      } else if (array[start] < array[mid] || (array[start] == array[mid] && array[mid] > array[end])) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  static int doublicat_array_rotate(int arrs[], int target) {
    int pivot = pivot_in_doublicat_array(arrs);
    int ans = 0;
    if (pivot == -1) {
      ans = -1;
    }
    if (pivot == arrs.length - 1) {
      int start = 0;
      int end = arrs.length - 1;
      ans = search5(arrs, target, start, end);

    }
    if (arrs[pivot] <= target) {
      int start = 0;
      int end = pivot;
      ans = search5(arrs, target, start, end);
    }
    if (arrs[0] > target) {
      int start = pivot + 1;
      int end = arrs.length - 1;
      ans = search5(arrs, target, start, end);
    }
    return ans;

  }

  static int binery_root_know(int target) {
    int start = 0;
    int end = target;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (target == 1) {
        return 1;
      }
      if ((mid * mid) > target) {
        end = mid - 1;

      } else if ((mid * mid) < target) {
        start = mid + 1;
      } else {
        return mid;
      }
    }

    if ((start * start) > target) {
      return start - 1;
    } else {
      return start;
    }

  }

  static int guess_the_number(int n, int pick) {
    int start = 1;
    int end = n;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (mid > pick) {
        end = mid - 1;
      } else if (mid < pick) {
        start = mid + 1;

      } else {
        return mid;
      }
    }
    return -1;
  }

  static int rotation_found(int arr[]) {
    int peavot = pivot_array(arr);
    int ans = 1;
    if (peavot == arr.length - 1) {
      ans = 0;

    }
    if (peavot < arr.length - 1) {
      ans = peavot + 1;
    }
    return ans;
  }

  // 2D array binary search algorithem;
  static int[] Two_D_array_binary_search(int arr[][], int target) {
    int row = 0;
    int col = arr.length - 1;
    while (row < arr.length - 1 && col >= 0) {
      if (arr[row][col] == target) {
        return new int[] { row, col };
      }
      if (arr[row][col] < target) {
        row++;
      } else {
        col--;
      }
    }
    ;
    return new int[] { -1, -1 };
  }

  static boolean perfect_squear(int num) {
    int start = 1;
    int end = num;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if ((mid * mid) > num) {
        end = mid - 1;
      } else if ((mid * mid) < num) {
        start = mid + 1;
      } else {
        return true;
      }
    }
    return false;

  }

  static int[] flat_binary_search(int matrix[][], int row, int cstart, int cend, int target) {
    while (cstart <= cend) {
      int mid = cstart + (cend - cstart) / 2;
      if (matrix[row][mid] == target) {
        return new int[] { row, mid };
      }
      if (matrix[row][mid] > target) {
        cend = mid - 1;
      } else {
        cstart = mid + 1;
      }
    }
    return new int[] { -1, -1 };
  }

  static int[] Two_D_array_flat_binary_search(int matrix[][], int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    if (rows == 1) {
      return flat_binary_search(matrix, 0, 0, cols - 1, target);
    }
    int rstart = 0;
    int rend = rows - 1;
    int cmid = cols / 2;
    while (rstart < (rend - 1)) {
      int mid = rstart + (rend - rstart) / 2;
      if (matrix[mid][cmid] == target) {
        return new int[] { mid, cmid };
      }
      if (matrix[mid][cmid] > target) {
        rend = mid;
      } else {
        rstart = mid;
      }
      return new int[] { -1, -1 };
    }
    if (matrix[rstart][cmid] == target) {
      return new int[] { rstart, cmid };
    }
    if (matrix[rstart + 1][cmid] == target) {
      return new int[] { rstart + 1, cmid };

    }
    if (matrix[rstart][cmid] >= target) {
      flat_binary_search(matrix, rstart, 0, cmid - 1, target);
    } else {
      flat_binary_search(matrix, rstart, cmid + 1, cols - 1, target);
    }
    if (matrix[rstart + 1][cmid] >= target) {
      flat_binary_search(matrix, rstart + 1, 0, cmid - 1, target);
    } else {
      flat_binary_search(matrix, rstart + 1, cmid + 1, cols - 1, target);
    }
    return new int[] { -1, -1 };

  }

  static int[] bubble_sort(int nums[]) {
    for (int i = 0; i < nums.length; i++) {
      boolean ans = false;
      for (int j = 1; j < (nums.length) - i; j++) {

        if (nums[j] < nums[j - 1]) {
          int temp = nums[j - 1];
          nums[j - 1] = nums[j];
          nums[j] = temp;
          ans = true;
        }
      }
      if (!ans) {
        break;
      }

    }
    return nums;
  }

  static void swap(int nums[], int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;

  }

  static int[] insertion_sorting_algorithm(int nums[]) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j > 0; j--) {
        if (nums[j] < nums[j - 1]) {
          swap(nums, j, j - 1);
        } else {
          break;
        }
      }
    }
    return nums;
  }

  static int maxnum_value(int nums[], int start, int end) {
    int temp = 0;
    for (int i = start; i <= end; i++) {
      if (temp < nums[i]) {
        temp = nums[i];
      }
    }
    return temp;
  }

  static void selection_sort_algorithm(int nums[]) {

    for (int i = 0; i < nums.length; i++) {
      int start = 0;
      int end = nums.length - i - 1;
      int max = maxnum_value(nums, start, end);
      swap(nums, max, end);
    }

  }

  static void cycle_sort_algorithm(int nums[]) {
    int i = 0;
    while (i < nums.length) {
      int currect_element = nums[i] - 1;
      if (nums[i] != nums[currect_element]) {
        swap(nums, i, currect_element);
      } else {
        i++;
      }

    }

  }

  static int missing_the_number(int nums[]) {
    int i = 0;
    while (i < nums.length) {
      int current_el = nums[i];
      if (nums[i] < nums.length && nums[i] != nums[current_el]) {
        swap(nums, i, current_el);
      } else {
        i++;
      }
    }
    for (int j = 0; j < nums.length; j++) {
      if (j != nums[j]) {
        return j;
      }
    }
    return nums.length;
  }

  static List<Integer> missing_element_know(int nums[]) {

    List<Integer> l1 = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      int current = nums[i] - 1;
      if (nums[i] != nums[current]) {
        swap(nums, i, current);
      } else {
        i++;
      }
    }
    for (int j = 0; j < nums.length; j++) {
      if (j + 1 != nums[j]) {
        l1.add(j + 1);
      }
    }

    return l1;

  }

  static int dublicate_number(int nums[]) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] != i + 1) {
        int current = nums[i] - 1;
        if (nums[i] != nums[current]) {
          swap(nums, i, current);
        } else {
          return nums[i];
        }

      } else {
        i++;
      }
    }
    return -1;
  }

  // Question number leetcode = 645

  static int[] dublicate_next_number(int nums[]) {
    int i = 0;
    while (i < nums.length) {
      int currect_enl = nums[i] - 1;
      if (nums[i] != nums[currect_enl]) {
        swap(nums, i, currect_enl);
      } else {
        i++;
      }
    }
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != j + 1) {
        return new int[] { nums[j], j + 1 };
      }
    }
    return new int[] { -1, -1 };
  }

  // Question 41 hard level question prectic

  static int missing_low_number(int nums[]) {
    int i = 0;
    while (i < nums.length) {
      int curr = nums[i] - 1;
      if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[curr]) {
        swap(nums, i, curr);
      } else {
        i++;
      }
    }
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != j + 1) {
        return j + 1;
      }
    }
    return nums.length + 1;
  }



  
  public static void main(String[] args) {

    
    // int nums[] = { 7, 8, 9, 10, 11, 12 };
    // System.out.println(missing_low_number(nums));
    // System.out.println(maxnum_value(nums, 0, nums.length-1));
    // selection_sort_algorithm(nums);
    // System.out.println(Arrays.toString(nums));

    // int array[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
    // System.out.println(pivot_in_doublicat_array(array));
    // int matrix[][] = {
    // { 1, 2, 3, 4 },
    // { 5, 6, 7, 8 },

    // };
    // int target = 2;
    // System.out.println(Arrays.toString(Two_D_array_flat_binary_search(matrix,
    // target)));

    // int num = 17;
    // System.out.println( perfect_squear(num) );
    // int arr [][] =
    // // {
    // // {10,20,30,40},
    // // {15,25,35,45},
    // // {28,29,37,49},
    // // {33,34,38,50}
    // // };
    // int target = 51;
    // System.out.println(Arrays.toString(Two_D_array_binary_search(arr, target)));
    // int arr[] = {2,3,6,12,15,18};
    // System.out.println(rotation_found(arr));

    // int n = 10;
    // int pick = 6;
    // System.out.println(guess_the_number(n, pick));

    // int target = 56444;
    // System.out.println(binery_root_know(target));

    // int arrs []= {2,9,2,2,2};
    // System.out.println(pivot_in_doublicat_array(arrs));
    // int target = 9;
    // System.out.println(doublicat_array_rotate(arrs, target));
    // int arrs[]= {1,2,3,4,5,3,1};
    // int target = 3;
    // System.out.println(min_second(arrs, target));
    // long target =142543629;

    // System.out.println(squer_root(target));
    // 46340

    // int arrs[] = {1,2,3,5,6,4,3,2,1};

    // System.out.println(mountan_search_gain_large_value(arrs));
    // int arrs[] = {1,2,5,7,8,9,12,13,15,17,19,20,23,24,26,28,29};
    // int target = 17;
    // System.out.println(infinity_array_ans(arrs, target));

    // int arrs[] = {5,7,7,8,8,10};
    // int arrs[] = { 25, 19, 18, 15, 13, 9, 8, 5, 3, 0, -3, -5 };
    // int target = 7;
    // System.out.println(double_accending(arrs, target));

    // int row = 2;
    // int colume = 3;

    // int num [][] = {
    // {1,2,3},
    // {3,2,1}
    // };
    // System.out.println(maxsum(num, row, colume));

    // int nums[] = { 12, 345, 2, 6, 7896 };
    // System.out.println(findNumber(nums));
    // int nums[]= {0,0,0};
    // Three_sum(nums);
    // int price[]= {7,6,4,3,1};
    // System.out.println(profit(price));
    // int nums[] = {1,2,3,4};
    // subarray(nums);
    // int nums[] = {4,5,6,7,0,1,2};
    // int target =0;
    // System.out.println(search(nums, target));

    // int nums[] = {0,1,2,2,3,0,4,2};
    // int val = 2;
    // System.out.println(" "+Remove_val_number(nums, val));

    // int nums[] = {-1,0,1,2,-1,-4};
    // System.out.println(add_three_arr(nums));
    // System.out.println(waterlevel(nums)+" ");

    // int nums[] = {1,2,4,12};
    // int nums1[] = {2,4};
    // int k = 3;
    // System.out.println(goodspair(nums, nums1, k));

    // System.out.println(rectangular(nums));

    // int arr[] = { 1, 3, 5, 6 };
    // int target = 7;
    // System.out.println(insartsearch(arr, target));

    // System.out.println(generate(5));
    // }
    // public static int fact(int n) {
    // int result = 0;
    // for (int i = 1; i <= n; i++) {
    // if (i == 0 || i == 1) {
    // result = 1;

    // } else {
    // result *= i;
    // }
    // }
    // return result;
    // }

    // public static void main(String[] args) {
    // for (int i = 1; i <= 5; i++) {
    // int[] arr = new int[i];
    // for (int j = 1; j < i; j++) {
    // if (j == 1 || j == i) {
    // arr[j] = 1;
    // } else {
    // arr[j] = fact(i-1 ) / (fact(i - j) * fact(j-1));
    // }
    // }

    // }

    // public static void main(String[] args) {
    // int[] num1 = { 1, 2, 3, 0, 0, 0};
    // int m=3;
    // int[] num2 = { 2, 5, 6 };
    // int n = 3;
    // // int[] num3 = new int[m + n];
    // for(int j=0, i=num1.length-1; j<=num2.length-1;i--){
    // num1[i]=num2[j];
    // j++;
    // }
    // Arrays.sort(num1);
    // for(int i=0;i<=num1.length-1;i++){
    // System.out.print(num1[i]+" ");
    // }

    // }
    // }

    // public static int[] arr_To_digit(int digits[]){
    // int result=0;
    // int []digit1 = new int[digit.length];
    // int n =digits.length-1;

    // for(int i=0;i<=n;i++){
    // result = result*10+digit[i];
    // }
    // if(digit[n]<9){
    // digit1 = new int[digit.length];

    // } if(digit[0]<9&&digit[n]==9){
    // digit1 = new int[digit.length];

    // }

    // if(digit[n]==9&&digit[0]==9){
    // digit1 = new int[digit.length+1];

    // }
    // result+=1;
    // for(int i=digit1.length-1;i>=0;i--){

    // digit1[i]=result%10;
    // result /= 10;
    // System.out.print(digit1[i]+" ");

    // }
    // for (int i = digits.length - 1; i >= 0; i--) {
    // if (digits[i] < 9) {
    // digits[i]++;
    // return digits;
    // }
    // digits[i] = 0;
    // }

    // digits = new int[digits.length + 1];
    // digits[0] = 1;
    // return digits;
    // }

    // public static void main(String[] args) {
    // int []digits ={9};

    // System.out.print( arr_To_digit(digits));

    // }

    // Question 2 int leetcode remove the dublicate
    // public static int remove_arr(int nums[]) {

    // int j = 1;
    // for(int i = 1; i < nums.length; i++){
    // if(nums[i] != nums[i - 1]){
    // nums[j] = nums[i];
    // j++;
    // }
    // }
    // return j;
    // }
    // public static void main(String[] args) {
    // int[] nums= {0,0,1,1,1,2,2,3,3,4};
    // System.out.println(remove_arr(nums));

    // }

    // Question 1 in the leetcode sum of two number

    // public static int two_numbersum(int array[], int target) {
    // int i = 0;
    // int outval=0;
    // int j=i+1;
    // while (i < array.length && j < array.length) {
    // if (array[i] + array[j] == target) {
    // outval = i;
    // }
    // i++;
    // }
    // return outval;

    // }

    // public static void main(String[] args) {
    // int array[] = { 3, 3 };
    // int target = 6;
    // System.out.println(two_numbersum(array,target));

    // }
  }
}
