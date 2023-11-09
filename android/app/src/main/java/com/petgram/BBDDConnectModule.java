package com.petgram;

import android.os.AsyncTask;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import java.sql.Connection;
import java.sql.DriverManager;
import android.util.Log;

public class BBDDConnectModule extends ReactContextBaseJavaModule {
    
    private String url = "jdbc:postgresql://%s:%d/%s";
    private final String host = "instanciaproyecto.cqj6xncvyxbs.eu-north-1.rds.amazonaws.com";
    private final String database = "postgres";
    private final int port = 5432;
    private final String user = "administrador";
    private final String pass = "12345678";

    // Constructor
    public BBDDConnectModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "BBDDConnect";
    }

    @ReactMethod
    public void conectarAsync(Promise promise) {
        new AsyncTask<Void, Void, Connection>() {
            @Override
            protected Connection doInBackground(Void... voids) {
                try {
                    url = String.format(url, host, port, database);
                    Class.forName("org.postgresql.Driver");
                    return DriverManager.getConnection(url, user, pass);
                } catch (Exception ex) {
                       // Log the exception for debugging purposes
                    Log.e("DB_ERROR", "Error al conectar con la base de datos", ex);
                    // Reject the promise with the exception message
                    promise.reject("DB_ERROR", "Error al conectar con la base de datos", ex);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Connection conexion) {
                if (conexion != null) {
                    // Si la conexión es exitosa, resuelve la promesa con un mensaje de éxito
                    promise.resolve("Conexión exitosa");
                } else {
                    // Si la conexión falla, rechaza la promesa con el error
                    promise.reject(new RuntimeException("Error al conectar con la base de datos"));
                }
            }
        }.execute();
    }
}
