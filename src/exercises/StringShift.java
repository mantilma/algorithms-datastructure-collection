package exercises;

/*You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

    direction can be 0 (for left shift) or 1 (for right shift). 
    amount is the amount by which string s is to be shifted.
    A left shift by 1 means remove the first character of s and append it to the end.
    Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.

Return the final string after all operations.

 

Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation: 
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"

Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:  
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
*/
public class StringShift {
	public String stringShift(String s, int[][] shift) {
        
		int count = 0;
        for (int[] rowArray: shift) {
            count += rowArray[0] == 0 ? -rowArray[1] : rowArray[1];
        }
        
        int length = s.length();

        if (count < 0) {
            count *= -1;
            while (count >= length) {
                count -= length;
            }
                s = s.substring(count) + s.substring(0, count);
        }
        else {
            while (count >= length) {
                count -= length;
            }
                s = s.substring(length -count) + s.substring(0, length - count);
        }      
        return s;
        
    }
}
