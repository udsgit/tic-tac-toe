package aplicacion.android.ud.tresenraya;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Tablero extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bloquearBotones();
    }

    static final int INTENTAR_GANAR = 2, INTENTAR_DEFENSA = 10, INTELIGENTE = 3;
    static int[][] logica = new int[3][3];
    static final int MUYFACIL = 0, FACIL = 1, NORMAL = 2, DIFICIL = 3, MUYDIFICIL = 4, IMPOSIBLE = 5;
    static final int NADIE = 0, CIRCULO = 1, ASPA = 2, EMPATE = 3, O = 1, X = 5, VACIO = 0;
    static final int[][] casillas = {{R.id.t00, R.id.t01, R.id.t02},
            {R.id.t10, R.id.t11, R.id.t12},
            {R.id.t20, R.id.t21, R.id.t22}};
    static final int[] botonesDificultad = {R.id.muyFacil, R.id.facil, R.id.normal, R.id.dificil, R.id.muyDificil, R.id.imposible};
    static int jugadores, dificultad, ganador, turno = 0, r1, r2;
    static boolean continuar = true;
    static ImageView imagen;
    static Button btnUnJugador, btnDosJugadores;
    static TextView txtTitulo, txtDificultad;
    static LinearLayout layoutDificultad, layoutBotonesPartida;

    public void verBotonesEnPartida() {
        txtTitulo = findViewById(R.id.nombreApp);
        txtDificultad = findViewById(R.id.dificultad);
        layoutDificultad = findViewById(R.id.layoutDificultad);
        layoutBotonesPartida = findViewById(R.id.layoutBotonesEnPartida);
        btnUnJugador = findViewById(R.id.unJug);
        btnDosJugadores = findViewById(R.id.dosJug);
        btnUnJugador.setVisibility(View.GONE);
        btnDosJugadores.setVisibility(View.GONE);
        txtTitulo.setVisibility(View.GONE);
        txtDificultad.setVisibility(View.GONE);
        layoutDificultad.setVisibility(View.GONE);
        layoutBotonesPartida.setVisibility(View.VISIBLE);
    }

    public void verBotonesDificultad() {
        txtTitulo = findViewById(R.id.nombreApp);
        btnUnJugador = findViewById(R.id.unJug);
        btnDosJugadores = findViewById(R.id.dosJug);
        txtDificultad = findViewById(R.id.dificultad);
        layoutDificultad = findViewById(R.id.layoutDificultad);
        txtTitulo.setVisibility(View.GONE);
        btnUnJugador.setVisibility(View.GONE);
        btnDosJugadores.setVisibility(View.GONE);
        txtDificultad.setVisibility(View.VISIBLE);
        layoutDificultad.setVisibility(View.VISIBLE);
    }

    public void unJugador(View view) {
        jugadores = 1;
        verBotonesDificultad();
    }

    public void dosJugadores(View view) {
        jugadores = 2;
        verBotonesEnPartida();
        limpiarCasillas();
    }

    public void volverAlMenu(View view) {
        txtTitulo = findViewById(R.id.nombreApp);
        btnUnJugador = findViewById(R.id.unJug);
        btnDosJugadores = findViewById(R.id.dosJug);
        txtDificultad = findViewById(R.id.dificultad);
        layoutDificultad = findViewById(R.id.layoutDificultad);
        layoutBotonesPartida = findViewById(R.id.layoutBotonesEnPartida);

        txtDificultad.setVisibility(View.GONE);
        layoutDificultad.setVisibility(View.GONE);
        layoutBotonesPartida.setVisibility(View.GONE);
        txtTitulo.setVisibility(view.VISIBLE);
        btnUnJugador.setVisibility(view.VISIBLE);
        btnDosJugadores.setVisibility(View.VISIBLE);
        limpiarCasillas();
        bloquearBotones();
    }

    public void reiniciarPartida(View view) {
        limpiarCasillas();
    }

    public void pintarCelda(View view) {
        if (jugadores == 1) {
            turno++;
            if (turno % 2 != 0) {
                switch (view.getId()) {
                    case R.id.t00:
                        marcarJugada(0, 0, X);
                        break;
                    case R.id.t01:
                        marcarJugada(0, 1, X);
                        break;
                    case R.id.t02:
                        marcarJugada(0, 2, X);
                        break;
                    case R.id.t10:
                        marcarJugada(1, 0, X);
                        break;
                    case R.id.t11:
                        marcarJugada(1, 1, X);
                        break;
                    case R.id.t12:
                        marcarJugada(1, 2, X);
                        break;
                    case R.id.t20:
                        marcarJugada(2, 0, X);
                        break;
                    case R.id.t21:
                        marcarJugada(2, 1, X);
                        break;
                    case R.id.t22:
                        marcarJugada(2, 2, X);
                        break;
                }
                if (continuar) {
                    turnoMaquina(view);
                }
            }
        }
        if (jugadores == 2) {
            turno++;
            switch (view.getId()) {
                case R.id.t00:
                    if (turno % 2 == 0) {
                        marcarJugada(0, 0, O);
                    } else {
                        marcarJugada(0, 0, X);
                    }
                    break;
                case R.id.t01:
                    if (turno % 2 == 0) {
                        marcarJugada(0, 1, O);
                    } else {
                        marcarJugada(0, 1, X);
                    }
                    break;
                case R.id.t02:
                    if (turno % 2 == 0) {
                        marcarJugada(0, 2, O);
                    } else {
                        marcarJugada(0, 2, X);
                    }
                    break;
                case R.id.t10:
                    if (turno % 2 == 0) {
                        marcarJugada(1, 0, O);
                    } else {
                        marcarJugada(1, 0, X);
                    }
                    break;
                case R.id.t11:
                    if (turno % 2 == 0) {
                        marcarJugada(1, 1, O);
                    } else {
                        marcarJugada(1, 1, X);
                    }
                    break;
                case R.id.t12:
                    if (turno % 2 == 0) {
                        marcarJugada(1, 2, O);
                    } else {
                        marcarJugada(1, 2, X);
                    }
                    break;
                case R.id.t20:
                    if (turno % 2 == 0) {
                        marcarJugada(2, 0, O);
                    } else {
                        marcarJugada(2, 0, X);
                    }
                    break;
                case R.id.t21:
                    if (turno % 2 == 0) {
                        marcarJugada(2, 1, O);
                    } else {
                        marcarJugada(2, 1, X);
                    }
                    break;
                case R.id.t22:
                    if (turno % 2 == 0) {
                        marcarJugada(2, 2, O);
                    } else {
                        marcarJugada(2, 2, X);
                    }
                    break;
            }
        }
    }


       boolean marcarJugada(int i, int j, int jugador) {
        if (logica[i][j] == VACIO) {
            imagen = (ImageView) findViewById(casillas[i][j]);
            if (jugador == X) {
                imagen.setImageResource(R.drawable.aspa);
            } else {
                imagen.setImageResource(R.drawable.circulo);
            }
            imagen.setClickable(false);
            logica[i][j] = jugador;
            comprobarResultado();
            return true;
        } else {
            return false;
        }
    }


















    public void comprobarDificultad(View view) {
        if (view.getId() == botonesDificultad[MUYFACIL]) {
            dificultad = MUYFACIL;
        } else if (view.getId() == botonesDificultad[FACIL]) {
            dificultad = FACIL;
        } else if (view.getId() == botonesDificultad[NORMAL]) {
            dificultad = NORMAL;
        } else if (view.getId() == botonesDificultad[DIFICIL]) {
            dificultad = DIFICIL;
        } else if (view.getId() == botonesDificultad[MUYDIFICIL]) {
            dificultad = MUYDIFICIL;
        } else if (view.getId() == botonesDificultad[IMPOSIBLE]) {
            dificultad = IMPOSIBLE;
        }
        limpiarCasillas();
        verBotonesEnPartida();
    }

    public void limpiarCasillas() {
        turno = 0;
        ganador = NADIE;
        continuar = true;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                imagen = (ImageView) findViewById(casillas[i][j]);
                imagen.setImageResource(R.drawable.casilla);
                imagen.setClickable(true);
                logica[i][j] = 0;
            }
        }
    }

     void bloquearBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                imagen = (ImageView) findViewById(casillas[i][j]);
                imagen.setClickable(false);
            }
        }
    }

    static void trazarLineaVictoria() {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Path trazo = new Path();
        trazo.lineTo(40, 40);
        Paint pincel = new Paint();
        pincel.setColor(Color.RED);
        pincel.setStrokeWidth(20);
        canvas.drawPath(trazo, pincel);
    }


      void comprobarResultado() {
        if (turno > 4) {
            if (logica[0][0] == O && logica[0][1] == O && logica[0][2] == O) {
                continuar = false;
                ganador = CIRCULO;
            } else if (logica[0][0] == X && logica[0][1] == X && logica[0][2] == X) {
                continuar = false;
                ganador = ASPA;
            } else if (logica[1][0] == O && logica[1][1] == O && logica[1][2] == O) {
                continuar = false;
                ganador = CIRCULO;
            } else if (logica[1][0] == X && logica[1][1] == X && logica[1][2] == X) {
                continuar = false;
                ganador = ASPA;
            } else if (logica[2][0] == O && logica[2][1] == O && logica[2][2] == O) {
                continuar = false;
                ganador = CIRCULO;
            } else if (logica[2][0] == X && logica[2][1] == X && logica[2][2] == X) {
                continuar = false;
                ganador = ASPA;
            } else if (logica[0][0] == O && logica[1][0] == O && logica[2][0] == O) {
                continuar = false;
                ganador = CIRCULO;
            } else if (logica[0][0] == X && logica[1][0] == X && logica[2][0] == X) {
                continuar = false;
                ganador = ASPA;
            } else if (logica[0][1] == O && logica[1][1] == O && logica[2][1] == O) {
                continuar = false;
                ganador = CIRCULO;
            } else if (logica[0][1] == X && logica[1][1] == X && logica[2][1] == X) {
                continuar = false;
                ganador = ASPA;
            } else if (logica[0][2] == O && logica[1][2] == O && logica[2][2] == O) {
                continuar = false;
                ganador = CIRCULO;
            } else if (logica[0][2] == X && logica[1][2] == X && logica[2][2] == X) {
                continuar = false;
                ganador = ASPA;
            } else if (logica[0][0] == O && logica[1][1] == O && logica[2][2] == O) {
                continuar = false;
                ganador = CIRCULO;
            } else if (logica[0][0] == X && logica[1][1] == X && logica[2][2] == X) {
                continuar = false;
                ganador = ASPA;
            } else if (logica[0][2] == O && logica[1][1] == O && logica[2][0] == O) {
                continuar = false;
                ganador = CIRCULO;
            } else if (logica[0][2] == X && logica[1][1] == X && logica[2][0] == X) {
                continuar = false;
                ganador = ASPA;
            }
            if (continuar == false) {
                if (ganador == CIRCULO) {
                    mensajeFlotante(this,R.string.circuloGana);
                } else {
                    mensajeFlotante(this,R.string.cruzGana);
                }

                bloquearBotones();
            } else if (turno > 8) {
                continuar = false;
                ganador = EMPATE;
                mensajeFlotante(this,R.string.empate);
            }
            trazarLineaVictoria();
        }
    }

     void turnoMaquina(View view) {
        Tablero.turno++;
        switch (Tablero.dificultad) {
            case Tablero.MUYFACIL:
                IA.dificultadMuyFacil(this);
                break;
            case Tablero.FACIL:
                IA.dificultadFacil(this);
                break;
            case Tablero.NORMAL:
                IA.dificultadNormal(this);
                break;
            case Tablero.DIFICIL:
                IA.dificultadDificil(this);
                break;
            case Tablero.MUYDIFICIL:
                IA.dificultadMuyDificil(this);
                break;
            case Tablero.IMPOSIBLE:
                IA.dificultadImposible(this);
                break;
        }
    }

     static void mensajeFlotante(Context contexto, int mensaje){
        Toast.makeText(contexto, mensaje, Toast.LENGTH_SHORT).show();
    }

}



