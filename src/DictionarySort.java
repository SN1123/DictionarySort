import java.io.*;
import java.util.*;
public class DictionarySort {
  /**
   * stores an ordered lists of words for searching
   */
  private static ArrayList<String> words;
  /**
   * main program
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    words = getWords();
    sortList(words);
    int interval = 100;
    String[] find = new String[100];
    int index = interval;
    for (int i = 0; i < interval - 1; i++) {
      index += words.size() / interval;
      find[i] = words.get(index);
    }
    find[interval - 1] = "Xdfsdda";
    SearchResult seqResult;
    SearchResult binaryult;
    System.out.println("#\tBinary\tSequential\tindex\tword");
    for (int i = 0; i < find.length; i++) {
      seqResult = sequentialSearch(find[i]);
      binaryult = binarySearch(find[i]);
      System.out.println(i + "\t" + binaryult.getIterations() + "\t" + seqResult.getIterations() + "\t" + binaryult.getIndex() + ":" + seqResult.getIndex() + "\t" + find[i] );
    }
  }
  /**
   * Implement a sequential search to find wordToFind in the ArrayList words
   *
   * @param wordToFind - String to find in words
   * @return a SearchResult (index of item found or -1 if not found, number of iterations in search loop)
   */
  
  public static SearchResult sequentialSearch(String wordToFind) {
    int count = 0;
    for(int i=0; i<words.size(); i++, count++){
      if(words.get(i).equals(wordToFind)){
        return new SearchResult(i, count);
      }
    }
    return new SearchResult(-1, count);
  }
  /**
   * Implement a binary search to find wordToFind in the ArrayList words
   *
   * @param wordToFind - String to find in words
   * @return a SearchResult (index of item found or -1 if not found, number of iterations in search loop)
   */
  public static SearchResult binarySearch(String wordToFind)
  {
    int max = words.size()-1;
    int min = 0;
    int numberOfRuns = 0;
    int index = -1;
    while(min <= max)
    {
      numberOfRuns++;
      int middle = (max + min)/2;
      
      if(words.get(middle).compareTo(wordToFind)==0)
      {
        SearchResult binary = new SearchResult(middle, numberOfRuns);
        return binary;
      }
      else if(words.get(middle).compareTo(wordToFind)>0)
      {
        max = mid - 1;
      }
      else if(words.get(middle).compareTo(wordToFind)<0)
      {
        min = mid + 1;
      }
    }
    SearchResult binary = new SearchResult(index, numberOfRuns);
    return binary;
  }
  
  /**
   * implement a method to sort the ArrayList words
   *
   * @param list - ArrayList of words to sort
   *
   */
  public static void sortList(ArrayList<String> list) {
    
  }
  /**
   * create an ArrayList<String> and populate it from text file
   *
   * @return an ArrayList<String>
   * @throws FileNotFoundException
   */
  public static ArrayList<String> getWords() throws FileNotFoundException {
    ArrayList<String> result = new ArrayList<String>();
    Scanner input = new Scanner(new File("words.txt"));
    while(input.hasNextLine()) {
      result.add(input.nextLine());
    }
    input.close();
    return result;
  }
}
