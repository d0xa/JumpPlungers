package com.cs4340.jump_plungers.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cs4340.jump_plungers.JumpPlungers;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new JumpPlungers(), config);
		config.width =800;
		config.height =416;
		new LwjglApplication(new JumpPlungers(), config);
	}
}
