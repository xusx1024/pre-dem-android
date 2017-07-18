package qiniu.predem.example;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Misty on 17/6/19.
 */

public class OkhttpThreeThread {
    private static final String TAG = "OkhttpThreeThread";

    private static OkHttpClient client;

    public OkhttpThreeThread() {
        client = new OkHttpClient();
    }

    public static void run(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG,"------"+response.code());
                String str = response.body().string();
            }
        });
    }
}
