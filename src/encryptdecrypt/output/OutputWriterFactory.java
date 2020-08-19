package encryptdecrypt.output;

import java.io.FileNotFoundException;

public class OutputWriterFactory {
    public static OutputWriter createWriter() {
        return new ConsoleOutputWriter();
    }
    public static OutputWriter createWriter(String filename) throws FileNotFoundException {
        return new FileOutputWriter(filename);
    }
}
