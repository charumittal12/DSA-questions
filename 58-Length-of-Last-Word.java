class Solution {
    public int lengthOfLastWord(String s) {
        String s1 = s.trim();
        String[] ch = s1.split(\ \);
        String last = ch[ch.length-1];
        return last.length();
    }
}