public class ignore {

//Binary to decimal
    public int BitoDec(int a){
        int lastdigit = 0;
        int pow =0;
        int dec=0;
        while(a>0){
            lastdigit = a%10;
            dec = dec + lastdigit*(int)(Math.pow(2,pow));
            a = a/10;
            pow++;

        }
        return dec;
    }

    public int DectoBin(int a){
        int pow =0;
        int bin=0;
        int rem=0;

        while(a>0){
            rem=a%2;
            bin = bin + rem*(int)Math.pow(10,pow);
            a=a/2;
            pow++;

        }
        return bin;







    }
public static void main(String[] args) {
        ignore i = new ignore();
        //System.out.println(i.BitoDec(1001));
        System.out.println(i.DectoBin(5));



}



}
