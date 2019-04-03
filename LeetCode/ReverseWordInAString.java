class Solution {
	/*
   * @param s: A string
   * @return: A string
   */
  public String reverseWords(String s) {
      // write your code here
      if (s == null || s.length() == 0) {
          return "";
      }
      
      //split by the " " to generate the String array
      String[] array = s.split(" ");
      StringBuilder sb = new StringBuilder();
      for (int i = array.length - 1; i >= 0; i--) {
          if (!array[i].equals("")) {
              sb.append(array[i]).append(" "); 
              //append是可以叠加使用
              
          }
      }
      return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
  }
}

