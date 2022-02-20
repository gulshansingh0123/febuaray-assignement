import java.util.Arrays;
import java.util.Vector;

/*"1.) https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
2.) https://leetcode.com/problems/running-sum-of-1d-array/
3.)  Given two arrays, find the intersection between them?
        Input : int[]  arr1 = {1, 2, 3, 4, 5, 6};
                 int[] arr2 = {2, 3, 4, 7, 8};
        Output : { 2, 3, 4}


4.)  Write a program to find second largest element in a given Array in java?"
*/


public class febuary14 {
    public static void main(String[] args) {
//		C/W
        System.out.println(compareTwoStringArray(new String[] { "ab", "c" }, new String[] { "a", "bc" }));
        System.out.println(compareTwoStringArray_oneLiner(new String[] { "ab", "c" }, new String[] { "a", "bc" }));
        System.out.println(findFirstPlindrome(new String[] {"abc","car","ada","racecar","cool"}));
        System.out.println(findFirstPlindrome_concise(new String[] {"abc","car","ada","racecar","cool"}));
        System.out.println(printUnique(new int[] {1,2,3,99,3,2,1}));
        System.out.println(Arrays.toString(kidsWithCandies(new int[]{2,3,5,1,3},3)));

//		H/W
        System.out.println(busyStudent(new int[] {1,2,3},new int[] {3,2,7},4));
        System.out.println(Arrays.toString(runningSumArray(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(findIntersectionBetweenArray(new int[]{1, 2, 3, 4, 5, 6},new int[] {2, 3, 4, 7, 8})));
        System.out.println("Second largest : "+findSecondLargest(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int i=0;
        int count=0;
        while(i<startTime.length) {
            if(startTime[i]<=queryTime && endTime[i]>=queryTime) {
                count++;
            }
            i++;
        }
        return count;
    }

    //Use memoization technique, TC:(O(N-1))
    private static int[] runningSumArray(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            arr[i]+=arr[i-1];
        }
        return arr;
    }

    //	TC:O(N),SC:O(1)
    private static int findSecondLargest(int[] arr) {
        int largest=Integer.MIN_VALUE,second = Integer.MIN_VALUE;
        for(int val:arr)
        {
            largest = Math.max(largest, val);
        }
        for(int val:arr)
        {
            if (val != largest)
                second = Math.max(second, val);
        }
        return second;
    }

    private static int[] findIntersectionBetweenArray(int[] arr1, int[] arr2) {
        Vector<Integer> res=new Vector<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int low1=0,low2=0;
        while(low1<arr1.length && low2<arr2.length) {
            if(arr1[low1]>arr2[low2]) {
                low2++;
            }else if(arr1[low1]<arr2[low2]){
                low1++;
            }else {
                res.add(arr1[low1]);
                low1++;low2++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static String[] kidsWithCandies(int[] candies, int extraCandies) {
        String[] temp=new String[candies.length];
        int maxCandies = Integer.MIN_VALUE;
        for (int val : candies) {
            maxCandies = Math.max(maxCandies, val);
        }
        for(int i=0;i<candies.length;i++)
        {
            temp[i]=(candies[i]+extraCandies>=maxCandies)?"true":"false";
        }
        return temp;
    }

    private static int printUnique(int[] arr) {
        int result=arr[0];
        for(int i=1;i<arr.length;i++) {
            result=result^arr[i];
        }
        return result;
    }

    private static String findFirstPlindrome_concise(String[] words) {
        for (String s : words) {
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            if (s.compareTo(sb.toString()) == 0)
                return s;
        }
        return "";
    }

    private static String findFirstPlindrome(String[] str) {
        for (String word : str) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String word){
        int start=0;
        int end = word.length()-1;
        while(start<end){
            if(word.charAt(start++)!=word.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    private static boolean compareTwoStringArray(String[] s1, String[] s2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (String str : s1) {
            sb1.append(str);
        }
        for (String str2 : s2) {
            sb2.append(str2);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static boolean compareTwoStringArray_oneLiner(String[] s1, String[] s2) {
        return String.join("", s1).equals(String.join("", s2));
    }
}