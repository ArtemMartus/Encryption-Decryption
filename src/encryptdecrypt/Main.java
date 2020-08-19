package encryptdecrypt;

import encryptdecrypt.coder.Encoder;
import encryptdecrypt.coder.EncoderFactory;
import encryptdecrypt.output.OutputWriter;
import encryptdecrypt.output.OutputWriterFactory;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String, String> arg = new TreeMap<>();
        for (int i = 0; i + 1 < args.length; ++i)
            arg.put(args[i], args[i + 1]);

        String data = arg.getOrDefault("-data", "");
        String alg = arg.getOrDefault("-alg", "shift");


        try {
            boolean encrypt = true;
            if (arg.containsKey("-mode") && !arg.get("-mode").equals("enc"))
                if (!arg.get("-mode").equals("dec"))
                    throw new IllegalArgumentException("Wrong mode passed");
                else
                    encrypt = false;

            int key = arg.containsKey("-key") ? Integer.parseInt(arg.get("-key")) : 0;

            OutputWriter writer;
            if (arg.containsKey("-out"))
                writer = OutputWriterFactory.createWriter(arg.get("-out"));
            else
                writer = OutputWriterFactory.createWriter();


            if (data.isEmpty() && arg.containsKey("-in"))
                data = new String(Files.readAllBytes(Paths.get(arg.get("-in"))));


            Encoder encoder = EncoderFactory.createEncoder(alg, key);
            if (encoder == null) throw new IllegalArgumentException("Wrong algorithm chosen");

            writer.write(encrypt ? encoder.encode(data) : encoder.decode(data));
//            if (arg.containsKey("-out")) {
//                System.out.println();
//            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
