package andersonsantos.androidsoma;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends AppCompatActivity {

    private static final int WAIT_TIME = 24 * 60 * 60 * 1000;
    private int loginAttempts = 3;
    private boolean loginBool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public static String md5(String senha){
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    public void Acao(View v) throws IOException, JSONException {


        if(loginAttempts == 0) {

            Toast.makeText(Login.this, "Your attempt reach 0, please wait 1 day to log again", Toast.LENGTH_SHORT).show();
            return;
        }

        String ServerURL = "http://172.20.10.2:8080/WebSoma/servletLogin";

        EditText textA = (EditText) findViewById(R.id.a);
        EditText textB = (EditText) findViewById(R.id.b);
        TextView rotuloC = (TextView) findViewById(R.id.c);

        String a = textA.getText().toString();
        String b = md5(textB.getText().toString());
        String c = "";

        new MakeNetworkCall().execute(ServerURL+"?a="+a+"&"+"b="+b, "Get");



    }



    InputStream ByGetMethod(String ServerURL) {

        InputStream DataInputStream = null;
        try {

            URL url = new URL(ServerURL);
            HttpURLConnection cc = (HttpURLConnection)
                    url.openConnection();

            cc.setReadTimeout(5000);
            cc.setConnectTimeout(5000);
            cc.setRequestMethod("GET");
            cc.setDoInput(true);

            int response = cc.getResponseCode();

            if (response == HttpURLConnection.HTTP_OK) {
                DataInputStream = cc.getInputStream();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataInputStream;

    }

    InputStream ByPostMethod(String ServerURL) {

        InputStream DataInputStream = null;
        try {
            String PostParam = "";

            URL url = new URL(ServerURL);

            HttpURLConnection cc = (HttpURLConnection)
                    url.openConnection();
            cc.setReadTimeout(5000);
            cc.setConnectTimeout(5000);
            cc.setRequestMethod("POST");
            cc.setDoInput(true);
            cc.connect();

            DataOutputStream dos = new DataOutputStream(cc.getOutputStream());
            dos.writeBytes(PostParam);
            dos.flush();
            dos.close();

            int response = cc.getResponseCode();

            if(response == HttpURLConnection.HTTP_OK) {
                DataInputStream = cc.getInputStream();
            }

        } catch (Exception e) {
           e.printStackTrace();
        }
        return DataInputStream;

    }

    String ConvertStreamToString(InputStream stream) {

        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder response = new StringBuilder();

        String line = null;
        try {

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                stream.close();

            } catch (IOException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response.toString();


    }

    public void DisplayMessage(String a) {

        TextView TxtResult = (TextView) findViewById(R.id.Avisos);
        TxtResult.setText(a);
    }

    private class MakeNetworkCall extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(Login.this, "Logando...",
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... arg) {

            InputStream is = null;
            String URL = arg[0];
            String res = "";


            if (arg[1].equals("Post")) {

                is = ByPostMethod(URL);

            } else {

                is = ByGetMethod(URL);
            }
            if (is != null) {
                res = ConvertStreamToString(is);
            } else {
                res = "Erro!";
            }
            return res;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            processLogin(result);

        }
    }

    protected void processLogin(String result){
        if(result.equals("true")){
            loginBool = true;
            startActivity(new Intent(Login.this, AtividadePrincipal.class));
        }else{
            loginAttempts--;

            Toast.makeText(Login.this, "Email and Password is incorrect",
                    Toast.LENGTH_SHORT).show();

            if (loginAttempts == 2) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        loginAttempts = 3;
                    }
                }, WAIT_TIME);
            }
        }
    }

}
