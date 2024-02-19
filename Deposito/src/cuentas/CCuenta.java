package cuentas;

/**
 * Clase para representar una cuenta bancaria.
 */
public class CCuenta {

    private String nombre; // Nombre del titular de la cuenta
    private String cuenta; // Número de cuenta
    private double saldo; // Saldo actual de la cuenta
    private double tipoInterés; // Tipo de interés aplicado a la cuenta

    /**
     * Constructor por defecto de la clase CCuenta.
     */
    public CCuenta() {
    }

    /**
     * Constructor con parámetros de la clase CCuenta.
     * @param nom Nombre del titular de la cuenta.
     * @param cue Número de cuenta.
     * @param sal Saldo inicial de la cuenta.
     * @param tipo Tipo de interés aplicado a la cuenta.
     */
    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInterés = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoInterés() {
        return tipoInterés;
    }

    public void setTipoInterés(double tipoInterés) {
        this.tipoInterés = tipoInterés;
    }

    /**
     * Método para obtener el saldo actual de la cuenta.
     * @return El saldo actual de la cuenta.
     */
    public double estado() {
        return saldo;
    }

    /**
     * Método para ingresar una cantidad en la cuenta.
     * @param cantidad La cantidad a ingresar.
     * @throws Exception Si la cantidad es negativa.
     */
    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        saldo = saldo + cantidad;
    }

    /**
     * Método para retirar una cantidad de la cuenta.
     * @param cantidad La cantidad a retirar.
     * @throws Exception Si la cantidad es negativa o superior al saldo disponible.
     */
    public void retirar(double cantidad) throws Exception {
        if (cantidad <= 0)
            throw new Exception("No se puede retirar una cantidad negativa");
        if (estado() < cantidad)
            throw new Exception("No se hay suficiente saldo");
        saldo = saldo - cantidad;
    }
    
    public void operativa_cuenta() {
    double saldoActual;

    saldoActual = estado();
    System.out.println("El saldo actual es " + saldoActual);

    try {
        retirar(2300);
    } catch (Exception e) {
        System.out.print("Fallo al retirar");
    }
    try {
        System.out.println("Ingreso en cuenta");
        ingresar(695);
    } catch (Exception e) {
        System.out.print("Fallo al ingresar");
    }
}
}
