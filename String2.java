
/*doubleChar*/
/*Return true if the string "cat" and "dog" appear the same number of times in the given string*/


catDog("catdog") → true
catDog("catcat") → false
catDog("1cat1cadodog") → true


public boolean catDog(String str) {
    int len = str.length();
    int cat = 0;
    int dog = 0;
    for(int i=0; i<len-2; i++){
      if(str.substring(i,i+3).equals("cat")){
        cat++;
      }if(str.substring(i,i+3).equals("dog")){
        dog++;
      }
      
    }if (cat == dog){
        return true;
      }else return false;
}


/*countCode*/
/*Return the number of times that the string "code"appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count*/


public int countCode(String str) {
     int counter = 0;
     for(int i=0; i < str.length()-3; i++){
       if(str.substring(i,i+2).equals("co") && str.charAt(i+3)=='e'){
         counter++;
       }
     }
     return counter;
}


/*endOther*/
/*Given two strings, return true if either of the
 strings appears at the very end of the other string
 , ignoring upper/lower case differences 
 (in other words, the computation should not be 
 "case sensitive")*/


 public boolean endOther(String a, String b) {
  String lowerA= a.toLowerCase();
  String lowerB= b.toLowerCase();
  if(lowerA.endsWith(lowerB)|| lowerB.endsWith(lowerA)){
    return true;
  }else return false;
}


/*xyzThere*/
/*Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). 
So "xxyz" counts but "x.xyz" does not. */

public boolean xyzThere(String str) {
  for(int i=0; i< str.length()-2; i++){
    if(str.substring(i,i+3).equals("xyz")){
      if(i==0){
        return true;
      } else if(str.charAt(i-1) != '.'){
        return true;
      }
      
    }
  }
  return false;
}


/*bobThere*/
/*Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char*/


public boolean bobThere(String str) {
  for(int i=0; i<str.length()-2; i++){
    if(str.charAt(i)=='b'&& str.charAt(i+2)=='b')
      return true;
    }return false;
  } 


/*xyBalance*/
/*We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. 
    So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.*/
        
        
        
public boolean xyBalance(String str) {
  boolean y = false;
  
  for(int i=str.length()-1; i>=0; i--){
    if(str.charAt(i) =='y')
    y = true;
    
    if(str.charAt(i) == 'x' && !y)
    return false;
    
  } return true;
  
}


/*mixString*/
/*Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on.
    Any leftover chars go at the end of the result.*/


public String mixString(String a, String b) {
  String result = "";
  int i;

  for( i=0; i<a.length()&& i<b.length(); i++){
     result=result+a.charAt(i);
     result=result+b.charAt(i);
  }
  if(a.length()<b.length())
  {
    result=result+b.substring(i);
  } else result= result+a.substring(i);
  return result;
}


/*repeatEnd*/
/*Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
You may assume that n is between 0 and the length of the string, inclusive.
repeatEnd("Hello", 3) → "llollollo"
repeatEnd("Hello", 2) → "lolo"
repeatEnd("Hello", 1) → "o"*/


public String repeatEnd(String str, int n) {
  String end = str.substring(str.length()-n);
 String result = "";

 for( int i =0;i<n;i++){
    
    result = result+end;
 }
 return result;
}


/*repeatFront*/
/*Given a string and an int n, return a string made of the first n characters of the string, 
followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string,
inclusive (i.e. n >= 0 and n <= str.length()).
repeatFront("Chocolate", 4) → "ChocChoChC"
repeatFront("Chocolate", 3) → "ChoChC"
repeatFront("Ice Cream", 2) → "IcI" */


public String repeatFront(String str, int n) {
  String first = str.substring(0,n);
  String result = "";
  for( int i=0; i < n; i++){
    result = result + first.substring(0, n-i);
  }
  return result;
}


/*repeatSeparator*/
/*Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string.
repeatSeparator("Word", "X", 3) → "WordXWordXWord"
repeatSeparator("This", "And", 2) → "ThisAndThis"
repeatSeparator("This", "And", 1) → "This"*/


public String repeatSeparator(String word, String sep, int count) {
  String result = "";
  for(int i  = 0; i< count; i++){
    if(i < count-1)
      result += word + sep;
    else result += word;
  }
  
  return result;
}



/*prefixAgain*/
/*Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string?
Assume that the string is not empty and that N is in the range 1..str.length().
prefixAgain("abXYabc", 1) → true
prefixAgain("abXYabc", 2) → true
prefixAgain("abXYabc", 3) → false*/


public boolean prefixAgain(String str, int n) {
  String prefix = str.substring(0, n);
  
  for(int i = n; i<= str.length()- n; i++){
    if(str.substring(i, i+n).equals(prefix))
    return true;
  }
  return false;
}


/*getSandwich*/
/*A sandwich is two pieces of bread with something in between.
Return the string that is between the first and last appearance of "bread" in the given string,
or return the empty string "" if there are not two pieces of bread.
getSandwich("breadjambread") → "jam"
getSandwich("xxbreadjambreadyy") → "jam"
getSandwich("xxbreadyy") → "" */


public String getSandwich(String str) {
  int first = -1;
  int last = -1;
  
  for(int i =0; i< str.length()-5; i++){
    if(str.substring(i, i+5).equals("bread")){
      first = i;
      break;
    }
  }
  for(int i =str.length()-5; i>=0; i--){
    if(str.substring(i, i+5).equals("bread")){
      last = i;
      break; 
    }
  }
  if(first != -1 && first != -1 && first != last)
  return str.substring(first+5, last);
  
  return "";
}



/*sameStarChar*/
/*Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.
sameStarChar("xy*yzz") → true
sameStarChar("xy*zzz") → false
sameStarChar("*xa*az") → true*/



public boolean sameStarChar(String str) {
  for(int i = 1; i < str.length() - 1; i++) {
      if(str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1))
          return false;
  }
              
  return true;
}


/*oneTwo*/
/*Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca". 
Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
oneTwo("abc") → "bca"
oneTwo("tca") → "cat"
oneTwo("tcagdo") → "catdog" */


public String oneTwo(String str) {
  String result = "";
  for(int i =0; i < str.length()-2; i+=3){
    result = result + str.substring( i+1, i+3) + str.charAt(i);
    
  }
  return result;
  
}




/*zipZap*/
/*Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'.
Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
zipZap("zipXzap") → "zpXzp"
zipZap("zopzop") → "zpzp"
zipZap("zzzopzop") → "zzzpzp" */



public String zipZap(String str) {
  for(int i=0; i < str.length() -2; i++)
    if(str.charAt(i) == 'z' && str.charAt(i+2) =='p')
    str = str.substring(0, i+1) + str.substring(i+2);
    return str;
  
}


/*starOut*/
/*Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone.
So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
starOut("ab*cd") → "ad"
starOut("ab**cd") → "ad"
starOut("sm*eilly") → "silly"*/


public String starOut(String str) {
  int len = str.length();
  String result = "";
  for( int i = 0; i < len; i++){
    if(i == 0 && str.charAt(i) != '*')
    result += str.charAt(i);
    
    if( i > 0 && str.charAt(i) != '*' && str.charAt(i-1) != '*')
    result += str.charAt(i);
    
    if(i > 0 && str.charAt(i) == '*' && str.charAt(i-1) != '*')
    result = result.substring(0,result.length()-1);
  }
  return result;
}


/*plusOut*/
/*Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), 
except for appearances of the word string which are preserved unchanged.
plusOut("12xy34", "xy") → "++xy++"
plusOut("12xy34", "1") → "1+++++"
plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"*/


public String plusOut(String str, String word) {
  int slen = str.length();
  int wlen = word.length();
  String result = "";
  
  for( int i = 0; i < slen; i++){
    if(i <= slen - wlen){
      String temp = str.substring(i, i+wlen);
      if(temp.equals(word)){
        result += word;
        i += wlen-1;
      }
      else
       result +="+";
    }
      else
      result += "+";
    
  }
  return result;
  
}



/*wordEnds*/
/*Given a string and a non-empty word string, return a string made of each char just before and just after every 
appearance of the word in the string. Ignore cases where there is no char before or after the word, 
and a char may be included twice if it is between two words.
wordEnds("abcXY123XYijk", "XY") → "c13i"
wordEnds("XY123XY", "XY") → "13"
wordEnds("XY1XY", "XY") → "11" */


public String wordEnds(String str, String word) {
  String result = "";
  int wLen = word.length();
  int sLen = str.length();
  for(int i =0; i < sLen-wLen+1; i++){
    if(i > 0 && str.substring(i,i+wLen).equals(word))
    result +=str.charAt(i-1);
    if(i<sLen-wLen && str.substring(i,i+wLen).equals(word))
    result += str.charAt(i+wLen);
  }
  return result;
}




