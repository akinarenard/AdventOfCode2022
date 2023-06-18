package day6_java;
import java.lang.Math;
import java.util.LinkedList;

public class Marker {
    private String marker;
    private int first;
    private String puzzle;

    public Marker(){
        this.puzzle = "";
        for(int i = 0; i <= 100; i++){
            int r = (int) Math.round(Math.random() * 6) + 1;
            this.puzzle += String.valueOf((char)(r + 96));
        }
    }
    
    private int firstMarker(){
        boolean distinct = false;
        char[] characters = this.puzzle.toCharArray();
        int j = 0;
        char[]  c = new char[4];
        while (!distinct && j < characters.length-4){
            LinkedList<Character> queue = new LinkedList<Character>();
            this.puzzle.getChars(j, j + 4, c, 0);
            for (char d : c) {
                queue.add(d);
            }
            distinct = true;
            for (int i = 0; i < c.length; i++) {
                queue.remove();
                if (queue.contains( c[i])){
                    distinct = false;
                    break;
                }                
            }
            j++;
        }
        if (!distinct){
            System.out.println("no marker found");
            return 0;
        }
        this.marker = new String(c);
        return j - 1 + 4;    
    }

    public void printResult(){
        this.first = firstMarker();
        if (this.first != 0 ){
            System.out.println("datastream input : " + this.puzzle);
            System.out.println("first start-of-packet marker found : " + this.marker);
            System.out.println(this.first + " characters needed to be processed before the detection of the first start-of-packet marker");
        }
    }

}
