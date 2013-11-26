import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class chapter2 extends PApplet {

int rows = 7, cols = 4788;
float taillevisuels;

String[][] valeur = new String[cols][rows];
String[][] datas1983 = new String[144][rows];
String[] liste;

ArrayList<Visuelhexa> visuels = new ArrayList<Visuelhexa>();

int linesdatas = 0, count = 0;

public void setup(){
    size(1280, 720);
    background(23, 33, 48);
    parseDatas();
    for (int i = 0; i<datas1983.length; i++){
        // println(datas1983[i][2]); --> print de la colonne des nombres de fois expos\u00e9s
        taillevisuels = map(PApplet.parseFloat(datas1983[i][2]), 0, 43, 4, 43);
        visuels.add(new Visuelhexa (random(0+43,width-43), random(0+43, height-43), taillevisuels));
    }
}


public void draw(){
    background(23, 33, 48);
    for (Visuelhexa mesvisuels : visuels){
        mesvisuels.dessin();
    }
}


public void parseDatas(){
    liste = loadStrings("datas.csv");

    for (int i=0; i<liste.length; i++) {
      valeur[i] = split(liste[i], ";");
    }

    for (int i = 1; i<valeur.length; i++){
        if (valeur[i][1].equals("1983")){
            for (int j = 1; j<valeur[i].length; j++){
                datas1983[linesdatas][j] = valeur[i][j];
            }
            linesdatas++;
        }
    }
}
class Visuelhexa {
	
	float n=6;
    float angle = 0;
    float distribution = TWO_PI/n;
	float px, py, ray;

	Visuelhexa (float posx, float posy, float rayon) {
		px = posx;
		py = posy;
		ray = rayon;
	}

	public void dessin(){
        smooth(); 
        shapeMode(CENTER);
        fill(255);
        stroke(255,80);
        strokeWeight((ray*0.7f));
        beginShape();
        for(int i =0; i<8; i++){ 
          vertex(px + cos(angle)*ray, py+ sin(angle)*ray);
          angle+=distribution;
        }
        endShape(CLOSE);
        detection();
	}

    public void detection(){
        // if (){
            
        // }
    }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "chapter2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
