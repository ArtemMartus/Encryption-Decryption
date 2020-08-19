package encryptdecrypt.output;

 class ConsoleOutputWriter implements OutputWriter{
     @Override
     public void write(String data) {
         System.out.println(data);
     }
 }
