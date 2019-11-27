package com.devahir.mastery.utils;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class JSONUtils {

    /**
     * Open a json file from raw and construct as class using Gson.
     *
     * @param resources
     * @param resId
     * @return
     */
    public static <T> String getJsonFileAsClass(final Resources resources, final int resId, final Class<T> type) {

        InputStream resourceReader = resources.openRawResource(resId);
        Writer writer = new StringWriter();

        try {

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(resourceReader, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                resourceReader.close();
            }

            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            //Crashlytics.logException(e);
            //Timber.d("Unhandled exception while using JSONResourceReader", e);
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                e.printStackTrace();
                //Timber.d("Unhandled exception while using JSONResourceReader", e);
            }
        }
        return null;
    }

    /**
     * Build an object from the specified JSON resource using Gson.
     *
     * @param type The type of the object to build.
     * @return An object of type T, with member fields populated using Gson.
     */
    public static <T> T constructUsingGson(final Class<T> type, final String jsonString) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, type);
    }
}