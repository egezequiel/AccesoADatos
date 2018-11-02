/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.newpackage;

/**
 *
 * @author programador
 */
public class Cursada {
private int nota;
private int id=-1;
private Alumno alumno;
private Materia materia;

    public Cursada(int nota, int id, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
    }
public Cursada(int nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        
        this.alumno = alumno;
        this.materia = materia;
    }
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId_cursada() {
        return id;
    }

    public void setId_cursada(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    
}
