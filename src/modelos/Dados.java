package modelos;

import java.io.FileWriter;
import java.io.IOException;

public class Dados {
    private ConversaoMoeda conversao;

    public Dados() {
        this.conversao = conversao;
    }

    public void salvarDados() throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter("consultas.txt");
            writer.write(conversao.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }
}
