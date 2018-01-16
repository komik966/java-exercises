package edu.agh.ics.lab2;
import org.apache.log4j.Logger;

public class Primes {
    public static Logger log = Logger.getLogger(Primes.class);
    public static void main(String[] args) {
        int size = 1024;
        int[] tmp = new int[size];
        for (int j=0;j<size;j++) {
            tmp[j]=0;
        }
        for(int i = 0;i<size;i++){
            if (i == 0){
                continue;
            }
            if (i == 1){
                continue;
            }
            else{
                if(tmp[i]==0){
                    log.info(i);
                    tmp[i]=1;
                    int pom = i;
                    while(pom<size){
                        tmp[pom] = 1;
                        pom = pom+i;
                    }
                }

            }
        }
    }
}
