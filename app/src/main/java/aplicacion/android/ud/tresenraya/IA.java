package aplicacion.android.ud.tresenraya;

import android.widget.ImageView;

import java.util.Random;

public class IA {

    static boolean IA(int POSIBLE_LINEA, Tablero tablero) {
        boolean completado = true;
        if (POSIBLE_LINEA == Tablero.INTENTAR_GANAR) {
            POSIBLE_LINEA = Tablero.INTENTAR_GANAR;
        } else if (POSIBLE_LINEA == Tablero.INTENTAR_DEFENSA) {
            POSIBLE_LINEA = Tablero.INTENTAR_DEFENSA;
        } else {
            return false;
        }
        if (Tablero.logica[0][0] + Tablero.logica[0][1] + Tablero.logica[0][2] == POSIBLE_LINEA) {
            if (Tablero.logica[0][0] == Tablero.VACIO) {
                tablero.marcarJugada(0, 0, Tablero.O);
            } else if (Tablero.logica[0][1] == Tablero.VACIO) {
                tablero.marcarJugada(0, 1, Tablero.O);
            } else if (Tablero.logica[0][2] == Tablero.VACIO) {
                tablero.marcarJugada(0, 2, Tablero.O);
            }
        } else if (Tablero.logica[1][0] + Tablero.logica[1][1] + Tablero.logica[1][2] == POSIBLE_LINEA) {
            if (Tablero.logica[1][0] == Tablero.VACIO) {
                tablero.marcarJugada(1, 0, Tablero.O);
            } else if (Tablero.logica[1][1] == Tablero.VACIO) {
                tablero.marcarJugada(1, 1, Tablero.O);
            } else if (Tablero.logica[1][2] == Tablero.VACIO) {
                tablero.marcarJugada(1, 2, Tablero.O);
            }
        } else if (Tablero.logica[2][0] + Tablero.logica[2][1] + Tablero.logica[2][2] == POSIBLE_LINEA) {
            if (Tablero.logica[2][0] == Tablero.VACIO) {
                tablero.marcarJugada(2, 0, Tablero.O);
            } else if (Tablero.logica[2][1] == Tablero.VACIO) {
                tablero.marcarJugada(2, 1, Tablero.O);
            } else if (Tablero.logica[2][2] == Tablero.VACIO) {
                tablero.marcarJugada(2, 2, Tablero.O);
            }
        } else if (Tablero.logica[0][0] + Tablero.logica[1][0] + Tablero.logica[2][0] == POSIBLE_LINEA) {
            if (Tablero.logica[0][0] == Tablero.VACIO) {
                tablero.marcarJugada(0, 0, Tablero.O);
            } else if (Tablero.logica[1][0] == Tablero.VACIO) {
                tablero.marcarJugada(1, 0, Tablero.O);
            } else if (Tablero.logica[2][0] == Tablero.VACIO) {
                tablero.marcarJugada(2, 0, Tablero.O);
            }
        } else if (Tablero.logica[0][1] + Tablero.logica[1][1] + Tablero.logica[2][1] == POSIBLE_LINEA) {
            if (Tablero.logica[0][1] == Tablero.VACIO) {
                tablero.marcarJugada(0, 1, Tablero.O);
            } else if (Tablero.logica[1][1] == Tablero.VACIO) {
                tablero.marcarJugada(1, 1, Tablero.O);
            } else if (Tablero.logica[2][1] == Tablero.VACIO) {
                tablero.marcarJugada(2, 1, Tablero.O);
            }
        } else if (Tablero.logica[0][2] + Tablero.logica[1][2] + Tablero.logica[2][2] == POSIBLE_LINEA) {
            if (Tablero.logica[0][2] == Tablero.VACIO) {
                tablero.marcarJugada(0, 2, Tablero.O);
            } else if (Tablero.logica[1][2] == Tablero.VACIO) {
                tablero.marcarJugada(1, 2, Tablero.O);
            } else if (Tablero.logica[2][2] == Tablero.VACIO) {
                tablero.marcarJugada(2, 2, Tablero.O);
            }
        } else if (Tablero.logica[0][0] + Tablero.logica[1][1] + Tablero.logica[2][2] == POSIBLE_LINEA) {
            if (Tablero.logica[0][0] == Tablero.VACIO) {
                tablero.marcarJugada(0, 0, Tablero.O);
            } else if (Tablero.logica[1][1] == Tablero.VACIO) {
                tablero.marcarJugada(1, 1, Tablero.O);
            } else if (Tablero.logica[2][2] == Tablero.VACIO) {
                tablero.marcarJugada(2, 2, Tablero.O);
            }
        } else if (Tablero.logica[2][0] + Tablero.logica[1][1] + Tablero.logica[0][2] == POSIBLE_LINEA) {
            if (Tablero.logica[2][0] == Tablero.VACIO) {
                tablero.marcarJugada(2, 0, Tablero.O);
            } else if (Tablero.logica[1][1] == Tablero.VACIO) {
                tablero.marcarJugada(1, 1, Tablero.O);
            } else if (Tablero.logica[0][2] == Tablero.VACIO) {
                tablero.marcarJugada(0, 2, Tablero.O);
            }
        } else {
            completado = false;
        }
        return completado;
    }

    static boolean probabilidad(int porcentaje) {
        if (new Random().nextInt(100) < porcentaje) {
            return true;
        } else {
            return false;
        }
    }

    static void dificultadMuyFacil(Tablero tablero) {
        if (!IA(Tablero.INTENTAR_GANAR,tablero)) {
            jugadaRandom(tablero);
        }
    }

    static void dificultadFacil(Tablero tablero) {

        if (!IA(Tablero.INTENTAR_GANAR, tablero)) {
            ataqueIA(Tablero.NORMAL,tablero);
        }
    }

    static void dificultadNormal(Tablero tablero) {
        if (!IA(Tablero.INTENTAR_GANAR,tablero)) {
            if (probabilidad(50)) {
                if (!IA(Tablero.INTENTAR_DEFENSA,tablero)) {
                    ataqueIA(Tablero.NORMAL,tablero);
                }
            } else {
                ataqueIA(Tablero.NORMAL,tablero);
            }
        }
    }

    static void dificultadDificil(Tablero tablero) {
        if (!IA(Tablero.INTENTAR_GANAR,tablero)) {
            if (probabilidad(70)) {
                if (!IA(Tablero.INTENTAR_DEFENSA,tablero)) {
                    ataqueIA(Tablero.NORMAL,tablero);
                }
            } else {
                ataqueIA(Tablero.NORMAL,tablero);
            }
        }
    }

    static void dificultadMuyDificil(Tablero tablero) {
        if (!IA(Tablero.INTENTAR_GANAR,tablero)) {
            if (probabilidad(90)) {
                if (!IA(Tablero.INTENTAR_DEFENSA,tablero)) {
                    ataqueIA(Tablero.INTELIGENTE,tablero);
                }
            } else {
                ataqueIA(Tablero.INTELIGENTE,tablero);
            }
        }
    }

     static void dificultadImposible(Tablero tablero) {
        if (!IA(Tablero.INTENTAR_GANAR,tablero)) {
            if (!IA(Tablero.INTENTAR_DEFENSA,tablero)) {
                ataqueIA(Tablero.INTELIGENTE,tablero);
            }
        }
    }



    static void jugadaRandom(Tablero tablero) {
        do {
            Random casillaRandom = new Random();
            Tablero.r1 = casillaRandom.nextInt(3);
            Tablero.r2 = casillaRandom.nextInt(3);
            Tablero.imagen = (ImageView) tablero.findViewById(Tablero.casillas[Tablero.r1][Tablero.r2]);
        } while (Tablero.logica[Tablero.r1][Tablero.r2] != Tablero.VACIO);
        tablero.marcarJugada(Tablero.r1, Tablero.r2, Tablero.O);
    }


     static void ataqueIA(int ataque, Tablero tablero) {
        switch (ataque) {
            case Tablero.INTELIGENTE:
                if (Tablero.turno == 4) {
                    if (intentarMarcarJugadaCentroAleatorio(tablero)) {
                        break;
                    } else if (intentarMarcarJugadaEsquinaBloqueante(tablero)) {
                        break;
                    }
                }

            case Tablero.NORMAL:
                if (!tablero.marcarJugada(1, 1, Tablero.O)) {
                    if (Tablero.logica[0][0] == Tablero.VACIO || Tablero.logica[0][2] == Tablero.VACIO || Tablero.logica[2][0] == Tablero.VACIO || Tablero.logica[2][2] == Tablero.VACIO) {
                        marcarJugadaEsquinaAleatoria(tablero);
                    } else {
                        jugadaRandom(tablero);
                    }
                }
                break;
        }

    }

     static boolean intentarMarcarJugadaEsquinaBloqueante(Tablero tablero) {
        if ((Tablero.logica[0][1] == Tablero.X && Tablero.logica[1][0] == Tablero.X)) {
            tablero.marcarJugada(0, 0, Tablero.O);
            return true;
        } else if ((Tablero.logica[0][1] == Tablero.X && Tablero.logica[1][2] == Tablero.X)) {
            tablero.marcarJugada(0, 2, Tablero.O);
            return true;
        } else if ((Tablero.logica[1][2] == Tablero.X && Tablero.logica[2][1] == Tablero.X)) {
            tablero.marcarJugada(2, 2, Tablero.O);
            return true;
        } else if ((Tablero.logica[1][0] == Tablero.X && Tablero.logica[2][1] == Tablero.X)) {
            tablero.marcarJugada(2, 0, Tablero.O);
            return true;
        }
        return false;
    }

    static boolean intentarMarcarJugadaCentroAleatorio(Tablero tablero) {
        if ((Tablero.logica[0][0] == Tablero.X && Tablero.logica[2][2] == Tablero.X) || (Tablero.logica[2][0] == Tablero.X && Tablero.logica[0][2] == Tablero.X)) {
            switch (new Random().nextInt(4)) {
                case 0:
                    tablero.marcarJugada(0, 1, Tablero.O);
                    break;
                case 1:
                    tablero.marcarJugada(1, 0, Tablero.O);
                    break;
                case 2:
                    tablero.marcarJugada(1, 2, Tablero.O);
                    break;
                case 3:
                    tablero.marcarJugada(2, 1, Tablero.O);
                    break;
            }
            return true;
        }
        return false;
    }

    static void marcarJugadaEsquinaAleatoria(Tablero tablero) {
        int i = 2, j = 2;
        switch (new Random().nextInt(4)) {
            case 0:
                i = 0;
                j = 0;
                break;
            case 1:
                i = 0;
                j = 2;
                break;
            case 2:
                i = 2;
                j = 0;
                break;
            default:
                break;
        }
        if (!tablero.marcarJugada(i, j, Tablero.O)) {
            marcarJugadaEsquinaAleatoria(tablero);
        }
    }
}
