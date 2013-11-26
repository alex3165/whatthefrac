int rows = 7, cols = 4788;
float taillevisuels;

String[][] valeur = new String[cols][rows];
String[][] datas1983 = new String[144][rows];
String[] liste;

ArrayList<Visuelhexa> visuels = new ArrayList<Visuelhexa>();

int linesdatas = 0, count = 0;

void setup(){
    size(1280, 720);
    background(23, 33, 48);
    parseDatas();
    for (int i = 0; i<datas1983.length; i++){
        // println(datas1983[i][2]); --> print de la colonne des nombres de fois exposés
        taillevisuels = map(float(datas1983[i][2]), 0, 43, 4, 43);
        visuels.add(new Visuelhexa (random(0+43,width-43), random(0+43, height-43), taillevisuels));
    }
}


void draw(){
    background(23, 33, 48);
    for (Visuelhexa mesvisuels : visuels){
        // mesvisuels.dessin();
    }
}


void parseDatas(){
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