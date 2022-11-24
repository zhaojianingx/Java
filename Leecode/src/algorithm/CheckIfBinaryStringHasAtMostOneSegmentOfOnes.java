package algorithm;

/**
 * @author zjn
 **/
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfBinaryStringHasAtMostOneSegmentOfOnes().checkOnesSegment("10000"));
    }
}
