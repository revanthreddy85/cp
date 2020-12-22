package FastIO;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;

public class OutputWriter
{
    private final PrintWriter writer;
    public  StringBuilder sb = new StringBuilder();

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }
    public void flush() {
        writer.flush();
    }
    public void println() {
        writer.println();
    }

    public void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close()
    {
        writer.close();
    }

}
