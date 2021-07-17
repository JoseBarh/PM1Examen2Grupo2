package com.example.pm1examen2grupo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Lista_Contacto extends AppCompatActivity {

    ListView listview1;
    List<Contactos> contList;
    ArrayList<String> arrayCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contacto);

        setContentView(R.layout.activity_main);
        listview1 = findViewById(R.id.listLista);
        contList = new ArrayList<>();
        arrayCont = new ArrayList<String>();

        SendRequest();
    }


    private void SendRequest()
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.100.9:8080/dbcontactos/mostrarContactos.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        // Log.i("Respuesta", "onResponse: " + response.substring(0,500) );


                        try
                        {
                            JSONObject obj = new JSONObject(response);
                            JSONArray ContArray = obj.getJSONArray("contactos");

                            for (int i = 0; i < ContArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject contacObject = ContArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                Contactos cont = new Contactos(contacObject.getInt("id"),
                                        contacObject.getDouble("img"),
                                        contacObject.getString("nombre"),
                                        contacObject.getString("telefono"),
                                        contacObject.getString("latitud"),
                                        contacObject.getString("longitud"));

                                //adding the hero to herolist
                                contList.add(cont);
                                arrayCont.add(cont.getNombre() + ' ' + cont.getTelefono());
                            }

                            ArrayAdapter adp = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayCont );
                            listview1.setAdapter(adp);


                        }
                        catch (JSONException ex)
                        {

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error en Response", "onResponse: " +  error.getMessage().toString() );
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}