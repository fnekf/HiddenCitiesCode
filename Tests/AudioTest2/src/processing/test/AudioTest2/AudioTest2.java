package processing.test.AudioTest2;

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import android.os.Environment;

import apwidgets.*;
import ketai.*;

public class AudioTest2 extends PApplet
{

	APWidgetContainer	mWidgetContainer;
	APToggleButton		mToggle1, mToggle2;

	String[]			mPaths;
	AudioPlayManager[]	mPlayManagers;

	public void setup()
	{
		orientation(PORTRAIT);
		imageMode(CENTER);

		mPaths = new String[2];
		mPaths[0] = Environment.getExternalStorageDirectory().getAbsolutePath()
				+ "/hiddenCities/audio/Track A - option 1.wav";
		mPaths[1] = Environment.getExternalStorageDirectory().getAbsolutePath()
				+ "/hiddenCities/audio/Track B - option 1.wav";

		mPlayManagers = new AudioPlayManager[mPaths.length];
		for (int i = 0; i < mPlayManagers.length; i++) {
			println("making manager number " + i);
			mPlayManagers[i] = new AudioPlayManager(mPaths[i], 64); // buffersize = 64kb
			mPlayManagers[i].setIsLooping(true);

		}

		mWidgetContainer = new APWidgetContainer(this);
		mToggle1 = new APToggleButton(width / 2 - 60, height / 2 - 20, 120, 40,
				"Switch Track A");
		mToggle1 = new APToggleButton(width / 2 - 60, height / 2 + 20, 120, 40,
				"Switch Track B");
		mWidgetContainer.addWidget(mToggle1);
		// mWidgetContainer.addWidget(mToggle2);

	}

	public void draw()
	{
		// println(frameRate);
		background(255);
		mPlayManagers[0].setVolume(map((float) mouseX, 0.0f, (float) width,
				0.0f, 1.0f));
		mPlayManagers[1].setVolume(map((float) mouseY, 0.0f, (float) height,
				0.0f, 1.0f));
		noStroke();
		fill(0, 0, 0);
		ellipse (mouseX, mouseY, 30 ,30);
		// println(mPlayManagers[0].getVolume());
		// println(mPlayManagers[1].getVolume());

	}

	public void onClickWidget(APWidget widget)
	{
		if (widget == mToggle1) {
			if (mToggle1.isChecked()) {
				println("Chnaging A");
				mPaths[0] = Environment.getExternalStorageDirectory()
						.getAbsolutePath()
						+ "/hiddenCities/audio/Track A - option 2.wav";
				mPlayManagers[0].setPath(mPaths[0]);
				println("path set");

			} else {
				mPaths[0] = Environment.getExternalStorageDirectory()
						.getAbsolutePath()
						+ "/hiddenCities/audio/Track A - option 1.wav";
				mPlayManagers[0].setPath(mPaths[0]);
			}
		} else if (widget == mToggle2) {
			if (mToggle2.isChecked()) {
				mPaths[1] = Environment.getExternalStorageDirectory()
						.getAbsolutePath()
						+ "/hiddenCities/audio/Track B - option 2.wav";
				mPlayManagers[1].setPath(mPaths[1]);

			} else {
				mPaths[1] = Environment.getExternalStorageDirectory()
						.getAbsolutePath()
						+ "/hiddenCities/audio/Track B - option 1.wav";
				mPlayManagers[1].setPath(mPaths[1]);

			}
		}
	}

	public void mousePressed()
	{

	}

	public void keyPressed()
	{

	}

	public int sketchWidth()
	{
		return displayWidth;
	}

	public int sketchHeight()
	{
		return displayHeight;
	}
}
