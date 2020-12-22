import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author revanth
 */
public class Test {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }

    static class Solution {

        public void solve(int testNumber, InputReader sc, OutputWriter out) {
			
        }
    }
	
	static class InputReader {
		
		private InputStream stream;
		private byte[] buf=new byte[1<<16];
		private int curChar,snumChars;
		private InputReader.SpaceCharFilter filter;
		private int mod=(int)1e9+7;

		InputReader(InputStream stream) {
			this.stream=stream;
		}

		int snext() {
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

		int nextInt() {
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

		long nextLong() {
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

		double nextDouble() {
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

		int[] nextIntArray(int n) {
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=nextInt();
			return a;
		}

		void shuffle(int input[]) {
			Random rand = new Random();
			for(int i = 0; i < input.length; i++)
			{
				int index = rand.nextInt(input.length);
				int temp = input[index];
				input[index] = input[i];
				input[i] = temp;
			}
		}

		long[] nextLongArray(int n) {
			long a[]=new long[n];
			for(int i=0;i<n;i++)
				a[i]=nextLong();
			return a;
		}

		void shuffle(long input[]) {
			Random rand = new Random();
			for(int i = 0; i < input.length; i++)
			{
				int index = rand.nextInt(input.length);
				long temp = input[index];
				input[index] = input[i];
				input[i] = temp;
			}
		}

		double[] nextDoubleArray(int n) {
			double a[]=new double[n];
			for(int i=0;i<n;i++)
				a[i]=nextDouble();
			return a;
		}

		String nextString() {
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

		boolean isSpaceChar(int c) {
			if (filter!=null)
				return filter.isSpaceChar(c);
			return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
		}

		interface SpaceCharFilter {
			 boolean isSpaceChar(int ch);
		}
	}
	
	static class OutputWriter
	{
		private final PrintWriter writer;
		StringBuilder sb = new StringBuilder();

		OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
		}
		void flush() {
			writer.flush();
		}
		void println() {
			writer.println();
		}

		void println(Object... objects) {
			print(objects);
			writer.println();
		}

		void close()
		{
			writer.close();
		}

	}


}

