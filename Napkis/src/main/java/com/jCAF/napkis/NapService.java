package com.jCAF.napkis;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class NapService extends Service
{
    private static final String TAG = "NapService";

    static int i=0;


    public NapService()
    {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        if(i==0)
        {
            wiflySock wifly = new wiflySock();
            wifly.start();
            i=1;
        }
        return startId;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    private class wiflySock extends Thread
    {
        ServerSocket serverSocket;
        Socket socket = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        byte[] messageByte = new byte[1000];
        String dataString = "";
        int bytesRead;
        int first, second, third;

        public void run()
        {
                try
                {
                    serverSocket = new ServerSocket(2000);
                    socket = serverSocket.accept();
                    Log.i(TAG, "Connected");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    dataInputStream = new DataInputStream(socket.getInputStream());

                    while(true)
                    {
                        bytesRead = dataInputStream.read(messageByte);
                        dataString += new String(messageByte, 0, bytesRead);
                        if(dataString.contains(";"))
                        {
                            Log.i(TAG, dataString);

                            first = dataString.indexOf(":", 0) + 1;
                            second = dataString.indexOf(":", first+1)+1;
                            third = dataString.indexOf(":", second+1)+1;

                            Log.i(TAG, "first: " + Integer.toString(first));
                            Log.i(TAG, "second: " + Integer.toString(second));
                            Log.i(TAG, "third: " + Integer.toString(third));

                            Log.i(TAG, "first: " + dataString.substring(first, second - 1));
                            Log.i(TAG, "second: " + dataString.substring(second, third-1));
                            Log.i(TAG, "third: " + dataString.substring(third, dataString.length() - 1));

                            NapApp app = new NapApp();
                            NapApp.sendHttp send = app.new sendHttp();

                            send.execute(dataString);

                            dataString = "";
                            bytesRead = 0;
                        }
                    }


                }
                catch (UnknownHostException e)
                {
                    // TODO Auto-generated catch block
                    Log.i(TAG, "Catch 1");
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    Log.i(TAG, "Catch 2");
                    e.printStackTrace();
                }
                finally
                {
                    if (socket != null)
                    {
                        try
                        {
                            socket.close();
                        }
                        catch (IOException e)
                        {
                            // TODO Auto-generated catch block
                            Log.i(TAG, "Catch 3");
                            e.printStackTrace();
                        }
                    }

                    if (dataOutputStream != null)
                    {
                        try
                        {
                            dataOutputStream.close();
                        }
                        catch (IOException e)
                        {
                            // TODO Auto-generated catch block
                            Log.i(TAG, "Catch 4");
                            e.printStackTrace();
                        }
                    }

                    if (dataInputStream != null)
                    {
                        try
                        {
                            dataInputStream.close();
                        } catch (IOException e)
                        {
                            Log.i(TAG, "Catch 5");
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
}
