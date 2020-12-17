package pl.chojnacki.grzegorz.testing.order;

import java.io.*;

public class OrderBackup {

    private Writer writer;

    public Writer getWriter() {
        return writer;
    }

    void createFile() throws FileNotFoundException {
        File file = new File("orderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);

    }

    void backupOrder(Order order) throws IOException {

        if(writer == null)
        {
            throw new IOException("File not created");
        }else {
            writer.append(order.toString());
        }

    }

    void closeFile() throws IOException {
        writer.close();
    }


}