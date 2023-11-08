public class RUN {
    public static void main(String[] args) {
        Bil saab = new Saab95();
        saab.move();
        Bil volvo = new Volvo240();
        System.out.println(volvo.nrDoors);
        System.out.println(volvo.enginePower);
        
    }
}
