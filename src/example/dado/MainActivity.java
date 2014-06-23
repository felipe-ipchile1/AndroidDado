package example.dado;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView tv2;
	private TextView tv4;
	private int numero;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv2 = (TextView)findViewById(R.id.tv2);
        tv4 = (TextView)findViewById(R.id.tv4);
        
        SharedPreferences prefe=getSharedPreferences("datos",Context.MODE_PRIVATE);
        String v=String.valueOf(prefe.getInt("puntos",0));
        tv2.setText(v);
            		
	}
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void lanzar(View view) {
    	
    	numero = 1+ (int) (Math.random()*6);  
    	
    	tv2.setText(String.valueOf(numero));
    	
    	if (numero == 6) {
    		int puntosactual=Integer.parseInt(tv4.getText().toString());
    		puntosactual++;
    		tv4.setText(String.valueOf(puntosactual));
    		Toast.makeText(getBaseContext(), "Bien has ganado un punto", Toast.LENGTH_SHORT).show();
    	    SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
    		Editor editor=preferencias.edit();
    		editor.putInt("puntos", puntosactual);
    		editor.commit();    		
    		
    	} else {
    	
    		Toast.makeText(getBaseContext(), "Lastima, vuelva a lanzar el Dado", Toast.LENGTH_SHORT).show(); 
    		
}}}
    