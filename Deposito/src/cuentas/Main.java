package cuentas;


import cuentas.CCuenta;

public class Main {

    public static void main(String[] args) {
    CCuenta cuenta1;

    cuenta1 = new CCuenta("Antonio López", "1000-2365-85-1230456789", 2500, 0);
    
    // Llama al método operativa_cuenta
    cuenta1.operativa_cuenta();
}
}
