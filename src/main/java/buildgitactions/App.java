package buildgitactions;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.github.lalyos.jfiglet.FigletFont;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Reader in = new FileReader("src/main/java/buildgitactions/arquivo.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);

        // Collections.sort(records, new EstimativaComparator());

        int i = 0;
        
        for (CSVRecord record : records) {
            if(i == 0)
            {
                i++;
                continue;
            }    

            String entidade = record.get(0);
            String codigo = record.get(1);
            int ano = Integer.parseInt(record.get(2));
            float estimativaHomens = Float.parseFloat(record.get(3));
            float estimativaMulheres = Float.parseFloat(record.get(4));
            
            if(ano == 2020)
            System.out.println(entidade + " - " + codigo + " em " + ano + "|" + "HOMENS: " + estimativaHomens + "| MULHERES: " + estimativaMulheres);

        }

        String asciiArt1 = FigletFont.convertOneLine("asdasd");
        System.out.println(asciiArt1);
    }
}
