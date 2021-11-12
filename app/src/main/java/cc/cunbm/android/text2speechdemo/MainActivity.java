package cc.cunbm.android.text2speechdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            ed1=(EditText)findViewById(R.id.editText);

            ed1.setText("Hyperledger Fabric is popular for its ability to handle highly complicated business transactions, " +
                    "regardless of the industry. It is a framework for permissioned memberships, making it useful for use cases " +
                    "where data protection regulation compliance is a must.");
/*
                    "Hyperledger also supports data on a need-to-know basis, as well as rich queries that go over an immutable " +
                    "distributed ledger. This makes Hyperledger useful for business applications with privacy concerns " +
                    "while minimizing the work needed for simple reports and audit functions.\n" +
                    "Web3j, on the other hand, is a lightweight Java library used mostly for large volume documentation. " +
                    "It is both lightweight, reactive, highly modular, and type-safe Java and Android library, " +
                    "with its most well-known use case being its integration capabilities with Ethereum clients.\n" +
                    "What makes Web3j useful is its ability to provide Java developers with an integration layer " +
                    "for Java in the blockchain. Its versatile CLI and plugins allow developers to work with blockchains " +
                    "without additional overhead with integration codes."
*/
            b1=(Button)findViewById(R.id.button);

            t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status != TextToSpeech.ERROR) {
                        // t1.setLanguage(Locale.UK);
                        t1.setLanguage(Locale.UK);
                    }
                }
            });



            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String toSpeak = ed1.getText().toString();
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        public void onPause(){
            if(t1 !=null){
                t1.stop();
                t1.shutdown();
            }
            super.onPause();
        }

}