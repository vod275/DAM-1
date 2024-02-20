package cuentas;


import cuentas.CCuenta;

 
public class Main {

    /**
    * Metodo main
    * @param args los argumentos de la clase main
    */
    public static void main(String[] args) {
    CCuenta cuenta1;

    cuenta1 = new CCuenta("Antonio López", "1000-2365-85-1230456789", 2500, 0);
    cuenta1.operativa_cuenta();
}
}
