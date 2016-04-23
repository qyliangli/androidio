package ll.androidio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path="/storage/sdcard0/ll/seven.csv";
        String cperiod="12054";
        File file=new File(path);
        try {
            InputStream inputStream=new FileInputStream(file);
            if(inputStream!=null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                char[] linechar = new char[12];
                char[] periodchar=new char[5];
                char[] numberchar=new char[7];
                String numberstr=null;
                String linestr=null;
                String periodstr=null;
                for (;(line=bufferedReader.readLine())!=null;) {
                    for (int i = 0,n=0; i < line.length(); i++) {
                        if (line.charAt(i) != '\"' && line.charAt(i) != ',') {
                            linechar[n] = line.charAt(i);
                            n++;
                        }
                    }
                    for (int i = 0; i <5; i++)
                            periodchar[i] = linechar[i];

                    linestr= String.valueOf(linechar);
                    periodstr= String.valueOf(periodchar);
                    if(periodstr.equals(cperiod)){
                        for (int i = 5,n=0; i <12;)
                            numberchar[n++] = linechar[i++];
                        numberstr=String.valueOf(numberchar);
                        break;
                    }

                }
                System.out.println(numberstr);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
