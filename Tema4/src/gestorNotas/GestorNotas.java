package gestorNotas;

/**
 * Clase encargada de registrar y gestionar las notas de los alumnos.
 * Permite almacenar sus datos, calcular medias y generar resumenes.
 *
 * @author Abraham Teba Ojeda
 */
public class GestorNotas {

	/**
     * Nombre del alumno registrado.
     */
    private String nombreAlumno;
    
    /**
     * Nota primera evaluación.
     */
    private double n1;
    
    /**
     * Nota segunda evaluación.
     */
    private double n2;
    
    /**
     * Nota tercera evaluación.
     */
    private double n3;

    /**
     * Constructor de la clase para registrar un alumno.
     *
     * @param nombreAlumno Nombre del alumno.
     * @param n1 Nota primera evaluación.
     * @param n2 Nota segunda evaluación.
     * @param n3 Nota tercera evaluación.
     */
    public GestorNotas(String nombreAlumno, double n1, double n2, double n3) {
        this.nombreAlumno = nombreAlumno;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    /**
     * Devuelve el nombre del alumno.
     *
     * @return El nombre del alumno.
     */
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    /**
     * Modifica el nombre del alumno.
     *
     * @param nombreAlumno El nuevo nombre.
     */
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    /**
     * Devuelve la nota de la primera evaluación.
     *
     * @return La nota de la primera evaluación.
     */
    public double getN1() {
        return n1;
    }

    /**
     * Modifica la nota de la primera evaluación.
     *
     * @param n1 La nota de la primera evaluación.
     * @throws IllegalArgumentException Si la nota no está entre 0 y 10.
     */
    public void setN1(double n1) {
        if (n1 < 0 || n1 > 10) {
            throw new IllegalArgumentException("La nota 1 debe estar entre 0 y 10");
        }
        this.n1 = n1;
    }

    /**
     * Devuelve la nota de la segunda evaluación.
     *
     * @return La nota de la segunda evaluación.
     */
    public double getN2() {
        return n2;
    }

    /**
     * Modifica la nota de la segunda evaluación.
     *
     * @param n2 La nota de la segunda evaluación.
     * @throws IllegalArgumentException Si la nota no está entre 0 y 10.
     */
    public void setN2(double n2) {
        if (n2 < 0 || n2 > 10) {
            throw new IllegalArgumentException("La nota 2 debe estar entre 0 y 10");
        }
        this.n2 = n2;
    }

    /**
     * Devuelve la nota de la tercera evaluación.
     *
     * @return La nota de la tercera evaluación.
     */
    public double getN3() {
        return n3;
    }

    /**
     * Modifica la nota de la tercera evaluación.
     *
     * @param n3 La nota de la tercera evaluación.
     * @throws IllegalArgumentException Si la nota no está entre 0 y 10.
     */
    public void setN3(double n3) {
        if (n3 < 0 || n3 > 10) {
            throw new IllegalArgumentException("La nota 3 debe estar entre 0 y 10");
        }
        this.n3 = n3;
    }

    /**
     * Calcula la media aritmética de las tres notas del alumno
     *
     * @return La media calculada.
     */
    public double media() {
        double r = (n1 + n2 + n3) / 3;
        return r;
    }

    /**
     * Determina el resultado en base a la nota media.
     *
     * @return El string correspondiente.
     */
    public String resultado() {
    	
        double m = this.media();
        
        if(m < 5) {
        	return "Suspenso";
        }
        
        if(m < 6) {
        	return "Aprobado";
        }
        
        if(m < 7) {
        	return "Bien";
        }
        
        if(m < 9) {
        	return "Notable";
        }
        
        return "Sobresaliente";
       
    }

    /**
     * Comprueba si hay alguna nota suspensa.
     *
     * @return true si hay alguna nota menor a 5, false en caso contrario.
     */
    public boolean haySuspensa() {
        if (n1 < 5) {
            return true;
        }
        if (n2 < 5) {
            return true;
        }
        if (n3 < 5) {
            return true;
        }
        return false;
    }

    /**
     * Genera el resumen final del alumno
     *
     * @return Una texto con el resumen estructurado.
     */
    public String resumen() {
    	
    	String texto = String.format(
    			"Alumno: %s\n"
                + "Nota 1: %.2f\n"
                + "Nota 2: %.2f\n"
                + "Nota 3: %.2f\n"
                + "Media: %.2f\n"
                + "Resultado: %s\n", this.nombreAlumno, this.n1, this.n2, this.n3, 
                this.media(), this.resultado()
        );
      
        if (haySuspensa()) {
            texto = texto + "Tiene alguna nota suspensa.\n";
        } else {
            texto = texto + "No tiene notas suspensas.\n";
        }

        return texto;
    }

    /**
     * Método principal de ejecución (main).
     *
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        GestorNotas g = new GestorNotas("Ana", 7, 8, 6);
        System.out.println(g.resumen());
    }
}