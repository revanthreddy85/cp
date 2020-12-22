package FastIO;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Random;


public class InputReader {
    private InputStream stream;
    private byte[] buf=new byte[1<<16];
    private int curChar,snumChars;
    private InputReader.SpaceCharFilter filter;
    private int mod=(int)1e9+7;

    public InputReader(InputStream stream) {
        this.stream=stream;
    }

    public int snext() {
        if(snumChars==-1)
            throw new InputMismatchException();
        if(curChar>=snumChars) {
            curChar=0;
            try {
                snumChars=stream.read(buf);
            }
            catch(IOException e) {
                throw new InputMismatchException();
            }
            if(snumChars<=0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c=snext();
        while(isSpaceChar(c))
            c=snext();
        int sgn=1;
        if(c=='-') {
            sgn=-1;
            c=snext();
        }
        int res=0;
        do {
            if(c<'0'||c>'9')
                throw new InputMismatchException();
            res*=10;
            res+=c-'0';
            c=snext();
        }while(!isSpaceChar(c));
        return res*sgn;
    }

    public long nextLong() {
        int c=snext();
        while(isSpaceChar(c))
            c=snext();
        int sgn=1;
        if(c=='-') {
            sgn=-1;
            c=snext();
        }
        long res=0;
        do {
            if (c<'0' || c>'9')
                throw new InputMismatchException();
            res*=10;
            res+=c-'0';
            c=snext();
        }while (!isSpaceChar(c));
        return res * sgn;
    }

    public double nextDouble() {
        int c=snext();
        while(isSpaceChar(c))
            c=snext();
        int sgn=1;
        if(c=='-') {
            sgn=-1;
            c=snext();
        }
        double res=0,div=1;
        do {
            if (c<'0' || c>'9')
                throw new InputMismatchException();
            res*=10;
            res+=c-'0';
            c=snext();
        }while (!isSpaceChar(c) && c!='.');
        if(c=='.') {
            c=snext();
            do {
                if (c<'0' || c>'9')
                    throw new InputMismatchException();

                res+=(c-'0')/(div*=10);
                c=snext();
            }while (!isSpaceChar(c));
        }
        return res * sgn;
    }

    public long mul(long x,long y){
        long ans=x*y;
        if(ans>=mod)
            ans%=mod;
        return ans;
    }

    public long add(long x,long y){
        long ans=x+y;
        if(ans>=mod)
            ans-=mod;
        return ans;
    }

    public  long sub(long x,long y){
        long ans=x-y;
        if(ans<0)
            ans+=mod;
        return ans;
    }

    public int[] nextIntArray(int n) {
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=nextInt();
        return a;
    }

    public void shuffle(int input[]) {
        Random rand = new Random();
        for(int i = 0; i < input.length; i++)
        {
            int index = rand.nextInt(input.length);
            int temp = input[index];
            input[index] = input[i];
            input[i] = temp;
        }
    }

    public long[] nextLongArray(int n) {
        long a[]=new long[n];
        for(int i=0;i<n;i++)
            a[i]=nextLong();
        return a;
    }

    public void shuffle(long input[]) {
        Random rand = new Random();
        for(int i = 0; i < input.length; i++)
        {
            int index = rand.nextInt(input.length);
            long temp = input[index];
            input[index] = input[i];
            input[i] = temp;
        }
    }

    public double[] nextDoubleArray(int n) {
        double a[]=new double[n];
        for(int i=0;i<n;i++)
            a[i]=nextDouble();
        return a;
    }

    public String nextString() {
        int c=snext();
        while(isSpaceChar(c))
            c=snext();
        StringBuilder res=new StringBuilder();
        do
        {
            res.appendCodePoint(c);
            c=snext();
        }while(!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter!=null)
            return filter.isSpaceChar(c);
        return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
    }

    public interface SpaceCharFilter {
         boolean isSpaceChar(int ch);
    }
}
