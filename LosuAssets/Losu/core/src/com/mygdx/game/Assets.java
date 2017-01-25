package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


/**
 * Created by Rabithole on 1/22/2017.
 */

public class Assets {

    public static Texture losubackground;
    public static Texture react;
    public static TextureRegion backgroundRegion;
    public static Drawable but1;
    float w;
    float h;


    public static Texture loadTexture (String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load() {

        losubackground = loadTexture("heimertitle.jpg");
        react = loadTexture(("ryzeicon.jpg"));
        but1 = new TextureRegionDrawable(new TextureRegion(react));
        backgroundRegion = new TextureRegion(losubackground, 0, 0, 0, 0);

    }
}
