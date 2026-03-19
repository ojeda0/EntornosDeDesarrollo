package gestorNotas;

public class GestorNotas {

    private String nombreAlumno;
    private double n1;
    private double n2;
    private double n3;

    public GestorNotas(String nombreAlumno, double n1, double n2, double n3) {
        this.nombreAlumno = nombreAlumno;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        if (n1 < 0 || n1 > 10) {
            throw new IllegalArgumentException("La nota 1 debe estar entre 0 y 10");
        }
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        if (n2 < 0 || n2 > 10) {
            throw new IllegalArgumentException("La nota 2 debe estar entre 0 y 10");
        }
        this.n2 = n2;
    }

    public double getN3() {
        return n3;
    }

    public void setN3(double n3) {
        if (n3 < 0 || n3 > 10) {
            throw new IllegalArgumentException("La nota 3 debe estar entre 0 y 10");
        }
        this.n3 = n3;
    }

    public double media() {
        double r = (n1 + n2 + n3) / 3;
        return r;
    }

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

    public String resumen() {
        String texto = "";
        texto = texto + "Alumno: " + nombreAlumno + "\n";
        texto = texto + "Nota 1: " + n1 + "\n";
        texto = texto + "Nota 2: " + n2 + "\n";
        texto = texto + "Nota 3: " + n3 + "\n";
        texto = texto + "Media: " + this.media() + "\n";
        texto = texto + "Resultado: " + this.resultado() + "\n";

        if (haySuspensa() == true) {
            texto = texto + "Tiene alguna nota suspensa.\n";
        } else {
            texto = texto + "No tiene notas suspensas.\n";
        }

        return texto;
    }

    public static void main(String[] args) {
        GestorNotas g = new GestorNotas("Ana", 7, 8, 6);
        System.out.println(g.resumen());
    }
}