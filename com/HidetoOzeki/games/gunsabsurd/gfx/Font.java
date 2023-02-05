package com.HidetoOzeki.games.gunsabsurd.gfx;
import java.awt.Graphics;
public class Font {
	String symbols = "!?,.%&\"()[]{}<>:;+-*/=";
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String numbers = "0123456789";
	String hiragana = "�����������������������������������ĂƂȂɂʂ˂̂͂Ђӂւق܂݂ނ߂�������������񂟂�������������[";
	String hiragana_sp = "�������������������������Âłǂ΂тԂׂڂς҂Ղ؂�";

	Graphics context;

	public Font(Graphics c){
		context = c;
	}
	public static void render(String text,int x,int y,Screen screen){
		
	}
}