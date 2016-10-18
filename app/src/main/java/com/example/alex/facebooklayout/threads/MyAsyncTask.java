package com.example.alex.myapplication.threads;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyAsyncTask {

    private static final int MAX_THREADS = 4;
    private final ExecutorService executorService;
    private final Handler handler;

    public MyAsyncTask() {
        this.executorService = Executors.newFixedThreadPool(MAX_THREADS);
        this.handler = new Handler(Looper.getMainLooper());
    }

    public<Params, Progress, Result> void execute(final ITask<Params, Progress, Result> task, final Params params, final IProgressCallback<Progress> progressCallback, final IResultCallback<Result> resultCallback) {
        executorService.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    final Result result = task.doInBackground(params, new IProgressCallback<Progress>() {
                        @Override
                        public void onProgressUpdate(final Progress progress) {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressCallback.onProgressUpdate(progress);
                                }
                            });
                        }
                    });
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            resultCallback.onSuccess(result);
                        }
                    });
                } catch (final Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            resultCallback.onError(e);
                        }
                    });
                }

            }
        });
    }

}
