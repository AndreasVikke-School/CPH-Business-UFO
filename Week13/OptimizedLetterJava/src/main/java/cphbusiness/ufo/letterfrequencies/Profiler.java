package cphbusiness.ufo.letterfrequencies;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Profiler {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Before Optimization:");
        double i = CheckMethodTimeOld();
        System.out.println("After Optimization:");
        double o = CheckMethodTimeNew();
        System.out.println(i + o);
    }

    public static double CheckMethodTimeOld() throws FileNotFoundException, IOException {
        int n = 10;
        int count = 1000;
        double dummy = 0.0;
        double st = 0.0, sst = 0.0;

        for (int j=0; j<n; j++) {
            Timer t = new Timer();
            for (int i=0; i<count; i++) {
                dummy += Old.Run();
            }
            double time = t.check() * 1e9 / count;
            st += time;
            sst += time * time;
        }
        double mean = st/n, sdev = Math.sqrt((sst - mean*mean*n)/(n-1));
        System.out.printf("%6.1f ns +/- %6.3f %n", mean, sdev);
        return dummy;
      }

      public static double CheckMethodTimeNew() throws FileNotFoundException, IOException {
        int n = 10;
        int count = 100;
        double dummy = 0.0;
        double st = 0.0, sst = 0.0;

        for (int j=0; j<n; j++) {
            Timer t = new Timer();
            for (int i=0; i<count; i++) {
                dummy += Main.Run();
            }
            double time = t.check() * 1e9 / count;
            st += time;
            sst += time * time;
        }
        double mean = st/n, sdev = Math.sqrt((sst - mean*mean*n)/(n-1));
        System.out.printf("%6.1f ns +/- %6.3f %n", mean, sdev);
        return dummy;
      }
}
