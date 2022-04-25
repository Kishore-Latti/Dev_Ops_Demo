package module.one;

import java.util.ArrayList;
import java.util.Collections;

public class Comparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String str_Sample = "a";
//        System.out.println("Compare To 'a' b is : " + str_Sample.compareTo("b"));
//        str_Sample = "b";
//        System.out.println("Compare To 'b' a is : " + str_Sample.compareTo("a"));
//        str_Sample = "b";
//        System.out.println("Compare To 'b' b is : " + str_Sample.compareTo("b"));
//        
//        int x = 20; 
//        int y = 30; 
//  
//        // as 10 less than 20, 
//        // Output will be a value less than zero 
//        System.out.println(Integer.compare(x, y)); 
//  
//        int p = 40; 
//        int q = 40; 
//  
//        // as 30 equals 30, 
//        // Output will be zero 
//        System.out.println(Integer.compare(p, q)); 
//  
//        int r = 20; 
//        int s = 7; 
//  
//        // as 15 is greater than 8, 
//        // Output will be a value greater than zero 
//        System.out.println(Integer.compare(r, s)); 
		
		
		ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 85, 2015));
        list.add(new Movie("Star Wars", 87, 1977));
        list.add(new Movie("Empire Strikes Back", 88, 1980));
        list.add(new Movie("Return of the Jedi", 84, 1983));
 
        Collections.sort(list);
 
        System.out.println("Movies after sorting : ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                               movie.getRating() + " " +
                               movie.getYear());
        }
	}

}

//A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie>
{
 private double rating;
 private String name;
 private int year;

 // Used to sort movies by year
 public int compareTo(Movie m)
 {
     return (int) (this.rating - m.rating);
 }

 // Constructor
 public Movie(String nm, double rt, int yr)
 {
     this.name = nm;
     this.rating = rt;
     this.year = yr;
 }

 // Getter methods for accessing private data
 public double getRating() { return rating; }
 public String getName()   {  return name; }
 public int getYear()      {  return year;  }
}
