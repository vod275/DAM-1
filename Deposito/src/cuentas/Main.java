package cuentas;


import cuentas.CCuenta;

public class Main {

    public static void main(String[] args) {
        CCuenta cuenta1;
        double saldoActual;

        cuenta1 = new CCuenta("Antonio López","1000-2365-85-1230456789",2500,0);
        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es"+ saldoActual );

        try {
            cuenta1.retirar(2300);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en cuenta");
            cuenta1.ingresar(695);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }
    
    public static void operativa_cuenta(CCuenta cuenta, double cantidad) throws Exception {
    System.out.println("Retirando " + cantidad + " de la cuenta...");
    cuenta.retirar(cantidad);

    // Aquí puedes agregar cualquier lógica adicional con la cantidad que desees
    // Por ejemplo, si quieres ingresar la misma cantidad retirada como interés, puedes hacer lo siguiente:
    System.out.println("Ingresando " + cantidad + " en la cuenta como interés...");
    cuenta.ingresar(cantidad);

    System.out.println("Operación realizada con éxito.");
   }

}
