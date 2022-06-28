

package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * 
 */
public class DsiCU23 {

    public static void main(String[] args) throws InterruptedException {
        /*CREACION DE LOS OBJETOS SIN BASE DE DATOS*/
        TipoRecursoTecnologico tRT1 = new TipoRecursoTecnologico("TODAS","");
        TipoRecursoTecnologico tRT2 = new TipoRecursoTecnologico("MICROSCOPIO","");
        TipoRecursoTecnologico tRT3 = new TipoRecursoTecnologico("BALANZA DE PRECISION","");
        TipoRecursoTecnologico tRT4 = new TipoRecursoTecnologico("RESONADOR MAGNETICO","");
        TipoRecursoTecnologico tRT5 = new TipoRecursoTecnologico("EQUIPAMENTO COMPUTO","");
        
        /*Agregando los tipos de recursos a un array para poder setearlos en la relacion de uno a muchos*/
        TipoRecursoTecnologico[] arrayTipos = new TipoRecursoTecnologico[5];
        arrayTipos[0] = tRT1;
        arrayTipos[1] = tRT2;
        arrayTipos[2] = tRT3;
        arrayTipos[3] = tRT4;
        arrayTipos[4] = tRT5;
        
        /*Creando las relaciones del tipo de recurso con un estado */
        Estado estado1 = new Estado("Disponible","","Recurso Tecnologico",true,false);
        Estado estado2 = new Estado("En Mantenimiento","","Recurso Tecnologico",true,false);
        Estado estado3 = new Estado("Inicio Mantenimiento Correctivo","","",true,false);
        Estado estado4 = new Estado("Baja Tecnica","","",true,false);
        Estado estado5 = new Estado("Baja Definitiva","","",true,false);
        
        Date desde = new Date(122,6,22,0,0);
        Date hasta = new Date(122,6,30,0,0);
        
        
        CambioEstadoRT cambioE1 = new CambioEstadoRT(desde,hasta,estado1);
        CambioEstadoRT cambioE2 = new CambioEstadoRT(desde,hasta,estado2);
        CambioEstadoRT cambioE3 = new CambioEstadoRT(desde,hasta,estado3);
        CambioEstadoRT cambioE4 = new CambioEstadoRT(desde,hasta,estado4);
        CambioEstadoRT cambioE5 = new CambioEstadoRT(desde,hasta,estado5);
        
        Marca marca1 = new Marca("Shidmazu");
        Marca marca2 = new Marca("Nikon");
        Marca marca3 = new Marca("General Electric");
        
        Modelo model = new Modelo("TX200",marca1);
        Modelo model2 = new Modelo("M1000",marca2);
        Modelo model3 = new Modelo("X8",marca3);
        
        
        
        
        CentroDeInvestigacion centro = new CentroDeInvestigacion("SERN",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        CentroDeInvestigacion centro2 = new CentroDeInvestigacion("NASA",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        CentroDeInvestigacion centro3 = new CentroDeInvestigacion("Space X",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        
        ArrayList <CentroDeInvestigacion> centrosArray = new ArrayList<>();
        centrosArray.add(centro);
        centrosArray.add(centro2);
        centrosArray.add(centro3);
        
        
        RecursoTecnologico rt1 = new RecursoTecnologico(1,null,null,null,null,null,model,tRT2,cambioE1,null,centro);
        RecursoTecnologico rt2 = new RecursoTecnologico(2,null,null,null,null,null,model2,tRT2,cambioE2,null,centro);        
        RecursoTecnologico rt3 = new RecursoTecnologico(3,null,null,null,null,null,model3,tRT2,cambioE3,null,centro2);
        RecursoTecnologico rt4 = new RecursoTecnologico(4,null,null,null,null,null,model2,tRT4,cambioE4,null,centro2); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt5 = new RecursoTecnologico(5,null,null,null,null,null,model2,tRT5,cambioE5,null,centro3); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt6 = new RecursoTecnologico(6,null,null,null,null,null,model3,tRT2,cambioE4,null,centro);
        RecursoTecnologico rt7 = new RecursoTecnologico(7,null,null,null,null,null,model,tRT3,cambioE3,null,centro2);
        RecursoTecnologico rt8 = new RecursoTecnologico(8,null,null,null,null,null,model3,tRT4,cambioE3,null,centro3);
        RecursoTecnologico rt9 = new RecursoTecnologico(9,null,null,null,null,null,model,tRT4,cambioE2,null,centro2);
        RecursoTecnologico rt10 = new RecursoTecnologico(10,null,null,null,null,null,model2,tRT2,cambioE1,null,centro2);
        
        ArrayList <RecursoTecnologico> rtCentro1= new ArrayList<>();
        rtCentro1.add(rt1);
        rtCentro1.add(rt2);
        rtCentro1.add(rt6);
        rtCentro1.add(rt10);
        
        centro.setRecursosTecnologicos(rtCentro1);       
        
        ArrayList <RecursoTecnologico> rtCentro2= new ArrayList<>();
        rtCentro2.add(rt3);
        rtCentro2.add(rt4);
        rtCentro2.add(rt7);
        rtCentro2.add(rt9);
        
        
        centro2.setRecursosTecnologicos(rtCentro2);
        
        ArrayList <RecursoTecnologico> rtCentro3= new ArrayList<>();
        rtCentro3.add(rt5);
        rtCentro3.add(rt9);
        
        centro3.setRecursosTecnologicos(rtCentro3);
        
        ArrayList<RecursoTecnologico> rec = new ArrayList<>();
        rec.add(rt1);
        rec.add(rt2);
        rec.add(rt3);
        rec.add(rt4);
        rec.add(rt5);
        rec.add(rt6);
        rec.add(rt7);
        rec.add(rt8);
        rec.add(rt9);
        rec.add(rt10);
        
        ArrayList <AsignacionCientificoDelCI> asignaciones = new ArrayList <>();
        
        PersonalCientifico cientifico1 = new PersonalCientifico(1,null,null,null,"juan@gmail.com",null,null);
        AsignacionCientificoDelCI asignacion1 = new AsignacionCientificoDelCI(null,null,cientifico1);
        
         asignaciones.add(asignacion1);       
        
        
        centro.setAsignacionCientifico(asignaciones);
        
        
        PersonalCientifico cientifico2 = new PersonalCientifico(2,null,null,null,null,null,null);
        PersonalCientifico cientifico3 = new PersonalCientifico(3,null,null,null,null,null,null);
        PersonalCientifico cientifico4 = new PersonalCientifico(4,null,null,null,null,null,null);
        
        
       ArrayList <Turno> turnos = new ArrayList <>();
       ArrayList <CambioEstadoTurno> cambioEstadoturnos = new ArrayList <>();
       ArrayList <CambioEstadoTurno> cambioEstadoturnos2 = new ArrayList <>();
       ArrayList <CambioEstadoTurno> cambioEstadoturnos3 = new ArrayList <>();
       
       
       Estado estado6 = new Estado("Disponible","","Recurso Tecnologico",true,false);
       Estado estado7 = new Estado("Pendiente Confirmacion","","Recurso Tecnologico",true,false);
       Estado estado8 = new Estado("Reservado","","Recurso Tecnologico",true,false);
       
       CambioEstadoTurno cambioturno1 = new CambioEstadoTurno(desde,hasta,estado6);
       CambioEstadoTurno cambioturno2 = new CambioEstadoTurno(desde,hasta,estado7);
       CambioEstadoTurno cambioturno3 = new CambioEstadoTurno(desde,hasta,estado8);
       
       cambioEstadoturnos.add(cambioturno1);
       cambioEstadoturnos2.add(cambioturno2);
       cambioEstadoturnos3.add(cambioturno3);
       
       
       
       
       Date horajunio1ini = new Date(122,6,28,10,0,0); /*disponible 1 julio*/
       Date horajunio2ini = new Date(122,6,30,14,0,0); 
       Date horajunio3ini = new Date(122,6,29,15,0,0); 
       
       Date horajunio1fin = new Date(122,7,2,10,0,0); /*disponible 1 julio*/
       Date horajunio2fin = new Date(122,7,8,14,0,0); 
       Date horajunio3fin = new Date(122,7,15,15,0,0); 
       
       
       Turno turno1 = new Turno(null,null,horajunio1ini,horajunio1fin,null);
       Turno turno2 = new Turno(null,null,horajunio2ini,horajunio2fin,null);
       Turno turno3 = new Turno(null,null,horajunio3ini,horajunio3fin,null);
       Turno turno4 = new Turno(null,null,null,null,null);
       Turno turno5 = new Turno(null,null,null,null,null);
        
       turno1.setCambioEstadoTurno(cambioEstadoturnos);
       turno2.setCambioEstadoTurno(cambioEstadoturnos2);
       turno3.setCambioEstadoTurno(cambioEstadoturnos3);
       
       /*Los recursos tecnologicos del recurso a*/
       turnos.add(turno1);
       turnos.add(turno2);
       turnos.add(turno3);
       
       rt1.setTurnos(turnos);
        
        
        
        
        
        /*Creamos la pantalla*/
        PantallaRegistrarReservaTurnoDeRT pantalla = new PantallaRegistrarReservaTurnoDeRT();
        
        /*Llamamos al metodo de interfaz*/
        
        
        
        
        /*Creamos al gestor y se le setean los tipos de recursos que conforman su relacion*/
        GestorRegistrarReservaTurnoDeRT gestor = new GestorRegistrarReservaTurnoDeRT();  
        /*Esto pasa nomas porq no tenemos base de datos, sino no se inicializarian y se traerian directamente*/
        gestor.setTiposDeRecursosTecnologicos(arrayTipos);
        gestor.setRecursosTecnologicos(rec);
        
        /*Inicia el Caso de Uso*/
        
        while(pantalla.getBtnOpcionReservarTurnoDeRT() == 0){
            pantalla.habilitarPantalla();
        }
        /*Sale del bucle si se presiona el boton que setea la opcion btn reserva en 1*/
        if(pantalla.getBtnOpcionReservarTurnoDeRT() == 1){
            /*DEVUELVE UN ARRAY QUE CONTIENE TODOS LOS TIPOS DE RECURSO POSIBLES*/
            ArrayList <String> cmbTiposDeRecursos = gestor.opcionReservaTurnoDeRT(pantalla.getBtnOpcionReservarTurnoDeRT());
            /*Declaro un string*/
            String seleccion = new String();
            /*Declaro el array que contendra los recursos de tipo elegido*/
            ArrayList<RecursoTecnologico> recursos = new ArrayList <>();   
            /*ENTRA EN UN CICLO PORQ SI ELIGE UN TIPO DE RECURSO QUE NO SE PUEDE RESERVAR ENTONCES VUELVE A PEDIR QUE SELECCIONES UN NUEVO TIPO*/
            while(recursos.size() == 0){     
                /*Llamo a la interfaz que te hace seleccionar un tipo de producto*/
                seleccion = pantalla.mostrarTiposDeRecursos(cmbTiposDeRecursos);
                
                /*Mando al gestor para que pueda obtener todos los recursos con el tipo pasado por parametro*/
                recursos = gestor.buscarRTDeTipoSeleccionado(seleccion);
                
            }
            /*Comprobacion de que lo que se selecciona en el formulario se devuelve*/
            System.out.print(seleccion);
            /*LE PASA LOS RECURSOS A LA PANTALLA*/
            pantalla.setListaRT(recursos);
            
            /*PRUEBA DE QUE EL FILTRO POR TIPOS ESTA FUNCIONANDO, si elegis microscopio trae 1,2,3 y 6 no lo trae porq es baja tecnica*/
            /*
            for(int i=0;i<pantalla.getListaRT().size();i++){
                System.out.print(pantalla.getListaRT().get(i).toString());
            
            }
            
            /*Buscar y obtener los datos de los recursos, ACA NO SE SI DEVOLVERIA UN ARRAY DE RECURSOS PORQUE TIENE Q CONTENER EL CENTRO AL QUE PERTENECE */
            ArrayList<RecursoTecnologico> recursosAll = gestor.buscarInformacionRecursosTecnologicos(recursos);
           /*OBTENIENDO DATOS PARA VER COMO SE PASAN A LA INTERFAZ PARA AGRUPARLOS POR EL CENTRO*/
            for(int i=0;i<recursosAll.size();i++){
                System.out.print(recursosAll.get(i).toString());           
            }
            
            /*HAY QUE VER COMO SE IMPLEMENTA LA DEPENDENCIA PARA PODER SABER Q RECURSOS TIENE UN CENTRO, ENTONCES LE MANDAS O UN ARRAY Q TIENE EL CENTRO O LOS CENTROS POR SEPARADOS*/
            
            gestor.agruparRTPorCI();
            /*setea todos los centros que existen en un array list*/
            pantalla.setCentrosInvestigacion(centrosArray);
            /*llama a la pantalla y esta o crea una nueva gui q muestre todos los recursos agrupados y espera a q selecciones una para setearlo como recurso seleccionado
            ESTE METODO TERMINA HACIENDO UN MONTON DE PASOS Y MENSAJES DEL DIAGRAMA, NO ESTA AGRUPANDO COMO TAL PERO SI VA A MOSTRAR LOS RECURSOS SEGUN EL CENTRO Q TIENEN,
            TENDRIAMOS QUE VER SI ES NECESARIO CAMBIAR LOS METODOS PARA Q HAGAN COSAS O QUE HACER
            */
            pantalla.mostrarRTAgrupados(recursosAll);
            
            /*RECURSO SELECCIONADO POR EL USUARIO*/
            
            gestor.setRecursoTecnologicoSeleccionado(pantalla.getRecursoSeleccionado());
            gestor.setUsuarioLogueado(cientifico1);
            boolean estaLogueado = gestor.buscarUsuarioLogueado(cientifico1);
            String correoInstitucionalCientifico = gestor.verificarCIDeCientifico(cientifico1);
            
            
            
            System.out.print("---" + correoInstitucionalCientifico+"-----");
            
            
            /*Obtiene la hora actual del sistema*/
            Date horaActual = gestor.obtenerFechaYHoraActual();
            System.out.print(horaActual);
            
            gestor.setFechaActual(horaActual);
            /*TURNOS*/
            gestor.obtenerTurnosDelRTSeleccionado();
            
            /*YA TENGO LOS TURNOS*/
            
            pantalla.mostrarTurnos(gestor.getTurnoDelRT());
            
            
            
            
            
            
            /*LA PARTE DEL AMBITO*/
            String amb = "recurso tecnologico";
            
            //gestor.reservarTurnoDeRT(amb);
            
            
            /* Lo que muestra recursosAll
            for(int i=0;i<recursosAll.size();i++){
                System.out.print(recursosAll.get(i) + " ");
            
            }
            */
            
            
            
            
            
            
            
        }
        else{
            System.out.print("Funcion aun no desarrollada");
        }
                
        
        
        
        
    }
}
