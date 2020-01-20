import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.String;
import java.io.*;

public class Logs {
        private static Writer writer = null;

        public static void setOutputFile(String filename) throws IOException
        {
            if (Logs.writer != null)
                Logs.writer.close();
            Logs.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
        }

        public static void log(String message)
        {
            try
            {
                Logs.writer.write(message + '\n');
                writer.flush();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Error while trying to write to the file");
                System.exit(1);
            }
        }
    }
