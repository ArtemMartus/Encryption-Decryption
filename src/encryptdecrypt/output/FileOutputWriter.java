package encryptdecrypt.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class FileOutputWriter implements OutputWriter {

    final File file;
    final PrintWriter writer;

    FileOutputWriter(String filename) throws FileNotFoundException {
        file = new File(filename);
        writer = new PrintWriter(file);
    }

    @Override
    public void write(String data) {
        writer.print(data);
        writer.flush();
    }
}
