package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import sun.rmi.runtime.Log;

public class Losu extends ScreenAdapter {

	LosuGame game;
	Rectangle reactionBounds;
	Rectangle aboutBounds;
	Rectangle rangeBounds;
	Rectangle psychBounds;
	OrthographicCamera guiCam;
	Vector3 touchPoint;
	Stage stage;
	private BitmapFont font;
	private TextureAtlas buttonsAtlas; //** image of buttons **//
	private Skin buttonSkin; //** images are used as skins of the button **//
	private TextButton button;
	private TextButton button2;
	private TextButton button3;
	private TextButton button4;
	float w;
	float h;


	public Losu(LosuGame game){
		this.game = game;


	}

	@Override
	public void show() {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/IndieFlower.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		buttonsAtlas = new TextureAtlas("button.pack"); //**button atlas image **//
		buttonSkin = new Skin();
		buttonSkin.addRegions(buttonsAtlas); //** skins for on and off **//
		fontParameter.size = 54;
		font = fontGenerator.generateFont(fontParameter);
		//font = new BitmapFont(Gdx.files.internal("new.fnt"),false); //** font **//
		stage = new Stage();        //** window is stage **//
		Image bg = new Image(Assets.losubackground);
		stage.clear();
		bg.setBounds(0,0,w,h);
		stage.addActor(bg);
		Gdx.input.setInputProcessor(stage); //** stage is responsive **//

		TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(); //** Button properties **//
		style.up = buttonSkin.getDrawable("buttonOff");
		style.down = buttonSkin.getDrawable("buttonOn");

		style.font = font;

		button = new TextButton("Reactions", style);
		button2 = new TextButton("Psych",style);
		button3 = new TextButton("Range",style);
		button4 = new TextButton("About",style);
		//** Button text and style **//
		button.setHeight(Gdx.graphics.getHeight()/3); //** Button Height **//
		button.setWidth(Gdx.graphics.getWidth()/3); //** Button Width **//
		button2.setHeight(h/3);
		button2.setWidth(w/3);
		button3.setHeight(h/3);
		button3.setWidth(w/3);
		button4.setHeight(h/3);
		button4.setWidth(w/3);

		button.setPosition(Gdx.graphics.getWidth()/3+button.getWidth()/2, Gdx.graphics.getHeight()/6+ Gdx.graphics.getHeight()/18);
		button2.setPosition(Gdx.graphics.getWidth()/4+button.getWidth(), Gdx.graphics.getHeight()/36+ Gdx.graphics.getHeight()/108);
		button3.setPosition(Gdx.graphics.getWidth()/3-button.getWidth()/2, Gdx.graphics.getHeight()/6+ Gdx.graphics.getHeight()/18);
		button4.setPosition(Gdx.graphics.getWidth()/4-button.getWidth()/2, Gdx.graphics.getHeight()/36+ h/108);

		button.addAction(Actions.)


		button.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc. **//
				return true;

			}

			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log("my app", "Rggggggeleased");

				game.fuck = true;
				game.someMethod();
				///and level
				//game.setScreen(new PickChamp(game));

				dispose();

			}
		});



		stage.addActor(button);
		stage.addActor(button2);
		stage.addActor(button3);
		stage.addActor(button4);



	}

	public void update() {

		if(Gdx.input.justTouched()) {

			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));


			if (reactionBounds.contains(touchPoint.x, touchPoint.y)) {
				System.out.println("FK");
			}
		}
	}


	public void draw() {
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//guiCam.update();
		stage.act();
		game.batcher.begin();
		stage.draw();
		game.batcher.end();

	}
	@Override
	public void render(float delta) {
		//update();
		draw();

	}

	@Override
	public void pause () {
		Settings.save();
	}

}

