package com.example.gotocursor;

import java.util.Random;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		dropItem();

    }

    public void dropItem()
	{
		Handler myHandler = new Handler();
		
		//handler
		myHandler.postDelayed(new Runnable(){
		public void run()
		{
			int moveSpeed = 10;
			if (counter < 11) {
				moveSpeed = 10;
			}
			else if (counter <21) {
				moveSpeed = 12;
			}
			else if (counter <31) {
				moveSpeed = 16;
			}
			else if (counter <41) {
				moveSpeed = 22;
			}
			else if (counter <51) {
				moveSpeed = 30;
			}
			else if (counter <61) {
				moveSpeed = 36;
			}
			else if (counter <66) {
				moveSpeed = 42;
			}
			else if (counter >65) {
				moveSpeed = 42;
			}
			else {
				moveSpeed = 20;
			}
			ImageView myImageView2 = (ImageView)findViewById(R.id.imageView2);
			myImageView2.setY(myImageView2.getY()+moveSpeed);
			
			Display display = getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
			int width = size.x;
			//int height = size.y;
			
			if (myImageView2.getY() < 1100)
			{
				dropItem();
				//myImageView2.setY(0);
			} else {
				Random Random = new Random();
				

				myImageView2.setX(Random.nextInt(width));
				myImageView2.setY(0);
				dropItem();
			}
			
		}
		},1);
		//end of handler
		
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

@Override
	public boolean onTouchEvent (MotionEvent event){
		ImageView myImageView1 = (ImageView)findViewById(R.id.imageView1);
		ImageView myImageView2 = (ImageView)findViewById(R.id.imageView2);
		TextView scoreCounter = (TextView)findViewById(R.id.textView1);
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int theX = (int) event.getX(); //Gets coordinates for screen touch X
		int theY = (int) event.getY(); //Gets coordinates for screen touch X
		
		
		myImageView1.setX(theX - 32); //Moves picture X
		myImageView1.setY(theY - 128); //Moves picture Y
		
		
		if ((myImageView1.getX()+50 > myImageView2.getX()) && 
				(myImageView1.getY()+50 > myImageView2.getY()) &&
				(myImageView1.getX() < myImageView2.getX()+50) &&
				(myImageView1.getY() < myImageView2.getY()+50))
					{
						counter = counter + 1;
						scoreCounter.setText(String.valueOf(counter));
						Random Random = new Random();
						myImageView2.setX(Random.nextInt(width));
						myImageView2.setY(0);
					}

		return true;
	}
}
