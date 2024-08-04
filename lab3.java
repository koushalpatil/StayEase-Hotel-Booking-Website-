import java.math.BigInteger;

public class lab3 {

    public static BigInteger modExp(BigInteger base, BigInteger exp, BigInteger mod) {
        return base.modPow(exp, mod);
    }

    public static BigInteger modInverse(BigInteger a, BigInteger m) {
        return a.modInverse(m);
    }

    public static void main(String[] args) {
        
  
        BigInteger p = new BigInteger("11");  
        BigInteger q = new BigInteger("19");  

        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        
        BigInteger e = new BigInteger("5");
        while (e.compareTo(phi) < 0) {
            if (e.gcd(phi).equals(BigInteger.ONE)) {
                break;
            }
            e = e.add(BigInteger.ONE);
        }

        BigInteger d = modInverse(e, phi);
        if (d == null) {
            System.out.println("Modular inverse does not exist.");
            return;
        }

       
        BigInteger msg = new BigInteger("123");

        BigInteger c = modExp(msg, e, n);
        System.out.println("Message data = " + msg);
        System.out.println("Encrypted data = " + c);

        BigInteger m = modExp(c, d, n);
        System.out.println("Original Message Sent = " + m);
    }
}
